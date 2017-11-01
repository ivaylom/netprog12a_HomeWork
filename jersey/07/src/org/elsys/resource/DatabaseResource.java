package org.elsys.resource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("database")
public class DatabaseResource {
	static private Map<String, String> store = new HashMap<>();

	static {
		store.put("item1", "value1");
		store.put("item2", "value2");
		store.put("item3", "value3");
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getStore() {
		StringBuilder sb = new StringBuilder();

		store.keySet().stream().forEach(key -> sb.append(String.format("%s: %s\n", key, store.get(key))));

		return sb.toString();
	}

	@PUT
	public void putToStore(@QueryParam("key") String key, @QueryParam("value") String value) {
		store.put(key, value);
	}

	@DELETE
	public void deleteFromStore(@QueryParam("key") String key) {
		store.remove(key);
	}
}
