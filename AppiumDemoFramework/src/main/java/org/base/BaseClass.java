package org.base;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {
    protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    public  String androidDeviceName;
    public  String androidAppFileName;
    public  String iosDeviceName;
    public  String iosAppFileName;
    public String platform;

    public AppiumDriver getdriver() {
        return driver.get();
    }

    public void androidLocalVirtualDevice() throws MalformedURLException {
        try {
            UiAutomator2Options capAndroid = new UiAutomator2Options();
            capAndroid.setCapability("automationName", "UiAutomator2");
            capAndroid.setCapability("deviceName", androidDeviceName);
            capAndroid.setCapability("app", System.getProperty("user.dir") + androidAppFileName);
            driver.set(new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capAndroid));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void iosLocalVirtualDevice() throws MalformedURLException {
        try {
            UiAutomator2Options capIos = new UiAutomator2Options();
            capIos.setCapability("platform", "IOS");
            capIos.setCapability("automationName", "XCUITest");
            capIos.setCapability("deviceName", iosDeviceName);
            capIos.setCapability("app", System.getProperty("user.dir")+ iosAppFileName);
            driver.set(new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capIos));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

