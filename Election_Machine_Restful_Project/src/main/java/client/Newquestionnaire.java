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

import data.Newquestion;

/**
 * @author ΕΚ
 * @version 1.0
 * Date: May 4, 2021
 * This servlet is used as the mid layer client and the 
 * Client, WebTarget and a Builder are used to make requests
 * to a service.
 *		
 */
@WebServlet(urlPatterns = {"/addnewquestion", "/deletenewquestion","/updatenewquestion","/readnewquestion","/readtoupdatenewquestion"})
public class Newquestionnaire extends HttpServlet {

	  @Override
	  public void doPost(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
		  doGet(request, response);
	  }
	  
	  @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
	  String action = request.getServletPath();
//Newquestion is an instance of the Newquestion class.
	  List<Newquestion> list=null;
	  switch (action) {
	  case "/addnewquestion":
		  list=addnewquestion(request);break;
	  case "/deletenewquestion":
		  String newquestion_id=request.getParameter("newquestion_id");
		  list=deletenewquestion(request);break;
	  case "/updatenewquestion":
		  list=updatenewquestion(request);break;
	  case "/readnewquestion":
		  list=readnewquestion(request);break;
	  case "/readtoupdatenewquestion":
		  Newquestion nq=readtoupdatenewquestion(request);
		  request.setAttribute("newquestion", nq);
		  RequestDispatcher rd=request.getRequestDispatcher("./jsp/newquestiontoupdateform.jsp");
		  rd.forward(request, response);
		  return;
	  }
	  request.setAttribute("newquestionlist", list);
	  RequestDispatcher rd=request.getRequestDispatcher("./jsp/newquestionform.jsp");
	  rd.forward(request, response);
  }
	    /* 
		 *  A Client, WebTarget and Builder are required in order to make a request to the service.
		 *  The request is executed through the Builder type object.
		 *  A Newquestion object is returned from the service and Jersey converts it
		 * 	into JSON. The JSON in this client application is received, and we give the 
		 * 	Newquestion class as a parameter to the method "get" of the builder object.
		 * 	Jersey converts the JSON string back into a Newquestion type object.
		 */
	private Newquestion readtoupdatenewquestion(HttpServletRequest request) {
		String newquestion_id=request.getParameter("newquestion_id");
		String uri = "http://127.0.0.1:8080/rest/newquestionservice/readtoupdatenewquestion/"+newquestion_id;
//Creation of a new Client object using ClientBuilder
		Client c=ClientBuilder.newClient();
//Create a new WebTarget object using the Client object just created. 
//The creation of WebTarget needs the URL to the service as a parameter.
		WebTarget wt=c.target(uri);
//Create a new Builder object using WebTarget object just created.
		Builder b=wt.request();
		Newquestion newquestion=b.get(Newquestion.class);
		return newquestion;
	}
	 	/**
		 * @param request
		 * @param nq, it adds new questions in the database
		 * 
		 */
	private List<Newquestion> addnewquestion(HttpServletRequest request) {
		//A Newquestion object to send to our web-service 
		Newquestion nq=new Newquestion(request.getParameter("new_question"));
		System.out.println("req.getParam(new_question)" + nq);
		
		String uri = "http://127.0.0.1:8080/rest/newquestionservice/addnewquestion";
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Here we create an Entity of a Newquestion object as JSON string format
		Entity<Newquestion> e=Entity.entity(nq,MediaType.APPLICATION_JSON);
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Newquestion>> genericList = new GenericType<List<Newquestion>>() {};
		
		//Posting data (Entity<ArrayList<Newquestion>> e) to the given address
		List<Newquestion> returnedList=b.post(e, genericList);
		return returnedList;
	}
	  /**
	 * @param request
	 * @return List of Newquestion type containing all the questions from DB.
	 */
	private List<Newquestion> readnewquestion(HttpServletRequest request) {
		String newquestion_id=request.getParameter("newquestion_id");
		String uri = "http://127.0.0.1:8080/rest/newquestionservice/readnewquestion";
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Newquestion>> genericList = new GenericType<List<Newquestion>>() {};
		
		List<Newquestion> returnedList=b.get(genericList);
		return returnedList;
	}
	  /**
	 * @param request
	 * @param nq takes an Newquestion object containing all the new information to be stored in the database.
	 */
	private List<Newquestion> updatenewquestion(HttpServletRequest request) {
		//A Newquestion object to send to our web-service 
		Newquestion nq=new Newquestion(request.getParameter("newquestion_id"), request.getParameter("new_question"));
		System.out.println(nq);
		String uri = "http://127.0.0.1:8080/rest/newquestionservice/updatenewquestion";
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Here we create an Entity of a Newquestion object as JSON string format
		Entity<Newquestion> e=Entity.entity(nq,MediaType.APPLICATION_JSON);
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Newquestion>> genericList = new GenericType<List<Newquestion>>() {};
		
		//Posting data (Entity<ArrayList<Newquestion>> e) to the given address
		List<Newquestion> returnedList=b.put(e, genericList);
		return returnedList;
	}
	/**
	 * @param request
	 * Database entries can be deleted based on their ID.
	 */
	private List<Newquestion> deletenewquestion(HttpServletRequest request) {
		String newquestion_id=request.getParameter("newquestion_id");
		String uri = "http://127.0.0.1:8080/rest/newquestionservice/deletenewquestion/"+newquestion_id;
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Newquestion>> genericList = new GenericType<List<Newquestion>>() {};
		
		//Posting data (Entity<ArrayList<Newquestion>> e) to the given address
		List<Newquestion> returnedList=b.delete(genericList);
		return returnedList;
	}
}