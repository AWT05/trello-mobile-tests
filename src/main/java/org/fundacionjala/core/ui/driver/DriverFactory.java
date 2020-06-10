package org.fundacionjala.core.ui.driver;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public final class DriverFactory {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    private static List<WebDriver> storedDrivers = new ArrayList<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> storedDrivers.forEach(WebDriver::quit)));
    }

    private DriverFactory() {
    }

    public static void setDriver(final WebDriver driver) {
        drivers.set(driver);
        storedDrivers.add(driver);
    }

    /**
     * @return the driver.
     */
    public static WebDriver getDriver() {
        return drivers.get();
    }
}
