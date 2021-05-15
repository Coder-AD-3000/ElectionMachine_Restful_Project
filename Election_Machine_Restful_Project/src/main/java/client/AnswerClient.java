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
import data.Candidate;
import data.Question;

/**
 * @author Daniel
 * 
 * AnswerClient will process the submitted questionnaire answers for both voters and candidates.
 * User will be identified based on the session data (user_id and role), which will determine the chain of actions.
 *
 */
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
//		  Reading all questions
		  List<Question> questionList = readAllQuestion(request);
		  
//		  Collecting all the submitted answers
		  List<Answer> answerListSubmitted = returnSubmittedAnswers(request, questionList);
		  
//		  Print to console
		  for (Answer answer : answerListSubmitted) {
			System.out.println("answer: " + answer.getAnswer());
		}
		  
//		  ************ GET SESSION DATA ********************************************************************************************
		  String role;
		  if(request.getSession().getAttribute("role") != null) {
			  role = request.getSession().getAttribute("role").toString(); 
		  }
		  else {
			  role = "voter";
		  }
//		  Print to console		  
		  System.out.println("role from session is: " + role);
		  
//		  ************ EVALUATE OR SAVE BASED ON ROLE *******************************************************************************  
		  switch (role) {
//		  A: Voter's answers will be evaluated and matched
		  default:			  
//			  1) Fetch all candidates profile from DB (stacked data)
			  List<Candidate> candidateListStacked = readAllCandidates(request);
			  
//			  2) Compare all candidates with the voter
			  List<Candidate> scoredCandidateListStacked = evaluateAllCandidates(request, 
					  candidateListStacked, answerListSubmitted, questionList);
			  
//			  3) Sort Candidates into descending order
			  Collections.sort(scoredCandidateListStacked , new Comparator<Candidate>() {
				//Will organise elements into ascending order.
				  @Override public int compare(Candidate o1, Candidate o2) {
					  return o2.getTotalScore() - o1.getTotalScore(); }});
			  for (Candidate c : scoredCandidateListStacked) {				
				  System.out.println("***Candidate Id: " + c.getCandidate_id() + " - Score: " + c.getTotalScore());
			  }
			  
//			  4) Store top 3 candidates as attributes
			  request.setAttribute("candidate_1st", scoredCandidateListStacked.get(0));
			  request.setAttribute("candidate_2nd", scoredCandidateListStacked.get(1));
			  request.setAttribute("candidate_3rd", scoredCandidateListStacked.get(2));
			  
//			  5) Store voter's answers as attribute
			  request.setAttribute("answerListVoter", answerListSubmitted);
			  
//			  6) Forward top 3 candidates
			  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/questionnaireResults.jsp"); 
			  dispatcher.forward(request, response);
			  
			  break;
//		  B: Candidate's answers will be saved in the DB		  
		  case "candidate":
//			  1) Getting candidate_id from session
			  int candidate_id = (int) request.getSession().getAttribute("userid");
			  System.out.println("candidate id: " + candidate_id);
			  
//			  2) Checking for answers in the DB
			  List<Answer> candidateOldAnswers = readOneCandidateAnswers(request, candidate_id);
			  System.out.println("candidateOldAnswers size: " + candidateOldAnswers.size());
			  
//			  a) If there is any => UPDATE
			  if(candidateOldAnswers.size() > 0) {
//				  Print to console
				  System.out.println("Updating answer table...");
//				  Iterating through the List of answers and replacing them in the DB
				  for (Answer answer_old : candidateOldAnswers) {
					  for (Answer answer_new : answerListSubmitted) {
//						  Selecting answer with the same question_id
						  if (answer_old.getQuestionId() == answer_new.getQuestionId()) {
//							  Amending submitted answer with DB answer_id
							  answer_new.setAnswerId(answer_old.getAnswerId());
//							  Executing update
							  updateOneCandidateAnswer(request, answer_new);  			
						  }  
					  }
				  }
				  request.setAttribute("message", "Your submission was updated successfully!");
			  }
//			  b) If there is none => INSERT
			  else {
				  System.out.println("Saving answers into DB ...");
				  saveCandidateAnswers(request, answerListSubmitted);
				  request.setAttribute("message", "Your submission was uploaded successfully! You may do a re-take any time.");
			  }			  
			  			  
//			  3) Redirect to index			  
			  getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
			  break;
	  }
  }
	  
//	  *************************************************************************************************************************
//	  ***************** SERVICE METHODS ***************************************************************************************
//	  *************************************************************************************************************************  
	  /**
	 * @param request
	 * @return List of Question type containing all thw questions from DB
	 */
	private List<Question> readAllQuestion(HttpServletRequest request) {			
			String uri = "http://127.0.0.1:8080/rest/questionservice/readquestion";			
			Client c = ClientBuilder.newClient();
			WebTarget wt = c.target(uri);
			Builder b = wt.request();
			
			GenericType<List<Question>> gl = new GenericType<List<Question>>() {};
			List<Question> result = b.get(gl);
			
			return result;
	  }
	  
	  /**
	 * @param request
	 * @param answerList takes a List of Answer type containing all the submitted questionnaire answers 
	 * to be saved into the DB
	 */
	private void saveCandidateAnswers(HttpServletRequest request, List<Answer> answerList) {  
		  for (Answer a : answerList) {
//			  Print to console
			  System.out.println("question_id: " + a.getQuestionId() + "; candidate_id: " + a.getCandidateId() + "; answer value: " + a.getAnswer());		  
			  String uri = "http://127.0.0.1:8080/rest/answerservice/addoneanswer";
			  Client c = ClientBuilder.newClient();
			  WebTarget wt = c.target(uri);				
			  Builder b = wt.request();			  
			  Entity<Answer> e = Entity.entity(a, MediaType.APPLICATION_JSON);	
			  GenericType<ArrayList<Answer>> genericList = new GenericType<ArrayList<Answer>>() {};
			  b.post(e, genericList);		
		  }			
	  }
	  
	  /**
	 * @param request
	 * @param answer_new takes an Answer object containing all the new information to be stored in the DB
	 */
	private void updateOneCandidateAnswer(HttpServletRequest request, Answer answer_new) {		  
			  String uri = "http://127.0.0.1:8080/rest/answerservice/updateoneanswer/";
			  Client c = ClientBuilder.newClient();
			  WebTarget wt = c.target(uri);				
			  Builder b = wt.request();	
			  Entity<Answer> e = Entity.entity(answer_new, MediaType.APPLICATION_JSON);	
			  GenericType<List<Answer>> genericList = new GenericType<List<Answer>>() {};
			  b.put(e, genericList);				  		  
	  }
	  
	  /**
	 * @param request
	 * @param candidate_id takes an int, that will be used as a path param to read the selected 
	 * candidate's answers from the DB
	 * @return List of Answer that conatins a certain candidate's answers to the questionnaire
	 */
	private List<Answer> readOneCandidateAnswers(HttpServletRequest request, int candidate_id) {			
		  String uri = "http://127.0.0.1:8080/rest/answerservice/readonecandidateanswers/"+candidate_id;
		  Client client = ClientBuilder.newClient();
		  WebTarget webtarget = client.target(uri);	
		  Builder builder = webtarget.request();	
		  GenericType<List<Answer>> genericList = new GenericType<List<Answer>>() {};
		  List<Answer> returnedList = builder.get(genericList); 
		  
		  return returnedList;
	  }
	
	  /**
	 * @param request
	 * @return List of Candidate object containing all the candidate profile data (stacked data)
	 */
	private List<Candidate> readAllCandidates(HttpServletRequest request) {
		  String uri = "http://127.0.0.1:8080/rest/candidateservice/readcandidate";
		  Client client = ClientBuilder.newClient();
		  WebTarget webtarget = client.target(uri);
		  Builder builder = webtarget.request();
		  GenericType<List<Candidate>> genericList = new GenericType<List<Candidate>>() {};
		  List<Candidate> returnedList = builder.get(genericList);

		  return returnedList;
	  }
	  
//	  ******************************************************************************************************************
//	  ************************ CUSTOM METHODS **************************************************************************
//	  ******************************************************************************************************************
	  /**
	 * @param request
	 * @param questionList takes a List of Question objects containing all information regarding 
	 * to the current questionnaire questions
	 * @return List of Answer objects containing all the submitted questionnaire answer data
	 */
	private List<Answer> returnSubmittedAnswers(HttpServletRequest request, List<Question> questionList) {
		  List<Answer> answers = new ArrayList<Answer>();		  	  
		  // The answer params from the JSP will be amended with question_ids and saved as answer object => List.
		  for (Question q : questionList) {
			  // Getting questions and answers
			  int questionId = q.getId();
			  String answerValue = request.getParameter("selected" + q.getId());
			  
			  // For candidates
			  if(request.getSession(false).getAttribute("userid") != null) {  
				  String userId = request.getSession(false).getAttribute("userid").toString();
				  Answer a = new Answer(
						  userId,
						  questionId, 		  
						  answerValue,   
						  "Answer to question");
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
	  
	  /**
	 * @param request takes current HTTP request as arg
	 * @param candidateListStacked List of Candidate objects containing all the available candidate profile data
	 * @param answerListSubmitted contains all the submitted answer data as a List of Answer type
	 * @param questionList conatins all the question data associated with the questionnaire
	 * @return scored candidate list
	 */
	public List<Candidate> evaluateAllCandidates(HttpServletRequest request, 
			  List<Candidate> candidateListStacked, 
			  List<Answer> answerListSubmitted, 
			  List<Question> questionList) {
//		  List to be returned at the end
		  List<Candidate> scoredCandidateListStacked = new ArrayList<Candidate>();
		  for (Candidate c : candidateListStacked) {
//			  Will be used for questionnaire evaluation
			  int score = 0;
			  
//			  Print to console
			  System.out.println("****************************** CANDIDATE ********************************");
			  System.out.println("candidate: " + c);
			  System.out.println("*************************************************************************");
//			  Getting candidate_id and reading associated answers from DB
			  int candidateId = c.getCandidate_id();
			  List<Answer> oneCandidateAnswers = readOneCandidateAnswers(request, candidateId);
		  
			  
//			  For each candidate the ans will be listed and compared  
			  for (int i = 0; i < oneCandidateAnswers.size(); i++) {
				  Answer answerC = oneCandidateAnswers.get(i);
				  Answer answerV = answerListSubmitted.get(i);

				  if (answerC.getQuestionId() == answerV.getQuestionId()) {
					  score = score + Math.abs(answerV.getAnswer() - answerC.getAnswer()); 
				  }
				  else {
					  System.out.println("Question IDs are not matching!");
				  }
			  }
			  
//			  Amend candidate data with total score value
			  int numberOfQuestions = questionList.size();
			  int maxDiffPerQuestion = Integer.parseInt(request.getParameter("max_answer")) - Integer.parseInt(request.getParameter("min_answer"));
			  int maxPossibleScore = maxDiffPerQuestion * numberOfQuestions;				  
			  int scoreInPercent = 100 - (100 * score / maxPossibleScore); // smallest score means better accuracy
			  
			  c.setTotalScore(scoreInPercent);
			  c.setQuestionList(questionList);
			  c.setAnswerList(oneCandidateAnswers);
			  scoredCandidateListStacked.add(c);
			  System.out.println("Candidate ID: " + c.getCandidate_id() + " -> Score is: " + scoreInPercent + "%");
		  }
//		  Print to console
		  for (Candidate c : scoredCandidateListStacked) {
			  System.out.println("Candidate with score: " + c);			
		}
		return scoredCandidateListStacked;
	  }

}