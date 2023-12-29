package net.fpt.driver_setting;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public enum DriverType implements DriverSetup{
    FIREFOX {
        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            FirefoxProfile profile = new FirefoxProfile();

            //Allow local pop-up
            profile.setPreference("geo.prompt.testing", true);
            profile.setPreference("geo.prompt.testing.allow", true);


            FirefoxOptions options = new FirefoxOptions();
            //options.merge(capabilities);package org.openqa.selenium.chrome
            options.setHeadless(HEADLESS);
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
            options.setProfile(profile);
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);


            if(gridEnabled){
                URL seleniumGridURL = null;
                try {
                    seleniumGridURL = new URL(System.getProperty("gridURL"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                String desiredBrowserVersion= System.getProperty("desiredBrowserVersion");
                String desiredPlatform = System.getProperty("desiredPlatform");
                logger.info("Connecting to Selenium Grid: " + seleniumGridURL+"|"+desiredBrowserVersion +"|"+ desiredPlatform);

                if (null != desiredPlatform && !desiredPlatform.isEmpty()) {
                    options.setCapability("platformName",Platform.valueOf(desiredPlatform.toUpperCase()));
                }

                if (null != desiredBrowserVersion && !desiredBrowserVersion.isEmpty()) {
                    options.setCapability("browserVersion",desiredBrowserVersion);
                }

                options.setCapability("browserName","firefox");

                if (proxyEnabled) {
                    logger.info("Proxy enabled: " + proxyDetails);
                    Proxy proxy = new Proxy();
                    proxy.setHttpProxy(proxyDetails);
                    proxy.setSslProxy(proxyDetails);
                    options.setCapability("proxy", proxy);
                }

                return new RemoteWebDriver(seleniumGridURL, options);
            } else {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(options);
            }
        }
    },
    FIREFOX_UNTRUECERTS {
        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            FirefoxProfile profile = new FirefoxProfile();

            //cho phép localtion pop-up
            profile.setPreference("geo.prompt.testing", true);
            profile.setPreference("geo.prompt.testing.allow", true);
            profile.setPreference("geo.enabled", true);
            profile.setPreference("geo.wifi.uri", "data:application/json,{\"status\":\"OK\",\"accuracy\":10.0,\"location\":{\"lat\":45.0,\"lng\":-122.0}}");
            //profile.setPreference("geo.wifi.uri", System.getProperty("user.dir") + "/src/test/java/test_data_files/geoLocation.json");

            FirefoxOptions options = new FirefoxOptions();
            options.merge(capabilities);
            options.setAcceptInsecureCerts(false);
            options.setProfile(profile);

            return new FirefoxDriver(options);
        }
    },
    CHROME {
        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            HashMap<String, Object> chromePreferences = new HashMap<>();
            chromePreferences.put("profile.password_manager_enabled"
                    ,false);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.merge(capabilities);

            chromeOptions.addArguments("--no-default-browser-check");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.setExperimentalOption("prefs",
                    chromePreferences);


            if(gridEnabled){
                URL seleniumGridURL = null;
                try {
                    seleniumGridURL = new URL(System.getProperty("gridURL"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                String desiredBrowserVersion= System.getProperty("desiredBrowserVersion");
                String desiredPlatform = System.getProperty("desiredPlatform");
                logger.info("Connecting to Selenium Grid: " + seleniumGridURL+"|"+desiredBrowserVersion +"|"+ desiredPlatform);

                if (null != desiredPlatform && !desiredPlatform.isEmpty()) {
                    chromeOptions.setCapability("platformName",Platform.valueOf(desiredPlatform.toUpperCase()));
                }

                if (null != desiredBrowserVersion && !desiredBrowserVersion.isEmpty()) {
                    chromeOptions.setCapability("browserVersion",desiredBrowserVersion);
                }

                chromeOptions.setCapability("browserName","chrome");

                if (proxyEnabled) {
                    logger.info("Proxy enabled: " + proxyDetails);
                    Proxy proxy = new Proxy();
                    proxy.setHttpProxy(proxyDetails);
                    proxy.setSslProxy(proxyDetails);
                    chromeOptions.setCapability("proxy", proxy);
                }

                return new RemoteWebDriver(seleniumGridURL, chromeOptions);
            } else {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);
            }
        }
    },
    IE {
        public RemoteWebDriver
        getWebDriverObject(DesiredCapabilities
                                   capabilities) {
            InternetExplorerOptions options = new
                    InternetExplorerOptions();
            options.merge(capabilities);
            options.setCapability(CapabilityType.ForSeleniumServer.
                    ENSURING_CLEAN_SESSION, true);
            options.setCapability(InternetExplorerDriver.
                    ENABLE_PERSISTENT_HOVERING, true);
            options.setCapability(InternetExplorerDriver.
                    REQUIRE_WINDOW_FOCUS, true);
            return new InternetExplorerDriver(options);
        }
    },
    EDGE {
        public RemoteWebDriver
        getWebDriverObject(DesiredCapabilities
                                   capabilities) {
            EdgeOptions options = new EdgeOptions();
            options.merge(capabilities);
            return new EdgeDriver(options);
        }
    },
    SAFARI {
        public RemoteWebDriver
        getWebDriverObject(DesiredCapabilities
                                   capabilities) {
            SafariOptions options = new SafariOptions();
            options.merge(capabilities);
            return new SafariDriver(options);
        }
    },
    OPERA {
        public RemoteWebDriver
        getWebDriverObject(DesiredCapabilities
                                   capabilities) {
            OperaOptions options = new OperaOptions();
            options.merge(capabilities);
            return new OperaDriver(options);
        }
    };
    public final static boolean HEADLESS = Boolean.getBoolean("headless");
}
