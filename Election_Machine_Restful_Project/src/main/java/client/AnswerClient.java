package client;

import java.io.*;
import java.util.*;

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

@WebServlet(urlPatterns = {"answerclient", "/addallanswer", "/showresults"})
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
//		  ************ COLLECT ANSWERS AND QUESTIONS *******************************************************************************
		  System.out.println("AnswerClient.java");
		  
//		  Read all questions
		  List<Question> questionList = readAllQuestion(request);
		  
//		  Read all answers
		  List<Answer> answerList = getAllAnswer(request, questionList);
		  
		  for (Answer answer : answerList) {
			System.out.println("answer: " + answer.getAnswer());
		}
	
		  
//		  ************ EVALUATE OR SAVE BASED ON ROLE *******************************************************************************  
//		  String role = request.getSession().getAttribute("role").toString();
		  String role = "voter";
		  System.out.println("role from session is: " + role);
		  
		  switch (role) {
//		  Voter's answers will be evaluated and matched
		  default:
//			  Read all answers from DB
			  
//			  Read all candidates profile from DB (stacked data)
			  List<Candidate> candidateListStacked = readAllCandidates(request);
			  for (Candidate c : candidateListStacked) {
//				  Getting candidate_id and reading associated answers from DB
				  int candidateId = c.getCandidate_id();
				  List<Answer> oneCandidateAnswers = readOneCandidateAnswers(request, candidateId);
				  System.out.println("answers of " + candidateId + oneCandidateAnswers);
				  
			}
			  

			  break;
//		  Candidate's answers will be saved in the DB		  
		  case "candidate":
//			  list = addAllAnswer(request);
			  addAllAnswer(request, answerList);
			  System.out.println("Case: addallanswer");
			  System.out.println("ArrList: " + answerList);
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
//		  String userId = session.getAttribute("userid").toString();
		  String userId = "1034";
		  
		  // The answer params from the JSP will be amended with question_ids and saved as answer object => List.
		  for (Question q : questionList) {
			  // Getting questions and answers
			  int questionId = q.getId();
			  String answerValue = request.getParameter("selected" + q.getId());
			  
			  // For candidates
			  if(userId != null) {
			  Answer a = new Answer(
					  userId, 
					  questionId, 
					  answerValue, 
					  "candidate answer");
			  answers.add(a);
			  }
			  // For regular users (voters)
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
	  
	  private void addAllAnswer(HttpServletRequest request, List<Answer> answerList) {
		  
		  
		  for (Answer a : answerList) {
			  System.out.println("question_id: " + a.getQuestionId() + "; candidate_id: " + a.getCandidateId() + "; answer value: " + a.getAnswer());
			  
			  String uri = "http://127.0.0.1:8080/rest/answerservice/addoneanswer";
			  Client c = ClientBuilder.newClient();
			  WebTarget wt = c.target(uri);				
			  Builder b = wt.request();
	
			  Entity<Answer> e = Entity.entity(a, MediaType.APPLICATION_JSON);	
			  GenericType<ArrayList<Answer>> genericList = new GenericType<ArrayList<Answer>>() {};
			  b.post(e, genericList);
			
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
	  
	  private List<Answer> readAnswers(HttpServletRequest request, int candidateId) {
		  //String candidate_id = request.getParameter("candidate_id");
		  String uri = "http://127.0.0.1:8080/rest/answerservice/readonecandidateanswers";
		  Client client = ClientBuilder.newClient();
		  WebTarget webtarget = client.target(uri);
		  Builder builder = webtarget.request();
		  GenericType<List<Answer>> genericList = new GenericType<List<Answer>>() {};
		  List<Answer> returnedList = builder.get(genericList);

		  return returnedList;
	  }
	  
	  private List<Answer> readOneCandidateAnswers(HttpServletRequest request, int candidate_id) {
			String uri = "http://127.0.0.1:8080/rest/candidateservice/readtodeletecandidate/"+candidate_id;
			Client client = ClientBuilder.newClient();
			WebTarget webtarget = client.target(uri);
			Builder builder = webtarget.request();
			GenericType<List<Answer>> genericList = new GenericType<List<Answer>>() {};
			List<Answer> returnedList = builder.get(genericList); 
			return returnedList;
	  }
	
	  private List<Candidate> readAllCandidates(HttpServletRequest request) {
		  String uri = "http://127.0.0.1:8080/rest/candidateservice/readcandidate";
		  Client client = ClientBuilder.newClient();
		  WebTarget webtarget = client.target(uri);
		  Builder builder = webtarget.request();
		  GenericType<List<Candidate>> genericList = new GenericType<List<Candidate>>() {};
		  List<Candidate> returnedList = builder.get(genericList);

		  return returnedList;
		}

}