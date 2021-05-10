package client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import data.Candidate;

/**
 * Servlet implementation class ProfileClient
 */
@WebServlet(urlPatterns = {"/updatemyprofile", "/readmyprofile", "/deleteallmydata"})
public class ProfileClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//Getting candidate_id from session object (login)
		HttpSession session = request.getSession(true);						
		String candidate_id = session.getAttribute("userid").toString();
		
		//Getting URI
		String action = request.getServletPath();
		
		//Acting based on URI path
		switch (action) {
		//Will read profile data from DB so it can be amended
		case "/readmyprofile":
			Candidate candidate = readToUpdateCandidate(request, candidate_id);
			request.setAttribute("candidate", candidate);
		  
			System.out.println("candidate name: " + candidate.getFirst_name());
//		  
			RequestDispatcher reqdisp=request.getRequestDispatcher("./jsp/profiletoupdateform.jsp");
			reqdisp.forward(request, response);		
			break;

		case "/deleteallmydata":
			deleteCandidate(request, candidate_id);
			session.invalidate();
			session = null;
			response.sendRedirect("/jsp/loginPage.jsp");
			break;
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Will be used upon update (updateform)
		
		updateCandidate(request);
		response.sendRedirect("/readmyprofile");

	}

//	**************************************************************************************************
//	************ CUSTOM METHODS *********************************************************************
//	**************************************************************************************************
	private Candidate readToUpdateCandidate(HttpServletRequest request, String candidate_id) {
		String uri = "http://127.0.0.1:8080/rest/profileservice/readtoupdateprofile/"+candidate_id;
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();
		Candidate candidate = builder.get(Candidate.class);  
		return candidate;
	}
	
	private List<Candidate> updateCandidate(HttpServletRequest request) {
		//A Candidate object to send to our web-service 
		Candidate candidate = new Candidate(
				request.getParameter("candidate_id"), 
				request.getParameter("first_name"), 
				request.getParameter("last_name"),
				request.getParameter("party"),
				request.getParameter("location"),
				request.getParameter("age"),
				request.getParameter("mission"),
				request.getParameter("vision"),
				request.getParameter("pic"),
				request.getParameter("profession"),
				request.getParameter("username"),
				request.getParameter("password"));
		
		System.out.println("pic: " + request.getParameter("pic"));
		System.out.println(candidate);
		String uri = "http://127.0.0.1:8080/rest/profileservice/updatecandidate";
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();
		//Here we create an Entity of a Candidate object as JSON string format
		Entity<Candidate> e = Entity.entity(candidate,MediaType.APPLICATION_JSON);
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Candidate>> genericList = new GenericType<List<Candidate>>() {};		
	 
		List<Candidate> returnedList = builder.put(e, genericList);
		return returnedList;
	}
	
	private void deleteCandidate(HttpServletRequest request, String candidate_id) {
		String uri = "http://127.0.0.1:8080/rest/profileservice/deletecandidate/"+candidate_id;
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Candidate>> genericList = new GenericType<List<Candidate>>() {};		
		builder.delete(genericList);
	}
}
