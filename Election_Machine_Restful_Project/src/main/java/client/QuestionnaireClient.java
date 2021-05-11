package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;

import data.Answer;
import data.Candidate;

/**
 * Servlet implementation class QuestionnaireClient
 */
@WebServlet("/questionnaireclient")
public class QuestionnaireClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionnaireClient() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		********** SAVING ANSWERS *******************************************************************************		
		ArrayList<Answer> list = new ArrayList<Answer>();
		
		int i = 1;
		while (request.getParameter("selected" + i) != null) {
			Answer a = new Answer();
			a.setQuestionId(i);
			a.setAnswer(request.getParameter("selected" + i));
			list.add(a);
			i++;
		}
		
//		********** PRINTING ALL THE ANSWERS *********************************************************************
		for (int j = 0; j < list.size(); j++) {
			
			System.out.println("Answer " + list.get(j).getQuestionId() + ": " + list.get(j).getAnswer());
		}
		
		
//		********** COMPARING WITH CANDIDATES ********************************************************************

		
//		********** SENDING RESPONSE *****************************************************************************
//		request.setAttribute("answerlist", list);
//		RequestDispatcher rd = request.getRequestDispatcher("./jsp/questionnaireresults.jsp");
//		  rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
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
