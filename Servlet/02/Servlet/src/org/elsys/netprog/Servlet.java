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
	private static List <Message> messageList = new ArrayList <Message>();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		response.getOutputStream().println("<html><body><font size=30>");
		
			for(Message m : messageList) {
				response.getOutputStream().println("<font size = 3>" + m.getName() + ": " + m.getText() + "<br>");
			}
		
			response.getOutputStream().println(	
				"<form method='POST'>" +
					"<input type='text' name='name' placeholder='Name' />" +
					"<input type='text' name='message' placeholder='Message' /> " +
					"<input type='submit' value='Send' />" +
				"</form>" +	
				"<form method='GET'>" +
					"<input type='submit' value='Refresh' />" +
				"</form>" +	
				"</font></body></html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Message m = new Message(request.getParameter("name"),request.getParameter("message") );
		if(messageList.size() >= 20)
			messageList.remove(0);
		
		messageList.add(m);
		doGet(request,response);

	}

}
