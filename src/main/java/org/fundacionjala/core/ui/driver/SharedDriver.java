package org.fundacionjala.core.ui.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SharedDriver {
    private static final int IMPLICIT_SECONDS = 30;

    public SharedDriver() {
        if (DriverFactory.getDriver() == null) {
            DesiredCapabilities desCap = new DesiredCapabilities();
            desCap.setCapability("deviceName", "Mau-android");
            desCap.setCapability("platformName", "Android");
            desCap.setCapability("platformVersion", "7.1.2");
            desCap.setCapability("appPackage", "com.trello");
            desCap.setCapability("appActivity", ".home.HomeActivity");
            desCap.setCapability("udid", "emulator-5554");
            try {
                WebDriver driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:5556/wd/hub"), desCap);
                driver.manage().timeouts().implicitlyWait(IMPLICIT_SECONDS, TimeUnit.SECONDS);
                DriverFactory.setDriver(driver);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }
}
