package core;

import constants.Browser;
import org.openqa.selenium.WebDriver;

/**
 * DriverManager class is responsible for managing instances of WebDriver for various browser types.
 * It ensures thread safety in a multithreaded environment by utilizing ThreadLocal.
 *
 * @author PhucDN7
 * @since 2024-10-09
 */
public class DriverManager {
  private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

  /**
   * Returns the WebDriver instance associated with the current thread.
   *
   * @return WebDriver instance for the current thread
   */
  public static synchronized WebDriver getWebDriverThreadLocal() {
    return webDriverThreadLocal.get();
  }

  /**
   * Creates a WebDriver instance based on the specified platform and maximizes the window This
   * instance is then associated with the current thread.
   *
   * @param platform the type of browser for which to create the WebDriver instance
   */
  public static void createDriver(String platform) {
    Browser browser = Browser.valueOf(platform.toUpperCase());
    WebDriver driver =
        switch (browser) {
          case CHROME -> {
            DriverWeb driverChrome = new DriverChrome();
            yield driverChrome.getDriver();
          }
          case FIREFOX -> {
            DriverWeb driverFirefox = new DriverFirefox();
            yield driverFirefox.getDriver();
          }
          default -> throw new RuntimeException("Unknown driver type: " + platform);
        };
    driver.manage().window().maximize();
    webDriverThreadLocal.set(driver);
  }

  /**
   * Terminate WebDriver instance associated with the current thread and removes it from
   * ThreadLocal.
   */
  public static void quitDriver() {
    if (webDriverThreadLocal.get() != null) {
      webDriverThreadLocal.get().quit();
      webDriverThreadLocal.remove();
    }
  }
}
