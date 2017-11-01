package org.elsys.netprog.jersey;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/KeyValueDB")
public class KeyValueDB {
	
	private static HashMap<String, String> database = new HashMap<String, String>();
	static {
		KeyValueDB.database.put("Item1", "School");
		KeyValueDB.database.put("Itme2", "Programming");
		KeyValueDB.database.put("Item3", "Math");
	};
	
	public KeyValueDB() {
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getDatabase() {
		String output = "";
		for (HashMap.Entry<String, String> item: database.entrySet()) {
			output += item.getKey() + ": " + item.getValue() + "\n";
		}
		return output;
	}
	
	@PUT
	public void putDatabase(@QueryParam("Key") String key, @QueryParam("Value") String value) {
		KeyValueDB.database.put(key, value);
		System.out.println("You did PUT.");
	}
	
	@DELETE
	public void removeDatabase(@QueryParam("Key") String key) {
		KeyValueDB.database.remove(key);
		System.out.println("You did DELETE.");
	}
	
}
