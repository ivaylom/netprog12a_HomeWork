package keyvaluedb.rest;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.DELETE; 
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("KeyValueDB")
public class MyResource {

	private static Map<String, String> db = new HashMap<String, String>()
	{{
		put("Jonathan", "Joestar");
		put("Ellen", "Ripley");
		put("DJ", "Assault");
	}};
	
	
    @GET
    @Path("view")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	String temp = "";
    	for (Entry<String, String> pair : db.entrySet()){
            temp += pair.getKey() + ":" + pair.getValue() + "\n";
        }
    	return temp;
    }
    
    @PUT
    @Path("insert")
    public Response putIt(@QueryParam("key") String key, @QueryParam("value") String value) {
    	db.put(key, value);
    	return Response.status(200).entity("Inserted entity with key:" + key + ";value:" + value + "\n").build();
    }
    
    @DELETE
    @Path("remove")
    public Response deleteIt(@QueryParam("key") String key) {
    	db.remove(key);
    	return Response.status(200).entity("Deleted entity with key:" + key + "\n").build();
    }
}
