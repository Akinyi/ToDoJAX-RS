package se.akoch.ToDoJAXRS.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import se.akoch.ToDoJAXRS.resource.WebLager;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {

        register(WebLager.class);
    }
}
