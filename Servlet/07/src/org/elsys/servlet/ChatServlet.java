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

@WebServlet("/")
public class ChatServlet extends HttpServlet {
	
	private List<Message> messages;
	
	private static final long serialVersionUID = 1L;
       
    public ChatServlet() {
        super();
        this.messages = new ArrayList<>();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("messages", Message.formatHTML(messages));
		request.setAttribute("location", request.getRequestURL());
		request.getRequestDispatcher("/WEB-INF/chat.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.messages.add(new Message(request.getParameter("sender"), request.getParameter("message")));
		doGet(request, response);
	}

}
