package com.inklusport.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "inklusport")
public interface InklusportConfig {

    Application application();

    Registration registration();

    Notifications notifications();

    interface Application {
        String name();
        String version();
    }

    interface Registration {
        int maxPerEvent();
    }

    interface Notifications {
        boolean enabled();
    }
}