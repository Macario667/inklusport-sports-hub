package com.inklusport.config;

import java.util.Map;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/config")
public class ApplicationConfigResource {
    
    /**
     * @ConfigProperty permite inyectar en nuestros atributos los 
     * valores definidos en application.properties
     */

    @ConfigProperty(name = "inklusport.application.name")
    String applicationName;

    @ConfigProperty(name = "inklusport.application.version")
    String applicationVersion;

    @ConfigProperty(name = "inklusport.registration.max-per-event")
    int maxRegistrations;

    @ConfigProperty(name = "inklusport.notifications.enabled")
    boolean notificationsEnabled;

    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getConfiguration() {
        return Map.of(
            "applicationName", applicationName,
            "applicationVersion", applicationVersion,
            "maxRegistrationsPerEvent", maxRegistrations,
            "notificationsEnabled", notificationsEnabled
        );      
    }
}
