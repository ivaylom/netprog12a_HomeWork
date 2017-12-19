package org.elsys.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elsys.data.Message;

@WebServlet("/api/messages")
public class ApiServlet extends HttpServlet {

	private List<String> messages;
	private static final int messagesToShow = 20;

	private static final long serialVersionUID = 1L;

	public ApiServlet() {
		super();

		this.messages = new ArrayList<>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder json = new StringBuilder();

		List<String> latestMessages = this.messages.subList(Math.max(messages.size() - messagesToShow, 0),
				messages.size());

		json.append("[");

		for (int i = 0; i < latestMessages.size(); i++) {
			json.append(latestMessages.get(i));
			if (i != latestMessages.size() - 1) {
				json.append(",");
			}
		}

		json.append("]");

		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(json.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Message message = new Message(request.getParameter("sender"), request.getParameter("message"));
		this.messages.add(Message.toJson(message));
	}

}
