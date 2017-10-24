package org.elsys;

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

    private final String htmlHeader = "<!DOCTYPE html><html><head><title>Servlet Chat</title></head><body><div>";
    private final String htmlFooter = "</div></body></html>";
    private final String form = "<form method='POST'>" +
			"<label>Username:</label> <input type='text' name='username' placeholder='MishoVentilatora' />" +
			"<label>Message</label><input type='text' name='message' placeholder='Syobshtenie' /> " +
			"<input type='submit' />" +
		"</form>"
		+ "<a href=\"/ServletChatHomework/Servlet\"><button>Refresh</button></a>";
    private LinkedList<List<String>> messages = new LinkedList();


    private String generateHtml() {
    	String html = htmlHeader;
    	String comments = "";
		if (messages.size() >= 20) {
			messages.pop();
		}
		
		for(List<String> item: messages) {
			comments += "<p>" + item.get(0) + ": " + item.get(1) + "</p>";
		}	
		
		html += comments;
		html += form;
		html += htmlFooter;
    	return html;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		response.getOutputStream().println(generateHtml());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String message = request.getParameter("message");
		if(username != "" && message != "") {
			messages.addLast(new ArrayList<String>(Arrays.asList(username, message)));
		}
		
		response.getOutputStream().println(generateHtml());
	}

}