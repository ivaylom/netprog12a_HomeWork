package jersey;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import javax.ws.rs.DELETE;

//http://localhost:8080/JerseyHW02/JerseyRest
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



@Path("/JerseyRest")
public class JerseyRest {

	private static HashMap<String, String> db ;
	static{
		db= new HashMap<String, String>();
	     JerseyRest.db.put("item1","zdr" );
	     JerseyRest.db.put("item2", "Tajno mi e");
	     JerseyRest.db.put("item3", "^_^ Postman ^_^");
	};
	
		

	  // This method is called if TEXT_PLAIN is request
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getKV() {
		  String output=new String();
		  for (Map.Entry me : db.entrySet()) {
	      output+=me.getKey()  +" : "+ me.getValue()+"\n";
	        }
			return output;
		  
	  }
	  @PUT
	  public void putKV(@QueryParam("Key") String key,@QueryParam("Value") String value)
	  {
		  JerseyRest.db.put(key, value);
		  System.out.println("added");
	  }
	  @DELETE
	  public void removeKV(@QueryParam("Key") String key)
	  {
		  JerseyRest.db.remove(key);
		  System.out.println("removed");
	  }
}

