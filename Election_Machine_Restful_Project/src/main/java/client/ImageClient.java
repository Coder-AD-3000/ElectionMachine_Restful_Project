package client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.Candidate;

@WebServlet(urlPatterns = {"/handleimage"})
public class ImageClient extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {
		
		/*
		First Steps:
			1) Right click on the project folder
			2) Select new -> Source folder
			3) Select webapp as parent directory
			4) Name it as: img
		*/
		
		Candidate c = new Candidate(); // Single candidate object from DB (for example: candidate 1032, Mickey, Mouse, .... , profile1032.jpg, ...)
		c.getPic();
		
		// Source folder => always thes same
		String source = "img/";
		
		// Will change based on candidate_id => u may retrieve candidate_id from session attribute
		String img = "test.jpg"; // It comse from the DB, use getSession.getAttribute("userId") based on Id use a getter (getPic() to get the picture name and format (profile_1032.jpg)
		// You may create file's location with getClass().getResource();
		// sevice method should read out single candidate data => name of picture (profile_1003.jpg)
		
		request.setAttribute("image", source+img);
		request.getRequestDispatcher("/jsp/test.jsp").forward(request, response);		
	}
}
