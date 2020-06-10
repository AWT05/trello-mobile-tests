package org.fundacionjala.core.ui.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.fundacionjala.core.ui.config.Environment;
import org.fundacionjala.core.ui.device.Device;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.fundacionjala.core.ui.device.DeviceFactory.getDevice;

public final class Android extends AbstractPlatform {

    @Override
    public WebDriver initDevice() {
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        Environment env = Environment.getInstance();
        appiumServiceBuilder.withIPAddress(env.getIpAddress());
        appiumServiceBuilder.usingPort(env.getPort());
        Device device = getDevice();
        WebDriver driver = new AppiumDriver<MobileElement>(appiumServiceBuilder, device.getCapabilities());
        driver.manage().timeouts().implicitlyWait(
                Environment.getInstance().getImplicitTimeWait(),
                TimeUnit.SECONDS);
        return driver;
    }
}
