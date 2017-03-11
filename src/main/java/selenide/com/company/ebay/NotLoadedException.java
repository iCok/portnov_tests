package selenide.com.company.ebay;

/**
 * Throw this exception when page was not loaded
 */
public class NotLoadedException extends Exception {
    public NotLoadedException(String message) {
        super(message);
    }
}
