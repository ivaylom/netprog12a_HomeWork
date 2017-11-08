package Jersey.DB;

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

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	private static Map<String,String> dataBase = new HashMap<String,String>();
	
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	final int i = 0;
    	dataBase.put("entry","" + i);
    	
    	String printedOut = "";
    	for (Entry<String, String> entry : dataBase.entrySet()){
            printedOut += "Key: "+ entry.getKey() + ":" + entry.getValue() + " :VALUE" + "\n";
        }
    	return printedOut;    
    }
    
    //Insert Method
    @PUT
    public Response putIt(@QueryParam("key") String key, @QueryParam("value") String value) {
    	dataBase.put(key, value);
    	return Response.status(200).entity("Inserted entity with key:" + key + ";value:" + value + "\n").build();
    }
    
    @DELETE
    public Response deleteIt(@QueryParam("key") String key) {
    	dataBase.remove(key);
    	return Response.status(200).entity("Deleted entity with key:" + key + "\n").build();
    }
    
}
