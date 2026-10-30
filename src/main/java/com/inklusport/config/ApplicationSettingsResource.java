package com.inklusport.config;

import java.util.Map;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/settings")
@Produces(MediaType.APPLICATION_JSON)
public class ApplicationSettingsResource {
    
    @Inject 
    InklusportConfig config;

    @GET 
    public Map<String, Object> getSettings() {
        return Map.of(
                "applicationName", config.application().name(),
                "applicationVersion", config.application().version(),
                "maxRegistrationsPerEvent", config.registration().maxPerEvent(),
                "notificationsEnabled", config.notifications().enabled()
        );
    }
}
