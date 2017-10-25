package net.codejava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GreetingsWearyServlet")
public class GreetingsWearyServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private List<String> messages = new ArrayList<String>();
	
	
    public GreetingsWearyServlet()
    {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		PrintWriter out = response.getWriter();
		
		out.println("<HTML>\n" + "<BODY>\n");
		out.println("<div style=\"height: 500px; width: 1000px; border-width: 3px; border-style: double; overflow:auto;\">");
		
		for(int i = 0; i < messages.size(); i++)
		{
			out.println("<p>" + messages.get(i) + "<hr> </p>\n");
		}
				
		out.println("</div>\n");
		
		out.println("<form method=\"POST\">");
		out.println("Userame: <input type=\"text\" name=\"username\"/><br/>");
		out.println("Message: <input type=\"text\" name=\"message\"/><br/>");
		out.println("<input type=\"submit\" value=\"Send\"/>");
		
		out.println("<button>Refresh</button>\n");
		out.println("</BODY>" + "</HTML>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String message = request.getParameter("message");
		
		messages.add(username + ": " + message);
		
		if(username != "" && message != "")
		{
			if (messages.size() > 20)
			{
				messages.remove(0);
			}
		}
		
		doGet(request, response);
	}
}
