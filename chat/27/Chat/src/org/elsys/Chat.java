package org.elsys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/Chat")
public class Chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int lastMessagesCount = 20;
	private static List<Message> messages = new ArrayList<Message>();
       
    public Chat() {
        super();
//      Uncomment to add sample messages
//      for (Message m: SampleMessages.messages) {
//      	Chat.messages.add(m);
//      }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int messagesCount = Chat.messages.size();
		List<Message> lastMessages = 
				Chat.messages.subList(Math.max(messagesCount - Chat.lastMessagesCount, 0), messagesCount);
		String json = new Gson().toJson(lastMessages);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		Chat.messages.add(new Message(name, message));
		doGet(request, response);
	}

}
