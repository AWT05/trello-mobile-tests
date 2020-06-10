package org.fundacionjala.Tests.Board;

import org.fundacionjala.core.ui.driver.Android;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class FunctionalTest {
    protected static WebDriver driver;

    @BeforeMethod
    public static void setUp() {
        Android android = new Android();
        driver = android.initDevice();
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }
}
