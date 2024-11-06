package core;

import constants.GlobalConfig;
import model.RemoteCapabilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.JsonUtil;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * DriverChrome class to provide a WebDriver instance for Chrome. Supports both local and remote
 * execution based on configuration.
 *
 * @author PhucDN7
 * @since 2024-10-09
 */
public class DriverChrome implements DriverWeb {
  private static final Logger logger = LogManager.getLogger(DriverChrome.class);

  /**
   * Returns a WebDriver instance for Chrome. Default: local execution. If IS_GRID flag is set to
   * true, configure for remote execution.
   *
   * @return WebDriver instance for Chrome
   */
  @Override
  public WebDriver getDriver() {
    // Retrieve remote capabilities from the JSON configuration file
    RemoteCapabilities remoteCapabilities =
        JsonUtil.getInstance()
            .convertFileJsonToObject(GlobalConfig.REMOTE_JSON, RemoteCapabilities.class);

    WebDriver driver = null;
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--disable-infobars");

    try {
      if (GlobalConfig.IS_GRID) {
        // Configure proxy settings for remote execution
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(remoteCapabilities.getProxy());
        proxy.setSslProxy(remoteCapabilities.getProxy());
        chromeOptions.setProxy(proxy);

        // Initialize RemoteWebDriver with the remote URL and Chrome options
        URL remoteURL = new URL(remoteCapabilities.getRemoteUrl());
        driver = new RemoteWebDriver(remoteURL, chromeOptions);
      } else {
        // Initialize local ChromeDriver with Chrome options
        driver = new ChromeDriver(chromeOptions);
      }
    } catch (MalformedURLException e) {
      logger.error("MalformedURLException occurred: ", e);
    }
    return driver;
  }
}
