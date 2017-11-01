package com.salutations.app;

import org.glassfish.jersey.server.ResourceConfig;

public class KeyValueApplication extends ResourceConfig {
    public KeyValueApplication() {
        // Define the package which contains the service classes.
        packages("com.salutations.services");
    }
}