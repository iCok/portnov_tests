package selenide.com.company.ebay;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.UIAssertionError;
import interfaces.DriverProvider;
import interfaces.PageWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import util.Action;
import util.Wait;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Cok on 10.03.2017.
 */
public final class CartPage implements PageWait<CartPage> {

    private final WebDriver driver;

    public CartPage(DriverProvider driverProvider) {
        this.driver = driverProvider.getDriver();
    }

    public CartPage() {
        this(new SelenideDriverProvider());
    }

    public CartPageItems getItems() {
        return CartPageItems.create();
    }

    @Override
    public CartPage waitToOpen() throws NotLoadedException {
        FluentWait<WebDriver> wait = Wait.withTimeout(30).ignoring(UIAssertionError.class);
        boolean isLoaded = Action.of(wait).safeCall(driver1 -> isLoaded());
        if (!isLoaded) throw new NotLoadedException("Cart page was not loaded");
        return this;
    }

    @Override
    public boolean isLoaded() {
        return $(withText("Your eBay Shopping Cart")).is(Condition.exist);
    }
}
