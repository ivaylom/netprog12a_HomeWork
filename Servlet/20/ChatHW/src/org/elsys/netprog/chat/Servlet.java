package org.elsys.netprog.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private List<Message> messages;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        this.messages = new ArrayList<>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		response.getOutputStream().println("<!DOCTYPE HTML>");
		response.getOutputStream().println("<html>");
		response.getOutputStream().println("<body>");
		
		response.getOutputStream().println("<h3>Chat v2</h3>");
		
		response.getOutputStream().println("<div>");
		for (Message m : messages) {
			response.getOutputStream().println("<b>" + m.getName().trim() + ":</b>" + " " 
					+ m.getMessage().trim() + "<br>");
		}
		response.getOutputStream().println("</div>");
		
		response.getOutputStream().println("<form method='POST'>");
		response.getOutputStream().println("<input type='text' name='name' placeholder='Name' />");
		response.getOutputStream().println("<input type='text' name='message' placeholder='Message' />");
		response.getOutputStream().println("<input type='submit' />");
		response.getOutputStream().println("</form>");
		
		response.getOutputStream().println("<br><a href='/ChatHW/Servlet'><button>Refresh</button></a>");
		
		response.getOutputStream().println("</body>");
		response.getOutputStream().println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		if (messages.size() == 20) {
			messages.remove(0);
		}
		
		messages.add(new Message(request.getParameter("name"), request.getParameter("message")));
		
		doGet(request, response);
	}

}
