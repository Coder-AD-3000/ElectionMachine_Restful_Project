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

import data.Question;

/**
 * Servlet implementation class QuestionnaireClient
 */
@WebServlet("/QuestionnaireClient")
public class QuestionnaireClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionnaireClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Question> list = new ArrayList<Question>();
		
		for (int i = 0; i < 10; i++) {
			int question_id = i+1;
			Question question = new Question();
			question.setId(question_id);
			question.setQuestion("This is a dummy question");
			list.add(question);
		}
		
		request.setAttribute("questionlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("./jsp/questionnaire.jsp");
		  rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
