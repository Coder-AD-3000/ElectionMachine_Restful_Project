package client;

import java.io.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

@WebServlet(urlPatterns = {"/addcandidate", "/deletecandidate","/updatecandidate","/readcandidate","/readtoupdatecandidate"})
public class CandidateClient extends HttpServlet {

	  @Override
	  public void doPost(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
		  doGet(request, response);
	  }
	  
	  @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
		  
	  String action = request.getServletPath();
	  List<Candidate> list=null; /* AD - Candidate is the class instance*/
	  switch (action) {
	  case "/addcandidate":
		  list=addcandidate(request);break;
	  case "/deletecandidate":
		  //String candidate_id=request.getParameter("candidate_id"); /* AD - I can't see a use for this line */
		  list=deletecandidate(request);break;
	  case "/updatecandidate":
		  list=updatecandidate(request);break;
	  case "/readcandidate":
		  list=readcandidate(request);break;
	  case "/readtoupdatecandidate":
		  Candidate candidate = readtoupdatecandidate(request);
		  request.setAttribute("candidate", candidate);
		  RequestDispatcher reqdisp=request.getRequestDispatcher("./jsp/candidatetoupdateform.jsp");
		  reqdisp.forward(request, response);
		  return;
	  }
	  request.setAttribute("candidatelist", list);
	  RequestDispatcher reqdisp=request.getRequestDispatcher("./jsp/candidateform.jsp");
	  reqdisp.forward(request, response);
  }

	private Candidate readtoupdatecandidate(HttpServletRequest request) {
		String candidate_id=request.getParameter("candidate_id");
		String uri = "http://127.0.0.1:8080/rest/candidateservice/readtoupdatecandidate/"+candidate_id;
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();
		Candidate candidate = builder.get(Candidate.class);  
		return candidate;
	}

	private List<Candidate> addcandidate(HttpServletRequest request) {
		//A Candidate object to send to our web-service 
		Candidate candidate = new Candidate(request.getParameter("first_name"), 
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
		 
		List<Candidate> returnedList=builder.post(e, genericList);
		return returnedList;
	}
	
	private List<Candidate> readcandidate(HttpServletRequest request) {
		//String candidate_id = request.getParameter("candidate_id"); /* AD - I can't see a use for this line */
		String uri = "http://127.0.0.1:8080/rest/candidateservice/readcandidate";
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Candidate>> genericList = new GenericType<List<Candidate>>() {};
		
		List<Candidate> returnedList = builder.get(genericList);
		return returnedList;
	}
	
	private List<Candidate> updatecandidate(HttpServletRequest request) {
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
	
	private List<Candidate> deletecandidate(HttpServletRequest request) {
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