package client;

import java.io.IOException;
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
import data.Question;


/**
 * @author Daniel
 *
 */
@WebServlet(urlPatterns = {"/readallquestion"})
public class QuestionClient extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionClient() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	    throws IOException, ServletException {
		  
		doGet(request, response);
	  }
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		
//		Fetching questions from DB
		List<Question> arrlist = readQuestion(request);
		
//		Forwarding questions to view page
		request.setAttribute("questionlist", arrlist);
		RequestDispatcher rd = request.getRequestDispatcher("./jsp/questionnaire.jsp");
		  rd.forward(request, response);
	}
	  
	
	/**
	 * @param request
	 * @return List of Question objects conatining all available question from DB.
	 */
	private List<Question> readQuestion(HttpServletRequest request) {
		
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
	
}
