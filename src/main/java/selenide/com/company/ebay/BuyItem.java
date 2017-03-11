package selenide.com.company.ebay;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.UIAssertionError;
import interfaces.DriverProvider;
import interfaces.PageWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Action;
import util.Wait;
import util.Timeouts;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Details which contains price, quantity, two buttons (buy, add to cart)
 */
public final class BuyItem implements PageWait<BuyItem> {
    private final WebDriver driver;

    public static BuyItem getFromPage() {
        return new BuyItem(new SelenideDriverProvider());
    }

    private BuyItem(DriverProvider driverProvider) {
        this.driver = driverProvider.getDriver();
    }

    public String getPrice() {
        //it will wait (by default 4 seconds) if element does not exist now and when element appears it will get text
        return $(By.cssSelector("#prcIsum")).getText();
    }


    public BuyItem waitToOpen() throws NotLoadedException {
        Timeouts timeouts = Timeouts.getDefault();
        boolean isLoaded = Action.of(Wait.withTimeout(timeouts.pageLoad)
                .ignoring(UIAssertionError.class))
                .safeCall(driver1 -> isLoaded());

        if (!isLoaded) throw new NotLoadedException("Buying details are not visible");
        return this;
    }


    public boolean isLoaded() {
        try {
            //good practice look for elements by text, because it changes seldom, unlike xpath, css.
            //if your site has support of several languages you just need to get text from data storage.
           return $(withText("Price")).is(Condition.exist);
        } catch (UIAssertionError error) {
            return false;
        }
    }

    public CartPage addToCart() {
        $(withText("Add to cart")).click();
        return new CartPage();
    }
}
