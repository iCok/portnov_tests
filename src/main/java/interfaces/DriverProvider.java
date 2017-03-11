package interfaces;

import org.openqa.selenium.WebDriver;

/**
 * Describe the different way to get driver
 */
public interface DriverProvider {
    WebDriver getDriver();
}
