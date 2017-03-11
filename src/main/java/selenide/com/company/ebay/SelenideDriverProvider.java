package selenide.com.company.ebay;

import com.codeborne.selenide.WebDriverRunner;
import interfaces.DriverProvider;
import org.openqa.selenium.WebDriver;

/**
 * Created by Cok on 10.03.2017.
 */
public final class SelenideDriverProvider implements DriverProvider {

    private WebDriver driver = WebDriverRunner.getWebDriver();

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
