package config;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static config.TestPropertiesReader.getProperty;
import static additionalParameters.AdditionalCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.SAFARI;

public class DriverSetup {
    private static AppiumDriver appiumDriver;
    private static WebDriverWait webDriverWait;

    private static String platformName;
    private static String deviceName;
    private static String pathApk;
    private static String apkName;
    private static String driverUrl;
    private static String webUrl;

    private DriverSetup() {
    }

    public static void setProperties() throws IOException {
        platformName = getProperty(PLATFORM_NAME);
        deviceName = getProperty(DEVICE_NAME);
        pathApk = getProperty(PATH_APK);
        apkName = getProperty(APK_NAME);
        driverUrl = getProperty(DRIVER_URL);
        webUrl = getProperty(WEB_URL);
    }

    public static void prepareDriver() throws MalformedURLException {
        String browserName;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (platformName) {
            case ANDROID:
                capabilities.setCapability(DEVICE_NAME, deviceName);
                browserName = CHROME;
                break;
            case iOS:
                browserName = SAFARI;
                break;
            default:
                throw new IllegalArgumentException("Unknown mobile platform: " + platformName);
        }
        capabilities.setCapability(PLATFORM_NAME, platformName);

        if (apkName != null && webUrl == null) {
            // Native:
            File appDir = new File(pathApk);
            File app = new File(appDir, apkName);
            capabilities.setCapability(APP, app.getAbsolutePath());
        } else if (webUrl != null && apkName == null) {
            // Web:
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
