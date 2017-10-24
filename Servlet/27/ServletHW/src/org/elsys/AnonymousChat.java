package org.elsys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnonymousChat
 */
@WebServlet("/")
public class AnonymousChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int lastMessagesCount = 20;
	private static ArrayList<Message> messages = new ArrayList<Message>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnonymousChat() {
        super();
//        Uncomment to add sample messages
//        for (Message m: SampleMessages.messages) {
//        	AnonymousChat.messages.add(m);
//        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int messagesCount = AnonymousChat.messages.size();
		List<Message> lastMessages = 
				AnonymousChat.messages.subList(Math.max(messagesCount - AnonymousChat.lastMessagesCount, 0), messagesCount);
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("messages", lastMessages);
		request.getRequestDispatcher("/WEB-INF/views/AnonymousChat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		AnonymousChat.messages.add(new Message(name, message));
		response.sendRedirect("/ServletHW");
	}

}
