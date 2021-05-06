package client;

import java.io.*;
import java.util.*;

import javax.mail.Session;
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
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import data.Answer;
import data.Candidate;
import data.Question;

@WebServlet(urlPatterns = {"/addallanswer", "/showresults"})
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
		  
		  // Read all questions
		  List<Question> questionList = readAllQuestion(request);
		  
		  // Read all answers
		  String action = request.getServletPath();
		  List<Answer> answerList = getAllAnswer(request, questionList);
		  

		  
		  
		  
		  
		  
		  
		  switch (action) {
		  case "/addallanswer":
//			  list = addAllAnswer(request);
			  addAllAnswer(request);
			  System.out.println("Case: addallanswer");
			  System.out.println("ArrList: " + answerList);
			  break;
		
		  case "/showresults":
//				********** SAVING ANSWERS *******************************************************************************						
				int i = 1;
				while (request.getParameter("selected" + i) != null) {
					Answer a = new Answer();
					a.setQuestionId(i);
					a.setAnswer(request.getParameter("selected" + i));
					answerList.add(a);
					i++;
				}
				
//				********** PRINTING ALL THE ANSWERS *********************************************************************
				for (int j = 0; j < answerList.size(); j++) {
					
					System.out.println("Answer " + answerList.get(j).getQuestionId() + ": " + answerList.get(j).getAnswer());
				}
			  
			  
			  break;

	  }
  }
	  
//	  *************************************************************************************************************************
//	  ***************** CUSTOM METHODS ****************************************************************************************
//	  *************************************************************************************************************************
	  private List<Answer> getAllAnswer(HttpServletRequest request, List<Question> questionList) {
		  List<Answer> answers = new ArrayList<Answer>();
		  
		  // Getting candidate_id
		  HttpSession session = request.getSession(true);			
		  String userId = (String) session.getAttribute("userid");
		  
		  // The answer params from the JSP will be amended with question_ids and saved as answer object => List.
		  for (Question q : questionList) {
			  // Getting questions and answers
			  int questionId = q.getId();
			  String answerValue = request.getParameter("question_id" + q.getId());
			  
			  if(userId != null) {
			  Answer a = new Answer(
					  userId, 
					  questionId, 
					  answerValue, 
					  "candidate answer");
			  answers.add(a);
			  }
			  else {
				  Answer a = new Answer(
						  questionId, 
						  answerValue);
				  answers.add(a);
			  }
		  }	
		  return answers;
	  }
	  
	  private List<Question> readAllQuestion(HttpServletRequest request) {
			
			String uri = "http://127.0.0.1:8080/rest/questionservice/readquestion";
			
			Client c = ClientBuilder.newClient();
			WebTarget wt = c.target(uri);
			Builder b = wt.request();
			
			//Create a GenericType to be able to get List of objects
			//This will be the second parameter of post method
			GenericType<List<Question>> gl = new GenericType<List<Question>>() {};
			List<Question> result = b.get(gl);
			
			return result;
	  }
	  
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

}