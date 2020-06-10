package org.fundacionjala.core.ui.driver;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class DriverFactory {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    private static List<WebDriver> storedDrivers = new ArrayList<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> storedDrivers.forEach(WebDriver::quit)));
    }

    private DriverFactory() {
    }

    /**
     * Sets a driver in a thread.
     *
     * @param driver specific driver.
     */
    public static void setDriver(final WebDriver driver) {
        drivers.set(driver);
        storedDrivers.add(driver);
    }

    /**
     * Gets the driver from a thread
     *
     * @return the driver.
     */
    public static WebDriver getDriver() {
        return drivers.get();
    }
}
