package org.elsys.netprog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Message> messages = new ArrayList<Message>();
	String messagesString = "";
	
    /**
     * Default constructor. 
     */
    public ChatServlet() {
        // TODO Auto-generated constructor stub
    }
    
    public String createMessageString() {
    	String msgs = "";
    	
		for(Message msg: messages) {
			msgs += msg.getName() + ": " + msg.getMessage() + "<br>";
		}	
		
		return msgs;
		
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String messagesString = createMessageString();
				
		response.getOutputStream().println("<html><body><font size=30>" +
				messagesString +
				"<form method='POST'>" +
					"<input type='text' name='name' placeholder='Name' />" +
					"<input type='text' name='message' placeholder='Message' /> " +
					"<input type='submit' />" +
				"</form>" +
				"<a><button>Refresh</button></a>" + 
				"</font></body></html>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String mess = request.getParameter("message");
		
		messages.add(new Message(name, mess));
		
		if(messages.size() >= 20) {
    		messages.remove(0);
    	}
		doGet(request, response);
	}


}
