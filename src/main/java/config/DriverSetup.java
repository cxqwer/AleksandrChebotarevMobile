package config;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static additionalParameters.AdditionalCapabilityType.*;
import static config.TestPropertiesReader.getProperty;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.MobileCapabilityType.UDID;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.SAFARI;

/**
 * Initialize driver with appropriate capabilities depending on platform and type of testing
 **/

public class DriverSetup {
    private static AppiumDriver appiumDriver;
    private static WebDriverWait webDriverWait;

    private static String platformName;
    private static String udid;
    private static String pathApk;
    private static String driverUrl;
    public static String webUrl;
    private static String appPackage;
    private static String appActivity;

    private DriverSetup() {
    }

    public static void setProperties() throws IOException {
        platformName = getProperty(PLATFORM_NAME);
        udid = getProperty(UDID);
        pathApk = getProperty(PATH_APK);
        driverUrl = getProperty(DRIVER_URL);
        webUrl = getProperty(WEB_URL);
        appPackage=getProperty(APP_PACKAGE);
        appActivity=getProperty(APP_ACTIVITY);
    }

    public static void prepareDriver() throws MalformedURLException {
        String browserName;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (platformName) {
            case ANDROID:
                browserName = CHROME;
                break;
            case iOS:
                browserName = SAFARI;
                break;
            default:
                throw new IllegalArgumentException("Unknown mobile platform: " + platformName);
        }

        capabilities.setCapability(UDID, udid);
        capabilities.setCapability(PLATFORM_NAME, platformName);

        if (pathApk != null && webUrl == null) {
            capabilities.setCapability(APP_PACKAGE, appPackage);
            capabilities.setCapability(APP_ACTIVITY, appActivity);
        } else if (webUrl != null && pathApk == null) {
            capabilities.setCapability(BROWSER_NAME, browserName);
        } else {
            throw new IllegalArgumentException("Unknown type of mobile app");
        }

        appiumDriver = new AppiumDriver(new URL(driverUrl), capabilities);
        webDriverWait = new WebDriverWait(appiumDriver, 10);

    }

    public static AppiumDriver driver() throws MalformedURLException {
        if (appiumDriver == null) prepareDriver();
        return appiumDriver;
    }

    public static WebDriverWait driverWait() throws MalformedURLException {
        if (webDriverWait == null) prepareDriver();
        return webDriverWait;
    }

}
