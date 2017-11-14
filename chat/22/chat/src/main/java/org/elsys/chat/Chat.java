package org.elsys.chat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("chat")
public class Chat {
	
	private static List<String> database = new ArrayList<String>(); 

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMessages() {
		String json = "{";
		String array = "[";
		
		for(String el : database.subList(Math.max(database.size() - 20, 0), database.size())) {
			array += "\"" +  el + "\"" + ", ";
		}
		
		if (array.length() > 1) {
			array = array.substring(0, array.length() - 2);
		}
		
		array += "]";
		
		json += "\"array\": " + array;
		json += "}";
		
		return json;
	}
	
	@POST
	public void submitMessage(@FormParam("name") String name,
							  @FormParam("message") String message) {
		database.add(message);
	}
}
