package org.elsys.netprog.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet() {
    }

    private final String start = "<!DOCTYPE html><html><head><title>Chat v2</title></head><body><div>";
    private final String end = "</div></body></html>";
    private final String format = "<form method='POST'>" +
			"<input type='text' name='name' placeholder='User' />" +
			"<input type='text' name='message' placeholder='Message' /> " +
			"<input type='submit' />" +
			"</form>"
			+ "<a href=\"/ServletChatHomework/Servlet\"><button>Refresh</button></a>";
    private LinkedList<List<String>> messages = new LinkedList();
    
    private String showMessages() {
		String htmlformat = start;
		String comments = "";
		if (messages.size() >= 20) {
			messages.pop();
		}
		for (List<String> message: messages) {
			comments += "<p>" + message.get(1) +"</p>";
		}
		
		htmlformat += comments;
		htmlformat += format;
		htmlformat += end;
    	return htmlformat;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getOutputStream().println(showMessages());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		if (name != "" && message != "") {
			messages.add(new ArrayList<String>(Arrays.asList(name, message)));
		}
		response.getOutputStream().println(showMessages());
	}
}
