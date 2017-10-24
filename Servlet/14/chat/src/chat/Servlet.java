package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private List<Message> messages = new ArrayList<Message>();
	private static final long serialVersionUID = 1L;
	private static final int messageCap = 20;
       
    public Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		out.println("<div>");
		out.println("tomchat <sub>hahAA</sub>");
		out.println("</div>");
		out.println("<div>");
		out.print(generateMessageBoxContent());
		out.println("</div>");
		out.println("<form action=\"/chat/Servlet\" method=\"POST\">");
		out.println("Username:");
		out.println("<input name=\"username\" type=\"text\"></input><br>");
		out.println("Message: ");
		out.println("<input name=\"messageContent\" type=\"text\"></input><br>");
		out.println("<input type=\"submit\" value=\"Send\"></input>");
		out.println("</form>");
		out.println("<a href=\"/chat/Servlet\"><button>Refresh</button></a>");
		out.println("</HTML>");
	}
	
	private String generateMessageBoxContent() {
		String result = "";
		for(int i = 0; i < messages.size(); i++) {
			result += "<p>";
			result += messages.get(i).displayString() + "\n";
			result += "</p>";
		}
		return result;
	}
	
	private void addMessage(String author, String content) {
		messages.add(new Message(author, content));
		if(messages.size() > messageCap) {
			messages.remove(0);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String message = request.getParameter("messageContent");
		if(username != "" && message != "") {
			addMessage(username, message);
		}
		doGet(request, response);
	}

}
