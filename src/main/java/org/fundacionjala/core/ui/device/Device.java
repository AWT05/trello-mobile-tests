package org.fundacionjala.core.ui.device;

import org.fundacionjala.core.ui.config.Environment;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public abstract class Device {

    private final String deviceType;

    public Device() {
        this.deviceType = setDeviceType();
    }

    /**
     * Sets the device type.
     *
     * @return the type of the device.
     */
    protected abstract String setDeviceType();

    /**
     * Gets the capabilities values ​​of the data from a device in the environment
     * such as a map and sets the DesiredCapabilities object to return it.
     *
     * @return configured capacities.
     */
    public DesiredCapabilities getCapabilities() {
        Environment env = Environment.getInstance();
        Map<String, String> device = env.getDevice(deviceType);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        device.forEach(capabilities::setCapability);
        return capabilities;
    }
}
