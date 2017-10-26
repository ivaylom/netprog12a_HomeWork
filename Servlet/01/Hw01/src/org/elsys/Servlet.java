package org.elsys;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
	private List<String> data = new ArrayList<String>();
	
	
    public Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private String parsehtml() {
    	String html = "";
    	String parsedData = "";
    	//Take last 20 messages
    	for(String el : data.subList(Math.max(data.size() - 20, 0), data.size())) {
			parsedData += el + "<br>";
		}
    	
    	html = "<html><body>" + 
    			"<form method='Post'>" + 
				"<input type='text' name = 'user' placeholder='User' />" +
				"<input type='text' name = 'message' placeholder='Your message' />" +
				"<input type='submit' />" +
				"</form>" +
				"<a href='/Hw01/Servlet'><button>Refresh</button></a>" +
				"<br>" + 
				"<div>" +
				parsedData +
				"</div>" + 
				"</html>";
		
		
		return html;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		response.getOutputStream().println(parsehtml());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	        String name = request.getParameter("user");
	        String message = request.getParameter("message");
	        
	        data.add(message); 
	        
	        response.setContentType("text/html");
			
			response.getOutputStream().println(parsehtml());
	        
	
	}
	
//	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String key = request.getParameter("key");
//		data.remove(key);
//	}
	
	

}
