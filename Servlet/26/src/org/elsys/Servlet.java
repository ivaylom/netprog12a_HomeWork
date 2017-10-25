package org.elsys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Message> conversation;
	private int MAX_MESSAGES = 20;

    public Servlet() {
        conversation = new ArrayList<Message>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		response.getOutputStream().println(generateHtml());
	}
	
	private String generateHtml() {
		String html = "<html><body>";
		
		for(Message msg: conversation) {
			html += msg.generateMsgHtml();
		}
		
		html += "<font size=30> <form method='POST'>" +
				"<input type='text' name='sender' placeholder='Name' />" +
				"<input type='text' name='message' placeholder='Enter Message' /> " +
				"<input type='submit' />" +
				"</form>" +	
				"<a href=\"/Chat/Servlet\"><button>Refresh</button></a>" +
				"</font></body></html>";
		
		return html;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String sender = request.getParameter("sender");
		String message = request.getParameter("message");
		
		if(sender != "" && message != "") {
			if(conversation.size() >= MAX_MESSAGES) {
				conversation.remove(0);
			}
			
			conversation.add(new Message(sender, message));
		}
		
		response.getOutputStream().println(generateHtml());
	}

}