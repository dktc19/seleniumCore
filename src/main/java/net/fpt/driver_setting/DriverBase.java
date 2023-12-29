package net.fpt.driver_setting;

import net.fpt.listeners.ExtentTestNGIReporter;
import net.fpt.listeners.ScreenShotListener;
import net.fpt.listeners.CustomizedEmailableIReport;
import net.fpt.listeners.LogTestNGListener;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners({ScreenShotListener.class,
        ExtentTestNGIReporter.class,
        LogTestNGListener.class,
        CustomizedEmailableIReport.class
})
public class DriverBase {
    public static final List<DriverFactory> webDriverThreadPool= Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<DriverFactory> driverThread;
    static final Logger logger = LoggerFactory.getLogger(DriverBase.class);

    @BeforeSuite(alwaysRun = true)
    public static void instantiateDriverObject(){
        logger.debug("Before suite add webdriver in to thread pool");
        driverThread = ThreadLocal.withInitial(() -> {
            DriverFactory webDriverThread = new DriverFactory();
            webDriverThreadPool.add(webDriverThread);
            return webDriverThread;
        });
    }

    public static RemoteWebDriver getDriver() throws MalformedURLException {
        logger.debug("Call getDriver");
        return driverThread.get().getDriver();
    }


/*    @AfterMethod(alwaysRun = true)
    public static void clearCookies() {
        try {
            getDriver().manage().deleteAllCookies();
        }catch (Exception ex){
            System.out.println("Unable to delete cookies: "+ ex.getCause());
        }
    }*/

    @AfterSuite(alwaysRun = true)
    public static void closeDriverObjects() {
        logger.debug("After suite close all driver");
        for (DriverFactory webDriverThread : webDriverThreadPool) {
            webDriverThread.quitDriver();
        }
    }

}
