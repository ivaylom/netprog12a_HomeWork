package org.elsys;

import org.glassfish.jersey.server.ResourceConfig;


public class KeyValueApplication extends ResourceConfig {
	
	public KeyValueApplication() {
		packages("org.elsys.services");
	}
}
