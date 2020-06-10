package org.fundacionjala.core.ui.driver;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class PlatformFactory {

    private static final Map<String, Supplier<AbstractPlatform>> APPS = new HashMap<>();

    private PlatformFactory() {
    }

    static {
        APPS.put("android", Android::new);
//        APPS.put("ios", Ios::new);
    }

    public static WebDriver getDevice(String platformName) {
        return APPS.getOrDefault(platformName, Android::new).get().initDevice();
    }
}
