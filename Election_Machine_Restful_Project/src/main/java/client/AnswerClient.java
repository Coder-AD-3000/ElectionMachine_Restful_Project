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

import data.Answer;

@WebServlet(urlPatterns = {"/addallanswer"})
public class AnswerClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	@Override
	  public void doPost(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
		  doGet(request, response);
	  }
	  
	  @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
		  
		  System.out.println("AnswerClient.java");
		  
		  String action = request.getServletPath();
		  ArrayList<Answer> list = new ArrayList<Answer>(); 
		  switch (action) {
		  case "/addallanswer":
//			  list = addAllAnswer(request);
			  addAllAnswer(request);
			  System.out.println("Case: addallanswer");
			  System.out.println("ArrList: " + list);
			  break;

	  }
  }
	  
//	  *************************************************************************************************************************
//	  ***************** CUSTOM METHODS ****************************************************************************************
//	  *************************************************************************************************************************
	  private void addAllAnswer(HttpServletRequest request) {
//			A Candidate object to send to our web-service
			
			ArrayList<Answer> answerList = new ArrayList<Answer>();
			int i = 1;
			while (request.getParameter("question_id" + i) != null) {
//				<<< DEBUGGING MSG >>>
				System.out.println("QID: " + request.getParameter("question_id" + 1));
				System.out.println("Answer: " + request.getParameter("selected" + 1));
//				<<< ############# >>>
				
				Answer a = new Answer(
						"1", 
						request.getParameter("question_id" + i), 
						request.getParameter("selected" + i), 
						"Candidate's answer");
				answerList.add(a);
				
				System.out.println(a);
				
				i++;
			}
			
			for (int j = 0; j < answerList.size(); j++) {		
				String uri = "http://127.0.0.1:8080/rest/answerservice/addoneanswer";
				Client c = ClientBuilder.newClient();
				WebTarget wt = c.target(uri);
				Builder b = wt.request();
				
//				<<< DEBUGGING MSG >>>
				System.out.println("Trying to create entities and generic list...");
//				<<< ############# >>>
				
				Answer a = answerList.get(j);
				
				//Here we create an Entity of a Candidate object as JSON string format
				Entity<Answer> e = Entity.entity(a, MediaType.APPLICATION_JSON);
				//Create a GenericType to be able to get List of objects
				//This will be the second parameter of post method
				GenericType<ArrayList<Answer>> genericList = new GenericType<ArrayList<Answer>>() {};
				//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
				b.post(e, genericList);
				
//				<<< DEBUGGING MSG >>>
				System.out.println("Entity created...");
//				<<< ############# >>>
				
				//return returnedList;
			}
			
		}

}