package org.fundacionjala.core.ui.device;

import org.fundacionjala.core.ui.config.Environment;

public final class DeviceFactory {

    private DeviceFactory() {

    }

    public static Device getDevice() {
        return Environment.getInstance().isRealMobile()
                ? new Real()
                : new Emulator();
    }
}
