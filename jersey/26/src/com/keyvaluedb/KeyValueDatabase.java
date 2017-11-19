package com.keyvaluedb;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
public class KeyValueDatabase {
	
	static private Map<String, String> database = new HashMap<>();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getData() {
		 String result = new String();
	        
        for(Entry<String, String> entryNode : database.entrySet()) {
        		result += entryNode.getKey() + ":" + entryNode.getValue() + "\n";
        }
        
        return result;
	}

	@PUT
	public Response putData(@QueryParam("key") String key, @QueryParam("value") String value) {
		database.put(key, value);
		
		return Response.status(200).entity("Added data successfully").build();
	}

	@DELETE
	public Response deleteData(@QueryParam("key") String key) {
		database.remove(key);
		
		return Response.status(200).entity("Removed data successfully").build();
	}
}
