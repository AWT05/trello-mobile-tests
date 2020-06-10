package org.fundacionjala.core.ui.driver;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPlatform {

    /**
     * Inits connection with a device.
     *
     * @return WebDriver that handles the device.
     */
    abstract WebDriver initDevice();
}
