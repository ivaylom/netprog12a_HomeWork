package org.elsys.netprog.rest;

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
	//accessed with ...:8081/KeyValueDB/rest/KeyValueDB

	private static HashMap<String, String> db = new HashMap<String, String>();
	
	static {
		KeyValueDB.db.put("item1", "value1");
		KeyValueDB.db.put("item2", "value2");
		KeyValueDB.db.put("item3", "value3");
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getData() {
		String output = "";
		for (HashMap.Entry<String, String> e : db.entrySet()) {
			output += String.format("%s: %s\n", e.getKey(), e.getValue());
		}
		return output;
	}
	
	@PUT
	public void setData(@QueryParam("key") String key, @QueryParam("value") String value) {
		db.put(key, value);
	}
	
	@DELETE
	public void removeData(@QueryParam("key") String key) {
		db.remove(key);
	}
}
