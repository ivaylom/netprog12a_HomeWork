package org.elsys.netprog.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletHomework")
public class ServletHomework extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private List<String> messages;
    
    public ServletHomework() {
        super();
        this.messages = new ArrayList<String>();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("<!DOCTYPE html><html><head><title>Chat v2</title></head><body><div>");
		for (int i=0; i < messages.size(); i++) {
			response.getWriter().println("<p>" + messages.get(i) + "</p>");
		}
		response.getWriter().println("</div>" + "<form method=\"POST\">" + 
								"User: <input type=\"text\" name=\"user\">" +
								"Message: <input type=\"text\" name=\"message\">" +
								"<input type=\"submit\" value=\"Send\"/>" +
								"<div align=\"left\"><a href=\"/ServletHomework/Servlet\"><button>Refresh</button>" +
								"</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String message = request.getParameter("message");
		messages.add(user + ": " + message);
		
		if (user != null && message != null) {
			if (messages.size() > 20) {
				messages.remove(0);
			}
		}
		
		doGet(request, response);
	}

}
