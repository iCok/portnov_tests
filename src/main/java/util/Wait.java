package util;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import selenide.com.company.ebay.SelenideDriverProvider;

import java.util.concurrent.TimeUnit;

/**
 * Explicit waiter with static method
 */
public final class Wait extends FluentWait<WebDriver> implements org.openqa.selenium.support.ui.Wait<WebDriver> {

    public Wait(WebDriver input) {
        super(input);
    }

    public Wait() {
        this(new SelenideDriverProvider().getDriver());
    }


    public static Wait withTimeout(long timeoutInSeconds) {
        return (Wait) new Wait()
                .withTimeout(timeoutInSeconds, TimeUnit.SECONDS)
                .ignoring(StaleElementReferenceException.class);
    }
}
