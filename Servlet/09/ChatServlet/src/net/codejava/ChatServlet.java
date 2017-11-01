package net.codejava;

import java.io.IOException;
import java.util.ArrayList;

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
	public ArrayList<Message> chatLog = new ArrayList<Message>();
	
	public String error = new String();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatServlet() {
        super();
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		if (!(error.isEmpty())) {
			response.getOutputStream().println(error);
		}
		
		for (Message m: chatLog) {
			response.getOutputStream().println("<span style=\"display: block; margin-top: 5px; margin-left: 5px\">" + m.name + ": " + m.message + "</span>"); 
		}
		
		response.getOutputStream().println("<html><body><font size=30>" +
				"<form method='POST'>" +
					"<input type='text' name='name' placeholder='Name' />" +
					"<input type='text' name='message' placeholder='Message' /> " +
					"<input type='submit' />" +
				"</form>" +	"<form action=\"http://localhost:8080/ChatServlet/ChatServlet\">\n" + 
						"    <input type=\"submit\" value=\"Refresh\" />\n" + 
						"</form>" +
				"</font></body></html>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		Message currentMessage = new Message(name, message);
		
		if (currentMessage.name == "") {
			error = "Name field cannnot be blank";
		}
		else if (currentMessage.message == "") {
			error = "Message field cannnot be blank";
		}
		else {
			if (chatLog.size() == 20) {
				chatLog.remove(0);
			}
			else {
				chatLog.add(currentMessage);
			}
		}

		doGet(request, response);
	}

}
