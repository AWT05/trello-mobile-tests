package org.fundacionjala.core.ui.config;

import io.restassured.path.json.JsonPath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public final class Environment {

    private static final String ROOT_PATH = ".";
    private static final String CONFIG_JSON = "config.json";
    private static final String GRADLE_PROPERTIES = "gradle.properties";
    private static final String PLATFORM = "platform";
    private static final String PLATFORM_NAME = "platformName";
    private static final String DEVICES = "devices";
    private static final String TRUE = "true";
    private static final String REAL_MOBILE = "realMobile";
    private static final String EXPLICIT_TIME_WAIT = "explicitTimeWait";
    private static final String IMPLICIT_TIME_WAIT = "implicitTimeWait";
    private static final String REDUCE_EXPLICIT_TIME = "reduceExplicitTime";
    private static final String PORT = "port";
    private static final String IP_ADDRESS = "ipAddress";
    private static final String API_BASE_URI = "apiBaseUri";
    private static final String ACCOUNTS = "accounts";
    private static final String USER = "user";
    private static Environment instance;

    private final Properties properties;
    private Map<String, Object> envConfig;

    private Environment() {
        List<Map<String, Object>> environments;
        try (FileInputStream fileInputStream = new FileInputStream(GRADLE_PROPERTIES)) {
            properties = new Properties();
            properties.load(fileInputStream);
            environments = JsonPath.with(Files.readString(Paths.get(CONFIG_JSON), StandardCharsets.UTF_8))
                    .getList(ROOT_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Environment config file not found");
        } catch (IOException e) {
            throw new RuntimeException("Input/Output exception, failed to load gradle.properties");
        }
        envConfig = environments.stream()
                .filter(name -> name.get(PLATFORM).equals(getPlatformName()))
                .findFirst()
                .orElse(new HashMap<>());
    }

    public static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }

    private String getEnvProperty(final String name) {
        String property = System.getProperty(name);
        if (property == null) {
            return properties.getProperty(name);
        }
        return property;
    }

    public String getPlatformName() {
        return getEnvProperty(PLATFORM_NAME);
    }

    public String getIpAddress() {
        return getEnvProperty(IP_ADDRESS);
    }

    public Integer getPort() {
        return Integer.valueOf(getEnvProperty(PORT));
    }

    @SuppressWarnings("unchecked")
    public Map<String, String> getDevice(final String deviceType) {
        Map<String, Object> devices = (Map<String, Object>) envConfig.get(DEVICES);
        return (Map<String, String>) devices.get(deviceType);
    }

    public boolean isRealMobile() {
        String realMobile = getEnvProperty(REAL_MOBILE);
        return TRUE.equals(realMobile);
    }

    public int getImplicitTimeWait() {
        return Integer.parseInt(getEnvProperty(IMPLICIT_TIME_WAIT));
    }

    public int getExplicitTimeWait() {
        return Integer.parseInt(getEnvProperty(EXPLICIT_TIME_WAIT));
    }

    public int getReducedTime() {
        return Integer.parseInt(getEnvProperty(REDUCE_EXPLICIT_TIME));
    }

    @SuppressWarnings("unchecked")
    public Map<String, String> getAccount(final String user) {
        List<Map<String, String>> accounts = (List<Map<String, String>>) envConfig.get(ACCOUNTS);
        return accounts.stream().filter(account -> account.get(USER).equals(user))
                .findFirst().orElse(new HashMap<>());
    }

    public String getApiBaseUri() {
        return envConfig.get(API_BASE_URI).toString();
    }
}
