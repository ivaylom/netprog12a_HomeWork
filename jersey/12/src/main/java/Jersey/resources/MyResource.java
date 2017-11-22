package Jersey.resources;

import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	private static Map<String, String> database = new HashMap<String, String>(){{
		put("Nike", "Jordan");
		put("Adidas", "Yeezy");
		put("Vans","Sk8-hi");
	}};
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        String output = new String();
        
        for(Entry<String, String> item : database.entrySet()) {
        		output += item.getKey() + ":" + item.getValue() + "\n";
        }
        
        return output;
    }
    
    @PUT
    public Response addElement(@QueryParam("key") String key, @QueryParam("value") String value) {
    		if (key.isEmpty()) {
    			System.out.println("There is no key");
    			return Response.status(204).entity("You should add a key").build();
    		}
    	
    		database.put(key, value);
    		
    		return Response.status(200).entity("You've added a key").build();
    }
    
    @DELETE
    public Response removeElement(@QueryParam("key") String key) {
    		if (key.isEmpty()) {
    			System.out.println("There is no key");
    			return Response.status(204).entity("You should add a key").build();
		}
    	
    		database.remove(key);
    		
    		return Response.status(200).entity("You've removed a key").build();
    }
    
}