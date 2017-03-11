package selenide.com.company.ebay;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Cok on 11.03.2017.
 */
public class CartPageItem {

    private final String name;

    private CartPageItem(String name) {
        this.name = name;
    }

    public static CartPageItem of(String name) {
        return new CartPageItem(name);
    }

    public boolean isPresent() {
        return $(withText(name)).is(Condition.exist);
    }
}
