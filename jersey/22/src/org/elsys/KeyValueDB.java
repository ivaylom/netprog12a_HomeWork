package org.elsys;

import java.util.Arrays;
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
@Path("/")
public class KeyValueDB {
	
	private static Map<String, String> database = new HashMap<String, String>();
 
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	
    	String result = "";
				
		for (Map.Entry<String, String> el : database.entrySet()) {
			result += el.getKey() + ": " + el.getValue() + "\n";
		}

		return result;
    }
    
    @PUT
    public void putIt(@QueryParam("key") String key, @QueryParam("value") String value) {
    	System.out.println(key + value);
    	database.put(key, value);
    }
    
    @DELETE
    public void deleteIt(@QueryParam("key") String key) {
    	database.remove(key);
    }
}
