package cloud.autotests.config.demowebshop;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/demowebshop/app.properties",
        "local.properties"
})
public interface AppConfig extends Config {

    String webUrl();

    String apiUrl();

    String userLogin();

    String userPassword();

}
