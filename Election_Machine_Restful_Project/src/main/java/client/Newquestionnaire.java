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

	private Newquestion readtoupdatenewquestion(HttpServletRequest request) {
		String newquestion_id=request.getParameter("newquestion_id");
		String uri = "http://127.0.0.1:8080/rest/newquestionservice/readtoupdatenewquestion/"+newquestion_id;
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		Newquestion newquestion=b.get(Newquestion.class);
		return newquestion;
	}

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