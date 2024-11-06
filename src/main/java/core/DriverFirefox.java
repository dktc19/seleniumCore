package core;

import constants.GlobalConfig;
import model.RemoteCapabilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.JsonUtil;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * DriverFirefox class to provide a WebDriver instance for Firefox. Supports both local and remote
 * execution based on configuration.
 *
 * @author PhucDN7
 * @since 2024-10-09
 */
public class DriverFirefox implements DriverWeb {
  private static final Logger logger = LogManager.getLogger(DriverFirefox.class);

  /**
   * Returns a WebDriver instance for Firefox. Default: local execution. If IS_GRID flag is set to
   * true, configure for remote execution.
   *
   * @return WebDriver instance for Firefox
   */
  @Override
  public WebDriver getDriver() {
    // Retrieve remote capabilities from the JSON configuration file
    RemoteCapabilities remoteCapabilities =
        JsonUtil.getInstance()
            .convertFileJsonToObject(GlobalConfig.REMOTE_JSON, RemoteCapabilities.class);

    WebDriver driver = null;
    FirefoxOptions firefoxOptions = new FirefoxOptions();

    try {
      if (GlobalConfig.IS_GRID) {
        // Configure proxy settings for remote execution
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(remoteCapabilities.getProxy());
        proxy.setSslProxy(remoteCapabilities.getProxy());
        firefoxOptions.setProxy(proxy);

        // Initialize RemoteWebDriver with the remote URL and Firefox options
        URL remoteURL = new URL(remoteCapabilities.getRemoteUrl());
        driver = new RemoteWebDriver(remoteURL, firefoxOptions);
      } else {
        // Initialize local FirefoxDriver with Firefox options
        driver = new FirefoxDriver(firefoxOptions);
      }
    } catch (MalformedURLException e) {
      logger.error("MalformedURLException occurred: ", e);
    }
    return driver;
  }
}
