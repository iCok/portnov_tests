package util;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;

/**
 * Created by Cok on 11.03.2017.
 */
public class Action {

    private final FluentWait<WebDriver> wait;

    private Action(FluentWait<WebDriver> wait) {
        this.wait = wait;
    }

    public static Action of(FluentWait<WebDriver> wait) {
        return new Action(wait);
    }

    /**
     *
     * @param function is an action that we should do until expected result is not showed
     * @param <T> expected result
     * @return expected result
     * @throws TimeoutException
     */
    public <T> T call(Function<WebDriver, T> function) throws TimeoutException {
        return wait.until((ExpectedCondition<T>) function::apply);
    }


    /**
     *
     * @param function is an action that we should do until expected result is not showed
     * @return true if succeed, false if not succeed during configured timeout
     */
    public boolean safeCall(Function<WebDriver, Boolean> function) {
        try {
            return call(function);
        } catch (TimeoutException timeout) {
            return false;
        }
    }
}
