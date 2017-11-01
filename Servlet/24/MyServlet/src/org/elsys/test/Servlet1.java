package org.elsys.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class Servlet1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private static ArrayList<Message> messages = new ArrayList<Message>();   

    public Servlet1() {
        super();
    }

    private String generatePage() {
    	String html = "<!DOCTYPE html><html><body><div>";

		for (int i = 0; i < 20; i++) {
			if (messages.get(i) == null) {
				break;
			}
			html += "<p>" + messages.get(i).getMessage() + "</p>";
		}
		
		html += "<form method='POST'>" +
				"<label>Name: </label><input type='text' name='name' placeholder='Name' />" +
				"<label>Message: </label><input type='text' name='message' placeholder='Message' /> " +
				"<input type='submit' />" +
				"</form>" +
				"<a href=\"/MyServlet/FirstServlet\"><button>Refresh</button></a>" +
				"</div></body></html>";
		
		return html;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.getOutputStream().println(generatePage());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		if(name != "" && message != "") {
			messages.add(new Message(name, message));
		}
		response.getOutputStream().println(generatePage());
	}

}
