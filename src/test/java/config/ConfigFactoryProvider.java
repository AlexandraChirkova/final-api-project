package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigFactoryProvider {

    private static final AuthConfig AUTH_CONFIG =
            ConfigFactory.create(AuthConfig.class);

    public static AuthConfig auth() {
        return AUTH_CONFIG;
    }

    private ConfigFactoryProvider() {
    }
}
