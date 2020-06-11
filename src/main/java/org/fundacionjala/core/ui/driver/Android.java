package org.fundacionjala.core.ui.driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.fundacionjala.core.ui.config.Environment;
import org.fundacionjala.core.ui.device.Device;
import org.openqa.selenium.WebDriver;

import static org.fundacionjala.core.ui.device.DeviceFactory.getDevice;

public final class Android extends AbstractPlatform {

    @Override
    public WebDriver initDevice() {
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        Environment env = Environment.getInstance();
        appiumServiceBuilder.withIPAddress(env.getIpAddress());
        appiumServiceBuilder.usingPort(env.getPort());
        Device device = getDevice();
        return new AndroidDriver<MobileElement>(appiumServiceBuilder, device.getCapabilities());
    }
}
