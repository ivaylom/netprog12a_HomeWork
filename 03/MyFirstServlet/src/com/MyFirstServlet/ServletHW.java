package com.MyFirstServlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class HW1
 */
@WebServlet("/HW1")
public class ServletHW extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String[] messages= {"","","","","","","","","","","","","","","","","","","","",""};
	public int counter;
	//private String message;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHW() {
        super();
        this.counter=0;
        // TODO Auto-generated constructor stub
       
       
    }
   
    	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		
		 response.getOutputStream().println("<html><body><font size=30>" +
					"<form method='Post'>" +
						"<input type='text' name='name' placeholder='Name' />" +
						"<input type='text' name='surname' placeholder='Surname' /> " +
						"<input type='text' name='message' placeholder='Message' /> "+
						"<input type='submit' />" +
						"<br>"
						
						+
					"</form>" +
						
					"<form method='POST'>" +
					"<button name='refresh' type='submit' value='Refresh'>Refresh</button>"+
					"</form>"
					+
					"</font></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		String name = request.getParameter("name") ;
		String surname= request.getParameter("surname");
		String message= request.getParameter("message");   
		
		if((name!=null) && (surname!=null) && (message!=null) )
	{messages[counter++]=name+" "+surname+" "+message+"<br>";}
		response.getOutputStream().println("<html><body><font size=20> " + 
				"<form method='Post'>" +
				Arrays.asList(messages).toString().substring(1).replaceFirst("]", "").replace(", ", "") 
				+
				"</form>"
				+ 
				"</font></body></html>");
		
		//counter++;
		if(counter==20)
		{String[] yourArray = Arrays.copyOfRange(messages, 1, messages.length);
		System.arraycopy( yourArray, 0, messages, 0, yourArray.length );
		counter--;
			
			}
		
	}

}
