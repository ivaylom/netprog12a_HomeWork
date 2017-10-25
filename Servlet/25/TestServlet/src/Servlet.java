

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String[] messages;
	private int messageCounter;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
       
        messages = new String[20];
        messageCounter = 0;
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		out.println("<html>\n" +  "<body>\n");
		
		out.println("<div style=\"background-color: yellow;height:70%;width:50%;border:1px solid black;margin:auto; \">" + "<h1 style=\"margin:auto;width:40%;color:green;overflow:auto\">Java Servlet web app/chat Box</h1><hr><title>Homework 01 - Chatbox</title></head>\n" );
		for(int i = 0; i < 20; i++)
		{
			if(messages[i] != null)
			out.println("<p>" + messages[i] + "<hr> </p>\n");
		}
		out.println("</div>\n");
		
		out.println("<form  method=\"post\" style=\"margin:auto;width:60%\">"
				+ "<br>"
				+ "Name: <input type=\"text\" name=\"nickname\"/><br/>"
				+ "<br>"
				+ "Message: <input type=\"text\" name=\"content\"/><br/>"
				+ "<input type=\"submit\" value=\"Send\"/>");

		out.println(" <INPUT TYPE=\"button\" onClick=\"history.go(0)\" VALUE=\"Refresh\">\n");
		out.println("\n");
		response.getWriter().append("Served at: ").append(request.getContextPath());

		
		out.println("</body>" + "</html>");
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname = request.getParameter("nickname");  
		String content = request.getParameter("content");
		if(nickname != "")
		{
			if(messageCounter == 20)
			{
				for(int temp = 0; temp < 19; temp++)
				{
					messages[temp] = messages[temp+1];
				}
				messages[19] = "";
				messageCounter = 19;
			}
			messages[messageCounter] = nickname + ": " + content;
			messageCounter++;
		}
		doGet(request, response);
	}

}
