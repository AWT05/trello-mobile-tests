package org.fundacionjala.core.ui.driver;

import org.fundacionjala.core.ui.config.Environment;

public final class SharedDriver {
    public SharedDriver() {
        if (DriverFactory.getDriver() == null) {
            DriverFactory.setDriver(PlatformFactory.getDevice(Environment.getInstance().getPlatformName()));
        }
    }
}
