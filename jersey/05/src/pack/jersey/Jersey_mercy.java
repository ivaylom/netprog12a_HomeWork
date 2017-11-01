package pack.jersey;
import java.util.HashMap;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
@Path("/Jersey_mercy")
public class Jersey_mercy {
	protected static HashMap<String, String> database = new HashMap<String, String>();
	static {
		Jersey_mercy.database.put("First", "Order");
		Jersey_mercy.database.put("Second", "Order");
		Jersey_mercy.database.put("Third", "Order");
		};
	@PUT
	public void edit(@QueryParam("key") String key, @QueryParam("value") String value) {
		Jersey_mercy.database.put(key, value);
	}
	@DELETE
	public void delete(@QueryParam("Key") String key)
	{
		Jersey_mercy.database.remove(key);
		System.out.println("deleted");
	}
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String show(){
		String temp = "";
		for (HashMap.Entry<String, String> e : database.entrySet()) {
			temp += e.getKey() + ": " + e.getValue() + "\n";
		}
		return temp;
	}
}