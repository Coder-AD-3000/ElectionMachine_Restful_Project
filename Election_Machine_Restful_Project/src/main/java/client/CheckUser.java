package client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;

import data.Candidate;
import data.Employee;

/**
 * @author Daniel
 * Servlet implementation class CheckUser
 * Will check user data upon login attempt
 * 
 */
@WebServlet(urlPatterns = {"/checkuser", "/logout"})
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();
		switch (action) {
		case "/checkuser":	
			String user = request.getParameter("user");
			String pwd = request.getParameter("pwd");
			boolean isMatching = false;
			
			System.out.println("Login: Checking Candidate table...");
			List<Candidate> candidateList = readCandidate(request);	
			for (Candidate c: candidateList)					
				if (c.getUsername().equals(user) && c.getPassword().equals(pwd)) {						
							
					System.out.println("login match with userId: " + c.getCandidate_id() + " & username: " + c.getUsername());
				
//					Creating session for candidate
					HttpSession session = request.getSession(true);
					session.setAttribute("username", c.getUsername());						
					session.setAttribute("userid", c.getCandidate_id());
					session.setAttribute("role", c.getRole());
					isMatching = true;
				}
			
			System.out.println("Login: Checking Employee table...");
			if (isMatching == false) {
				List<Employee> employeeList = readEmployee(request);
				for (Employee e: employeeList)					
					if (e.getUsername().equals(user) && e.getPassword().equals(pwd)) {						
								
						System.out.println("login match with userId: " + e.getEmployee_id() + " & username: " + e.getUsername());
						
//						Creating session for employee
						HttpSession session = request.getSession(true);
						session.setAttribute("username", e.getUsername());						
						session.setAttribute("userid", e.getEmployee_id());
						session.setAttribute("role", e.getRole());
						isMatching = true;
					}				
			}
						
			// Redirect page based on DB matches
			if (isMatching) {
				response.sendRedirect("/jsp/candidatePortal.jsp");
			}
			else {
				response.sendRedirect("/jsp/loginPage.jsp");
			}		
			break;
			
		case "/logout":
			HttpSession session = request.getSession(true);
			session.invalidate();
			session = null;
			response.sendRedirect("/jsp/loginPage.jsp");	
			break;
		}	
	}
	
	/**
	 * @param request
	 * @return The list of all available candidate
	 */
	private List<Candidate> readCandidate(HttpServletRequest request) {
		String uri = "http://127.0.0.1:8080/rest/loginservice/readcandidate";
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();
		GenericType<List<Candidate>> genericList = new GenericType<List<Candidate>>() {};		
		List<Candidate> returnedList = builder.get(genericList);
		return returnedList;
	}
	
	/**
	 * @param request
	 * @return The list of all available employee
	 */
	private List<Employee> readEmployee(HttpServletRequest request) {
		String uri = "http://127.0.0.1:8080/rest/loginservice/reademployee";
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();
		GenericType<List<Employee>> genericList = new GenericType<List<Employee>>() {};	
		List<Employee> returnedList = builder.get(genericList);
		return returnedList;
	}

}
