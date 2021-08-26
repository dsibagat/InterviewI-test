package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configuration/authorization.properties"
})
public interface AuthorizationConfig extends Config {
    @Config.Key("test-app.username")
    String username();

    @Config.Key("test-app.password")
    String password();
}