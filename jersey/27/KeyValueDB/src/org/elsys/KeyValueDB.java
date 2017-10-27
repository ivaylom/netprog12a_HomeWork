package org.elsys;

import java.util.HashMap;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/KeyValueDB")
public class KeyValueDB {

	private static HashMap<String, String> db = new HashMap<String, String>();
	
	static {
		KeyValueDB.db.put("item1", "value1");
		KeyValueDB.db.put("item2", "value2");
		KeyValueDB.db.put("item3", "value3");
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getKeyValues() {
		StringBuilder result = new StringBuilder();
		for (HashMap.Entry<String, String> entry : db.entrySet()) {
			result.append(String.format("%s: %s\n", entry.getKey(), entry.getValue()));
		}
		return result.toString();
	}
	
	@PUT
	public void setKeyValue(@QueryParam("key") String key, @QueryParam("value") String value) {
		KeyValueDB.db.put(key, value);
	}
	
	@DELETE
	public void removeKeyValue(@QueryParam("key") String key) {
		KeyValueDB.db.remove(key);
	}
}
