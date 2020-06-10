package org.fundacionjala.core.ui.device;

import org.fundacionjala.core.ui.config.Environment;

public final class DeviceBuilder {

    private static Device device = Environment.getInstance().isRealMobile()
            ? new Real()
            : new Emulator();

    private DeviceBuilder() {

    }

    public static Device build() {
        return device;
    }

    public DeviceBuilder emulatorMobile() {
        device = new Emulator();
        return this;
    }

    public DeviceBuilder realMobile() {
        device = new Real();
        return this;
    }
}
