package client;

import java.io.IOException;
import java.util.Collections;
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
/**
 * @author Daniel
 *
 */
@WebServlet(urlPatterns = {"/updatemyprofile", "/readmyprofile", "/deleteallmydata", "readallprofile"})
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
		String candidate_id = "0";
		if (session.getAttribute("userid") != null) {
			candidate_id = session.getAttribute("userid").toString();
		}
		
		
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
			
		case "/readallprofile":
			List<Candidate> allCanddiateList = readAllCandidate(request);
			Collections.reverse(allCanddiateList);
			request.setAttribute("profilelist", allCanddiateList);
			request.getRequestDispatcher("./jsp/candidates.jsp").forward(request, response);;
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
	/**
	 * @param request
	 * @return stacked List of candidate profiles
	 */
	private List<Candidate> readAllCandidate(HttpServletRequest request) {
		String uri = "http://127.0.0.1:8080/rest/profileservice/readallcandidate";
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();
		GenericType<List<Candidate>> genericList = new GenericType<List<Candidate>>() {};	
		List<Candidate> returnedList = builder.get(genericList);
		return returnedList;
	}
	
	/**
	 * Method is called when a single candidate profile needs to be fetched from DB
	 * @param request
	 * @param candidate_id identifies selected candidate
	 * @return Candidate object containing profile data
	 */
	private Candidate readToUpdateCandidate(HttpServletRequest request, String candidate_id) {
		String uri = "http://127.0.0.1:8080/rest/profileservice/readtoupdateprofile/"+candidate_id;
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();
		Candidate candidate = builder.get(Candidate.class);  
		return candidate;
	}
	
	/**
	 * Method will update candidate profile
	 * @param request
	 */
	private void updateCandidate(HttpServletRequest request) {
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
		
		System.out.println(candidate);
		String uri = "http://127.0.0.1:8080/rest/profileservice/updatecandidate";
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();
		Entity<Candidate> e = Entity.entity(candidate,MediaType.APPLICATION_JSON);
		GenericType<List<Candidate>> genericList = new GenericType<List<Candidate>>() {};		
		builder.put(e, genericList);

	}
	
	/**
	 * Method is called upon candidate removal. In case FK is present in the DB associated entires will also be removed.
	 * @param request
	 * @param candidate_id identifies canddiate
	 */
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
