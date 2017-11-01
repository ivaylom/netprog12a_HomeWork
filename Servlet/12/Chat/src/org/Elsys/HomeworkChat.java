package org.Elsys;



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
@WebServlet("/HomeworkChat")
public class HomeworkChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;
	private String message;
	private List<Message> chat = new ArrayList();
    /**
     * Default constructor. 
     */
    public HomeworkChat() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		
		
		for(Message c :chat) {
			response.getOutputStream().println("<p>" +  c.getName() + ": " + c.getMessage() + "</p>");
		}
		
		response.getOutputStream().println("<html><body><font size=30>" +
				"<form method='POST'>" +
					"<input type='text' name='name' placeholder='Name' />" +
					"<input type='text' name='message' placeholder='Write something...' /> " +
					"<input type='submit' value = 'Submit'/>" +
					"<input type='reset' value ='Refresh'/>" +
				"</form>" +	
				"</font></body></html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		name = request.getParameter("name");
		message = request.getParameter("message");
		this.chat.add(new Message(name, message)); 
		
		if(this.chat.size() > 20) {
			this.chat.remove(0);
		}

		
		doGet(request, response);
	}

}