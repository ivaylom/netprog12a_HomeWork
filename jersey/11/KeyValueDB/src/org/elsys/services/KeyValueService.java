package org.elsys.services;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;


@Path("/")
public class KeyValueService {

	private static Map<String, String> content = new HashMap<String, String>()
	{{
		put("Misho", "Ventilatora");
		put("Mitko", "Boilera");
		put("This is", "that");
	}};
	
	public KeyValueService() {
	}
	
	private String generateResponseContent() {
		String output = "";
    	for(Map.Entry<String, String> me: this.content.entrySet()) {
    		output += me.getKey() + ":" + me.getValue() + "\n";
    	}
    	return output;
	}
	
    @GET
    public Response showDatabse() {
        return Response.status(200).entity(generateResponseContent()).build();
    }
    
    /*
     * Not sure if we have to return the content on PUT and DELTE so
     * if you want to you should change the void methods to return Response and uncomment lines: 46 and 54
     */
    
    @PUT
    public void addToDatabase(@QueryParam("key") String key, @QueryParam("value") String value) {
    	content.put(key, value);
    	
    	// return Response.status(200).entity(generateResponseContent()).build();
    }
    
    @DELETE
    public void DeleteFromDatabse(@QueryParam("key") String key) {
    	
    	content.remove(key);
    	
    	// return Response.status(200).entity(generateResponseContent()).build();
    }

}