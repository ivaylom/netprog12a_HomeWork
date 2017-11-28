package org.elsys.restapi;

import org.glassfish.jersey.server.ResourceConfig;

public class MessagesApplication extends ResourceConfig{
	public MessagesApplication() {
		packages("org.elsys.restapi.services");		
	}
}
