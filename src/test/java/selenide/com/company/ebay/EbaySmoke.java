package selenide.com.company.ebay;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertTrue;

/**
 * Smoke tests to buy an item
 */
public class EbaySmoke {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "firefox";
    }

    @Test
    public void userShouldSeePriceOfItem() throws MalformedURLException, NotLoadedException {
        String url = "http://www.ebay.com/itm/Genuine-Apple-iPhone-6-4-7-Inch-16GB-A1586-Space-Grey-Australian-Stock-UNLOC-/271839171210";
        Selenide.open(new URL(url));

        BuyItem buyItem = BuyItem.getFromPage().waitToOpen();
        String price = buyItem.getPrice();
        //in application under test, you should know exactly what price test buyItem has.
        assertThat(price, is(equalTo("AU $929,00")));
    }

    @Test
    public void userShouldBeAbleAddItemToCart() throws MalformedURLException, NotLoadedException {
        String url = "http://www.ebay.com/itm/Genuine-Apple-iPhone-6-4-7-Inch-16GB-A1586-Space-Grey-Australian-Stock-UNLOC-/271839171210";
        Selenide.open(new URL(url));

        BuyItem buyItem = BuyItem.getFromPage().waitToOpen();
        CartPage cartPage = buyItem.addToCart().waitToOpen();
        CartPageItems cartPageItems = cartPage.getItems();
        Optional<CartPageItem> possibleItem = cartPageItems.getByName("Genuine Apple iPhone 6 4.7-Inch 16GB A1586 - Space Grey (Australian Stock) UNLOC");

        assertTrue(possibleItem.isPresent(), "Test Item was not added to cart");
    }
}
