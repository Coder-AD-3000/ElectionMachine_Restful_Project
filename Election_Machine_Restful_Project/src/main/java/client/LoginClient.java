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
@WebServlet("/LoginClient")
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
		PrintWriter writer = response.getWriter();
		
		String unInput = request.getParameter("user");
		String pwInput = request.getParameter("pwd");
		
		System.out.println("unInput: " + unInput);
		System.out.println("pwd: " + pwInput);
		
		List<Candidate> arrList = readcandidate(request);
		
		for (Candidate c: arrList)
			if (c.getUsername().equals(unInput) && c.getPassword().equals(pwInput)) {
				
				System.out.println("login match with userId: " + c.getCandidate_id());

				HttpSession session = request.getSession();
				session.setAttribute("username", c.getUsername());
				session.setAttribute("userid", c.getCandidate_id());
				
				
				writer.println("You are matched... Say Hello!");
		        writer.println("Session ID: " + session.getId());
		        writer.println("Creation Time: " + new Date(session.getCreationTime()));
		        writer. println("Last Accessed Time: " + new Date(session.getLastAccessedTime()));
		        writer.println("Logged in as: " + c.getUsername());
		        writer.println("---------------------------------------------------------------");
		  }
			else {
		        writer.println("No matching un & pw here!");	
			}
		
		
		
		
//		for (Candidate c: arrlist)
//			if (c.username.equals(user) && c.password.equals(pwd)) {
//				return c.getId(); //to string
//				System.out.println("login match with userId: " + c.getId());
//				//start session or add cookie
//		  }
		
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
