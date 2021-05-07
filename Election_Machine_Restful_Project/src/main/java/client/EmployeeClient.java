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
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import data.Candidate;
import data.Employee;

@WebServlet(urlPatterns = {"/reademployee", "/addemployee", "/updateemployee", "/deleteemployee", "/readtoupdateemployee"})
public class EmployeeClient extends HttpServlet{

	  @Override
	  public void doPost(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
		  
		  doGet(request, response);
	  }
	  
	  
	  @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
	      
		  String action = request.getServletPath();
		  List<Employee> list = null; 
		  
		  switch (action) {
			  case "/addemployee":
				  list = addemployee(request);
				  break;
			  case "/deleteemployee":
				  list = deleteemployee(request);
				  break;
			  case "/updateemployee":
				  list = updateemployee(request);
				  break;
			  case "/reademployee":
				  list = reademployee(request);
				  break;
			  case "/readtoupdateemployee":
				  Employee emp = readtoupdateemployee(request);
				  request.setAttribute("employee", emp);
				  RequestDispatcher reqdisp = request.getRequestDispatcher("./jsp/employeetoupdateform.jsp");
				  reqdisp.forward(request, response);
				  return;
		  }
		  
		  request.setAttribute("employeelist", list);
		  RequestDispatcher reqdisp = request.getRequestDispatcher("./jsp/employeeform.jsp");
		  reqdisp.forward(request, response);
	  }

    	  
	private Employee readtoupdateemployee(HttpServletRequest request) {
		String employee_id = request.getParameter("employee_id");
		String uri = "http://127.0.0.1:8080/rest/employeeservice/readtoupdateemployee/" + employee_id;
		
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();
		
		Employee emp = builder.get(Employee.class);  
		return emp;
	}

	private List<Employee> addemployee(HttpServletRequest request) {

		Employee emp = new Employee(request.getParameter("employee_id"), 
				request.getParameter("first_name"),
				request.getParameter("last_name"), 
				request.getParameter("username"),
				request.getParameter("password"));
		
		// LH - Role may need to be added 
		
		System.out.println(emp);
		
		String uri = "http://127.0.0.1:8080/rest/employeeservice/addemployee";
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();

		Entity<Employee> e = Entity.entity(emp,MediaType.APPLICATION_JSON);

		GenericType<List<Employee>> genericList = new GenericType<List<Employee>>() {};		
		 
		List<Employee> returnedList = builder.post(e, genericList);
		return returnedList;
	}
	
	
	private List<Employee> reademployee(HttpServletRequest request) {

		String uri = "http://127.0.0.1:8080/rest/employeeservice/reademployee";
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();

		GenericType<List<Employee>> genericList = new GenericType<List<Employee>>() {};
		
		List<Employee> returnedList = builder.get(genericList);
		return returnedList;
	}
	
	
	private List<Employee> updateemployee(HttpServletRequest request) {

		Employee emp = new Employee(request.getParameter("employee_id"), 
				request.getParameter("first_name"), 
				request.getParameter("last_name"),
				request.getParameter("username"),
				request.getParameter("password"));
		
		System.out.println(emp);
		
		String uri = "http://127.0.0.1:8080/rest/employeeservice/updateemployee";
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();

		Entity<Employee> e = Entity.entity(emp, MediaType.APPLICATION_JSON);

		GenericType<List<Employee>> genericList = new GenericType<List<Employee>>() {};		
	 
		List<Employee> returnedList = builder.put(e, genericList);
		return returnedList;
	}
	
	
	private List<Employee> deleteemployee(HttpServletRequest request) {
		String employee_id = request.getParameter("employee_id");
		
		String uri = "http://127.0.0.1:8080/rest/employeeservice/deleteemployee/" + employee_id;
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target(uri);
		Builder builder = webtarget.request();

		GenericType<List<Employee>> genericList = new GenericType<List<Employee>>() {};		
	 
		List<Employee> returnedList = builder.delete(genericList);
		return returnedList;
	}
	
}
