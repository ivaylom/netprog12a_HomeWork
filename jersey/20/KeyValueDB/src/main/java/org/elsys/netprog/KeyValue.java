package org.elsys.netprog;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/run")
public class KeyValue {
    private static Map<String, String> db = new HashMap<String, String>();

    static {
        db.put("item1", "value1");
        db.put("item2", "value2");
        db.put("item3", "value3");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        StringBuilder content = new StringBuilder();

        for (String key : db.keySet()) {
            content.append(key).append(" : ").append(db.get(key)).append("\n");
        }
        return content.toString();
    }

    @PUT
    public void insertValues(@QueryParam("key") String key, @QueryParam("value") String value) {
        System.out.println("PUT " + key + " : " + value);
        db.put(key, value);
    }

    @DELETE
    public void deleteValue(@QueryParam("key") String key) {
        System.out.println("DELETE " + key + " : " + db.get(key));
        db.remove(key);
    }
}
