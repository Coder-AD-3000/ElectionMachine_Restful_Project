package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;

import data.Candidate;

/**
 * Servlet implementation class LoginClient
 */

@WebServlet(urlPatterns = {"/logincandidate", "/loginemployee", "/logout"})
public class LoginClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		************* GET ITEMS AND PARAMS **********************************************************************************
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession();
		System.out.println("Session ID: " + session.getId());
		
		String unInput = request.getParameter("user");
		String pwInput = request.getParameter("pwd");

//		*************** CONTROLLER ******************************************************************************************
		String action = request.getServletPath();
		switch (action) {
		case "/logincandidate":
			if (session.getAttribute("username") != null) {
				System.out.println("Session: " + session.getId());			     
			} 
			else {			
				System.out.println("Session was created");
				
				List<Candidate> arrList = readcandidate(request);
				
				for (Candidate c: arrList)					
					if (c.getUsername().equals(unInput) && c.getPassword().equals(pwInput)) {						
								
						System.out.println("login match with userId: " + c.getCandidate_id() + " & username: " + c.getUsername());
						
						session.setAttribute("username", c.getUsername());						
						session.setAttribute("userid", c.getCandidate_id());
						session.setAttribute("role", "candidate");
						
						writer.println("You are matched... Say Hello!");				       
						writer.println("Session ID: " + session.getId());				        
						writer.println("Creation Time: " + new Date(session.getCreationTime()));				        
						writer. println("Last Accessed Time: " + new Date(session.getLastAccessedTime()));				        			        
						writer.println("---------------------------------------------------------------");
					}				
					else {
					    writer.println("No matching un & pw here!");			
					}	 	
			}
			
			break;
		case "/loginemployee":
			/*
			List<Employee> arrList = readcandidate(request);
			
			for (Employee e: arrList)					
				if (e.getUsername().equals(unInput) && e.getPassword().equals(pwInput)) {						
							
					System.out.println("login match with userId: " + e.getEmployee_id());
					
					session.setAttribute("username", e.getUsername());						
					session.setAttribute("userid", e.getEmployee_id());
					session.setAttribute("role", "employee");	
				}				
				else {
					writer.println("No matching un & pw here!");			
				}	
			break;
			*/
		case "/logout":
			
			if (request.getSession().getAttribute("username") != null) {
			    System.out.println("a session exists");
			    session.invalidate();
			    System.out.println("session destroyed");
			     
			} else {
				System.out.println("no session");
			}
			
			/*
			System.out.println("User was logged out!");
			session.invalidate();
			System.out.println("Session destroyed: " + session.getId());
			*/
			break;		
		 }
		
//		***************** PRINTER *******************************************************************************************												
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
//	****************************************************************************************************************************
//	*************** CUSTOM METHODS *********************************************************************************************
//	****************************************************************************************************************************
	private List<Candidate> readcandidate(HttpServletRequest request) {

		String uri = "http://127.0.0.1:8080/rest/loginservice/readcandidate";
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();

		GenericType<List<Candidate>> genericList = new GenericType<List<Candidate>>() {};
		
		List<Candidate> returnedList = builder.get(genericList);
		return returnedList;
	}
}
