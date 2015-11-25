package lv.javaguru.java3.config;

import lv.javaguru.java3.rest.HealthController;
import lv.javaguru.java3.rest.clients.ClientResourceImpl;
import lv.javaguru.java3.rest.user.UserResourceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CORSResponseFilter.class);

        register(HealthController.class);
        register(ClientResourceImpl.class);
        register(UserResourceImpl.class);
    }

}