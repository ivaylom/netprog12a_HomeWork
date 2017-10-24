package org.elsys;

import java.io.IOException;
import java.io.PrintWriter;
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
	List<User> users = new ArrayList<User>();
	private String error = new String();
	private final int maxMessages = 20;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChatServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<div><h1>Hello, welcome to the chat room!</h1></div>");

		out.println(
				"<div style=\"float: right; width: 350px; height: 300px; border: solid 5px #7997a1; overflow-y: auto; overflow-x: auto\">");

		if (!(error.isEmpty())) {
			out.println("<span style=\"display: block; margin-top: 5px; margin-left: 10px; color: #FF0000\">" + error
					+ "</span>");
		}
		
		for(User user : users) {
			out.println("<span style=\"display: block; margin-top: 5px; margin-left: 10px\">" + user.getName() + ": " + user.getMessage() + "</span>");
		}
	
		out.println("</div>");

		out.println("<div style=\"float: left; width: 350px; height: 150px; background-color: #7EC0EE\">");

		out.println("<div style=\"\">" + "<form method=\"post\">"
				+ "<span>Name:</span><input style=\"margin-left: 17px; border-radius: 8px;\" type=\"text\" name=\"username\"/>"
				+ "<br />" 
				+ "<span>Message:</span><input style=\"border-radius: 8px\" type=\"text\" name=\"message\"/>"
				+ "<br />"
				+ "<input style=\"margin-top: 1px; margin-left: 1px; border-radius: 8px;\" type=\"submit\" value=\"Send Message\"/>");

		out.println("<button type=\"reset\" style=\"float: right; border-radius: 8px;\">Refresh</button>");

		out.println("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String message = request.getParameter("message");
		if (message == "" || name == "") {
			error = "Please dont submit empty name or message";
		} else {
			if (users.size() == maxMessages) {
				users.remove(0);
			}
			users.add(new User(name, message));
		}
		doGet(request, response);
	}

}
