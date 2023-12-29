package net.fpt.driver_setting;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface DriverSetup {
    public final boolean gridEnabled=Boolean.getBoolean("gridEnabled");
    public final boolean proxyEnabled = Boolean.getBoolean("proxyEnabled");
    public final String proxyHostname = System.getProperty("proxyHost");
    public final Integer proxyPort = Integer.getInteger("proxyPort");
    public final String proxyDetails = String.format("%s:%d", proxyHostname, proxyPort);

    static final Logger logger = LoggerFactory.getLogger(DriverSetup.class);

    RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities);
}
