package org.elsys.netprog;

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
	
	private List<String> chat = new ArrayList<String>();
	
	public Servlet() {
        // TODO Auto-generated constructor stub
    }

	private String createPage() {
		
		String log = "";
		
		for (String s : chat) {
			log += "<p>" + s + "</p>"; 
		}
		
		return "<doctype! html>"
					+ "<head>"
						+ "<title> Chat by Mihail Hernandez 12a </title>"
					+ "</head>"
					+ "<body>"
						+ log
						+ "<form method='POST'>"
							+ "<input type='text' name='name' />"
							+ "<input type='text' name='message' /> "
							+ "<input type='submit' value='Send'/>"
							+ "<input type='Reset' value='Refresh'/>"
						+ "</form>" 
					+ "</body>"
				+"</html>";
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		response.getOutputStream().println(createPage());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		if (name != "" && message != "") {
			chat.add(name + ": " + message);
			if (chat.size() > 19) {
				chat.remove(0);
			}
		}
		
		response.getOutputStream().println(createPage());
	}


}
