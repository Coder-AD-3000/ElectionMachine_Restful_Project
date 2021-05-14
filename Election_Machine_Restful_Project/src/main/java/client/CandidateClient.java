package client;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import data.Candidate;

/**
 * @author ashle
 *	AD - Here a servlet is utilised as the client. In servlets, a 'writer' 
 *		is utilised, which is made available via the response object.
 *
 *		To be able to make a request to a service, we need a Client, WebTarget and a Builder.
 *
 *
 *		These methods contain window builder instructions (commands)
 *		With these commands we are preparing entities for sending to the RESTFUL service
 *		
 *		So the builder is preparing the entities to send to the RESTful service
 *		Then in the RESTful method, it will handle the database entries
 *		eg you can update and delete etc...
 *
 *		So the client is a controller and it makes decisions, and the RESTful will execute
 *		a method based on the decision.
 *		
 */
/**
 * 
 * Servlet implementation CandidateClient class
 * 
 * @author ashley
 *
 */
@WebServlet(urlPatterns = {"/addcandidate", "/deletecandidate",
		"/updatecandidate","/readcandidate",
		"/readtodeletecandidate","/readtoupdatecandidate"})


public class CandidateClient extends HttpServlet {

	  /**
	 *
	 */
	@Override
	  public void doPost(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
		  doGet(request, response);
	  }
	  
	  /**
	 *
	 */
	@Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
	  String action = request.getServletPath();
	  List<Candidate> list=null; /* AD - Candidate is the class instance*/
	  switch (action) {
	  case "/addcandidate":
		  list=addCandidate(request);break;
	  case "/deletecandidate":
		  //String candidate_id=request.getParameter("candidate_id"); /* AD - I can't see a use for this line */
		  list=deleteCandidate(request);break;
	  case "/updatecandidate":
		  list=updateCandidate(request);break;
	  case "/readcandidate":
		  list=readCandidate(request);break;
	  case "/readtoupdatecandidate":
		  Candidate candidate = readToUpdateCandidate(request);
		  request.setAttribute("candidate", candidate);
		  RequestDispatcher reqdisp=request.getRequestDispatcher("./jsp/candidatetoupdateform.jsp");
		  reqdisp.forward(request, response);
		  return;
		  
		  // AD - I added this for readtodeletecandidate
	  case "/readtodeletecandidate":
		  Candidate candidateDel = readToDeleteCandidate(request);
		  request.setAttribute("candidate", candidateDel);
		  RequestDispatcher reqdispDel=request.getRequestDispatcher("./jsp/candidatetodeleteform.jsp");
		  reqdispDel.forward(request, response);
		  return;  	  
		  
	  }
	  request.setAttribute("candidatelist", list);
	  RequestDispatcher reqdisp=request.getRequestDispatcher("./jsp/candidateform.jsp");
	  reqdisp.forward(request, response);
  }

	/**
	 * @param request
	 * @return This method will update a candidate and return candidate instance object
	 */
	private Candidate readToUpdateCandidate(HttpServletRequest request) {
		String candidate_id=request.getParameter("candidate_id");
		/* AD - Here, the local variable uri has 
		 * 		the value of the whole URL to the service.
		 * 		
		 * 		A Client, WebTarget and Builder are required in order to make a request to the service.*/
		String uri = "http://127.0.0.1:8080/rest/candidateservice/readtoupdatecandidate/"+candidate_id;
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();
		/* AD - Via the Builder type object we make a request.
		 * 		Here a GET type request is executed, as the service requires.
		 * 
		 * 		A Candidate object is returned from the service and Jersey converts it
		 * 		into JSON. The JSON in this client application is received, and we give 
		 * 		Candidate.class as a parameter to the method "get" of the builder object.
		 * 		Jersey converts the JSON string back into a Candidate type object.*/
		Candidate candidate = builder.get(Candidate.class);  
		return candidate;
	}
	
	
	// AD - I added this for read to delete
	/**
	 * @param request
	 * @return returns a candidate instance object
	 */
	private Candidate readToDeleteCandidate(HttpServletRequest request) {
		String candidate_id=request.getParameter("candidate_id");
		String uri = "http://127.0.0.1:8080/rest/candidateservice/readtodeletecandidate/"+candidate_id;
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();
		Candidate candidate = builder.get(Candidate.class);  
		return candidate;
	}

	/**
	 * @param request
	 * @return an updated list of candidates, which includes the new addition.
	 */
	private List<Candidate> addCandidate(HttpServletRequest request) {
		//A Candidate object to send to our web-service 
		Candidate candidate = new Candidate(request.getParameter("candidate_id"), 
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
		String uri = "http://127.0.0.1:8080/rest/candidateservice/addcandidate";
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();
		//Here we create an Entity of a Candidate object as JSON string format
		Entity<Candidate> e = Entity.entity(candidate,MediaType.APPLICATION_JSON);
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Candidate>> genericList = new GenericType<List<Candidate>>() {};		
		
		//Posting data (Entity<ArrayList<Candidate>> e) to the given address
		List<Candidate> returnedList=builder.post(e, genericList);
		return returnedList;
	}
	
	/**
	 * @param request
	 * @return a list of candidate objects containing all candidates from the candidate table.
	 */
	private List<Candidate> readCandidate(HttpServletRequest request) {
		//String candidate_id = request.getParameter("candidate_id"); /* AD - I can't see a use for this line */
		String uri = "http://127.0.0.1:8080/rest/candidateservice/readcandidate";
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Candidate>> genericList = new GenericType<List<Candidate>>() {};
		
		//Posting data (Entity<ArrayList<Candidate>> e) to the given address
		List<Candidate> returnedList = builder.get(genericList);
		return returnedList;
	}
	
	private List<Candidate> updateCandidate(HttpServletRequest request) {
		//A Candidate object to send to our web-service 
		Candidate candidate = new Candidate(request.getParameter("candidate_id"), 
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
		String uri = "http://127.0.0.1:8080/rest/candidateservice/updatecandidate";
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
	
	/**
	 * @param request
	 * @return an updated list of candidates, with the deleted candidate data no longer present in the database.
	 */
	private List<Candidate> deleteCandidate(HttpServletRequest request) {
		String candidate_id=request.getParameter("candidate_id");
		String uri = "http://127.0.0.1:8080/rest/candidateservice/deletecandidate/"+candidate_id;
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Candidate>> genericList = new GenericType<List<Candidate>>() {};		
	 
		List<Candidate> returnedList = builder.delete(genericList);
		return returnedList;
	}
}