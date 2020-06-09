package org.fundacionjala.Tests.Board;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FunctionalTest {
    protected static WebDriver driver;

    @BeforeMethod
    public static void setUp() {
        DesiredCapabilities desCap = new DesiredCapabilities();
        desCap.setCapability("deviceName", "Mau-android");
        desCap.setCapability("platformName", "Android");
        desCap.setCapability("platformVersion", "7.1.2");
        desCap.setCapability("appPackage", "com.trello");
        desCap.setCapability("appActivity", ".home.HomeActivity");
        desCap.setCapability("udid", "emulator-5554");
        try {
            driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:5554/wd/hub"), desCap);
            driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("Executed BEFORE method");
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
        System.out.println("Executed AFTER method");
    }
}
