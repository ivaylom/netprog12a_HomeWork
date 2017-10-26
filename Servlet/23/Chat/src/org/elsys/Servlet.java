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
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	int numberOfMessages = 0;
	private static List <Info> messageInfo = new ArrayList <Info>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		for(Info i : messageInfo) 
		{
			//if(i.getName().isEmpty() != true)
			//{
				if(i.getMessage().isEmpty() != true)
				{
					response.getOutputStream().println("<p>" + i.getName() + Info.spacing + i.getMessage() + "</p>");
				}
			//}	
		}
		
		response.getOutputStream().println("<html><head><meta charset='UTF-8'></head>" +
				"<body><font size=30>" +
					"<form method='POST'>" +
						"<input type='text' name='name' placeholder='Name' />" +
						"<input type='text' name='message' placeholder='Message' /> " +
						"<input type='submit' value='Submit/Send' />" +
					"</form>" +	
						"<button>Refresh</button>" +
				"</font></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Info info = new Info(request.getParameter("name"),request.getParameter("message") );

		if(numberOfMessages<20)
		{
			messageInfo.add(info);
			numberOfMessages += 1;
		}else
		{
			messageInfo.remove(0);
			messageInfo.add(info);
		}
		
		doGet(request,response);
	}

}
