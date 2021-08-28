package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static String getWebUrl() {
        return getWebConfig().webUrl();
    }

    public static String getWebUri() {
        return getWebConfig().webUri();
    }

    public static String getUsername() {
        return getWebConfig().webUser();
    }

    public static String getPassword() {
        return getWebConfig().webPassword();
    }

    private static WebConfig getWebConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }
}