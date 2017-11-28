package org.elsys.restapi.services;

import org.elsys.restapi.services.Message;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class MessagesService {

	protected static List<Message> messages = new ArrayList<Message>();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsgs() {
		String output = buildJSONoutput();
		return Response.status(200).entity(output).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response puMsg(@QueryParam("username")String username, @QueryParam("messages")String msg) {
		messages.add(new Message(username, msg));
		
		String output = buildJSONoutput();
		System.out.print(output);
		return Response.status(200).entity(output).build();
	}
	
	private String buildJSONoutput() {
		String result = "[";
		for(Message msg: messages) {
			result +=  "[" + msg.toString() + "],";
		}
		result = result.substring(0, result.length() - 1);
		result += "]";
		return result;
	}
}
