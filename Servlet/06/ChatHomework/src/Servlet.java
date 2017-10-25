

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<Message> messages;
	
    public Servlet() {
        super();
        this.messages = new ArrayList<Message>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (messages.size() > 20) {
			messages.remove(0);
		}
		request.setAttribute("messages", messages);
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String owner = request.getParameter("name");
		String content = request.getParameter("message");
		this.messages.add(new Message(owner, content));
		response.sendRedirect("/ChatHomework/Servlet");
	}

}
