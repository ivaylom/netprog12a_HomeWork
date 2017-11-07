package com.example;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	
	private HashMap<String, String> db;
	
	public MyResource() {
		db = new HashMap<String, String>();
		db.put("item1", "value1");
		db.put("item2", "value2");
		db.put("item3", "value3");
	}
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	String response = "";
    	for (Map.Entry<String, String> e : db.entrySet()) {
    		response += e.getKey() + ": " + e.getValue() + "\n";
    	}
        return response;
    }
    
    @PUT
    public void setIt(@QueryParam("key") String key, @QueryParam("value") String value){
    	db.put(key, value);
    }
    
    @DELETE
    public void deleteIt(@QueryParam("key") String key){
    	db.remove(key);
    }
}
