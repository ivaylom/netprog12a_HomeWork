package com.salutations.services;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/app")
public class KeyValueService {
	
	private static Map <String, String> hello = new HashMap ();
	
	static {
        hello.put("Chocolate", "Cookies");
        hello.put("Butter", "Chicken");
        hello.put("Cinnamon", "Buns");
        hello.put("Baked", "Ribs");
        hello.put("Chickpea", "Salad");
    }
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
	public String getFoodNames() {
		
		String result = "";
		
		for (String key: hello.keySet()){
            result += key + ":" + hello.get(key) + "\n";
		}
		
		return result;
	}
	
	@PUT
	public void addFood (
		@QueryParam ("key") String key,
		@QueryParam ("value") String value) {
		
		hello.put(key, value);
	}
	
	@DELETE
	public void deleteFood (
		@QueryParam ("key")String key) {
		
		hello.remove(key);
	}
}