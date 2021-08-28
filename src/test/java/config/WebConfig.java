package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configs/web.properties"
})
public interface WebConfig extends Config {
    @Key("web.url")
    String webUrl();

    @Key("web.uri")
    String webUri();

    @Key("web.user")
    String webUser();

    @Key("web.password")
    String webPassword();
}