package core;

import org.openqa.selenium.WebDriver;

/**
 * DriverWeb is an interface that defines a method to get a WebDriver instance. Implementing classes
 * should provide the logic to initialize and return a WebDriver instance for a specific browser.
 */
public interface DriverWeb {

  /**
   * Returns a WebDriver instance for a specific browser.
   *
   * @return WebDriver instance
   */
  WebDriver getDriver();
}
