package selenide.com.company.ebay;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.Optional;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Cok on 11.03.2017.
 */
public class CartPageItems {

    private CartPageItems() {

    }

    public Optional<CartPageItem> getByName(String name) {

        CartPageItem cartPageItem = CartPageItem.of(name);

        if (cartPageItem.isPresent()) {
            return Optional.of(cartPageItem);
        } else {
            return Optional.empty();
        }
    }

    public static CartPageItems create() {
        return new CartPageItems();
    }
}
