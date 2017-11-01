package homework;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/hello")
public class KyVlue {

	private static HashMap<String, String> db;

	static {
		db = new HashMap<String, String>();
		db.put("item1", "value1");
		db.put("item2", "value2");
		db.put("item3", "value3");
    }
	
	 @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getKyVlue() {
		 String output = new String();
		 
		 for(Map.Entry<String, String> temp : db.entrySet()){
			 output += temp.getKey() + ":" + temp.getValue() + "\n";
		 }
		 return output;
	  }
	 
	  @PUT
	  public void putKyVlue(@QueryParam("Key") String key,@QueryParam("Value") String value)
	  {
		  KyVlue.db.put(key, value);
	  }
	  
	  @DELETE
	  public void removeKyVlue(@QueryParam("Key") String key)
	  {
		  KyVlue.db.remove(key);
	  }
}