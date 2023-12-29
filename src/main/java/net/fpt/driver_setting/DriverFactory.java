package net.fpt.driver_setting;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;

public class DriverFactory {
    private RemoteWebDriver webDriver;
    private final DriverType selectedDriverType;

    private final String operatingSystem= System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");


    static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    public DriverFactory(){
        DriverType driverType= DriverType.FIREFOX;
        String browser = System.getProperty("browser").toUpperCase();
        logger.debug("Set browser "+ browser);
        try {
            driverType= DriverType.valueOf(browser);
            logger.debug("Get driver type "+ driverType);
        }catch (IllegalArgumentException ignored) {
            System.err.println("Unknown driver specified, defaulting to '" + driverType + "'...");
            logger.error("Unknown driver specified, defaulting to '" + driverType + "'...");
        } catch (NullPointerException ignored) {
            System.err.println("No driver specified, defaulting to '" + driverType + "'...");
            logger.error("No driver specified, defaulting to '" + driverType + "'...");
        }
        selectedDriverType = driverType;
    }

    public RemoteWebDriver getDriver() throws MalformedURLException {
        if(null==webDriver){
            instantiateWebDriver(selectedDriverType);
        }
        return  webDriver;
    }

    public void quitDriver(){
        if(null != webDriver){
            webDriver.quit();
            webDriver=null;
        }
    }
    private void instantiateWebDriver(DriverType driverType) throws MalformedURLException {
        logger.debug("Local Operating System: "+ operatingSystem);
        logger.debug("Local Architecture: " +
                systemArchitecture);
        logger.debug("Selected Browser: " +
                selectedDriverType);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        webDriver = driverType.getWebDriverObject(desiredCapabilities);
    }

}
