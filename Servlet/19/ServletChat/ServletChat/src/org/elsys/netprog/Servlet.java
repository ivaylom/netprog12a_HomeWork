package org.elsys.netprog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List <Message> messages = new ArrayList <Message>();

    /**
     * Default constructor. 
     */
    public Servlet() {
    	super();
    	this.messages = new ArrayList<Message>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		for(Message m: messages){
			response.getOutputStream().println("<p>" + m.getName() + ": " + m.getContent() + "<p>");
		}
		
		response.getOutputStream().println("<html><body><font size=30>" +
				"<form method='POST'>" +
					"" +
					"<input type='text' name='name' placeholder='Name' />" +
					"<input type='text' name='message' placeholder='Message' /> " +
					"<input type='submit' value='Send'/>" +
					"<a href='http://localhost:8080/ServletChat/Servlet' style='font-size: 16; margin-left: 15px;'>Refresh</a>" +
				"</form>" +	
				"</font></body></html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Message m = new Message(request.getParameter("name"), request.getParameter("message"));
		
		if(messages.size() >= 20){
			messages.remove(0);
		}
		
		messages.add(m);
		doGet(request,response);
	}

}
