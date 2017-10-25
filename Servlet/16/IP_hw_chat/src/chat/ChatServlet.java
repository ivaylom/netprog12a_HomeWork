package chat;

import java.io.IOException;
import java.io.PrintWriter;

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
	
	private String[] messages;
	private int message_counter;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatServlet() {
        super();
        message_counter = 0;
        messages = new String[20];
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html>\n" + "<head><h3>Talk to people and stuff</h3><hr><title>Servlet chat</title></head>\n" + "<body>\n");
		
		out.println("<div style=\"height:300px;width:700px;border:1px solid #ccc; overflow:auto;\">");
		for(int i = 0; i < 20; i++)
		{
			out.println("<p>" + messages[i] + "<hr> </p>\n");
		}
		out.println("</div>\n");
		
		out.println("<form method=\"post\">"
				+ "Name: <input type=\"text\" name=\"username\"/><br/>"
				+ "Message: <input type=\"text\" name=\"usermsg\"/><br/>"
				+ "<input type=\"submit\" value=\"Send\"/>");

		out.println("<button>Refresh</button>\n");
		
		out.println("</body>" + "</html>");
		
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tempname=request.getParameter("username");  
		String tempmsg=request.getParameter("usermsg");
		if(tempname != "")
		{
			if(message_counter == 20)
			{
				for(int temp = 0; temp < 19; temp++)
				{
					messages[temp] = messages[temp+1];
				}
				messages[19] = "";
				message_counter = 19;
			}
			messages[message_counter] = tempname + ": " + tempmsg;
			message_counter++;
		}
		doGet(request, response);
	}

}
