package org.elsys.chat;

import java.io.IOException;
import java.util.ArrayList;
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

	private List<String> messages = new ArrayList<String>();
    /**
     * Default constructor. 
     */
    public ChatServlet() {
        // TODO Auto-generated constructor stub
    }
    
    private String makeHTML() {
    	String html = "";
    	
    	html += "<html>"
				 + "<body>"
				 	+ "<textarea rows=40 cols=50>";
		
    	for(String el : messages.subList(Math.max(messages.size() - 20, 0), messages.size())) {
			html += el + "\n";
		}
		
		html +=		 "</textarea><br><br>"
					+"<form method='POST'>"
						+ "<input type='text' name='name' placeholder='Name'/> "
						+ "<input type='text' name='message' placeholder='Message'/> "
						+ "<input type='submit' value='Send'/><br>"
					+ "</form>"
					+ "<a href='/ServletHomework/ChatServlet'><button>Refresh</button></a>"
				+ "</body>"
			+ "</html>";
		
		return html;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
        response.getOutputStream().println(makeHTML());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String message = request.getParameter("message");
        
        messages.add(message);
        
        response.getOutputStream().println(makeHTML());
	}

}
