package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Employee;

/**
 * Rest service for Employee Entity leading to employee table through JPA.
 * 
 * @author Les
 * @version 1.0
 * Date: May 4, 2021
 */
@Path("/employeeservice")
public class EmployeeService {
	
	/**
	 * Links Employee Entity to emachinedb database's tables
	 */
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("emachinedb");

	/**
	 * Reads all columns and rows of employee table into a list
	 * 
	 * @return complete employee table as list
	 */
	@GET
	@Path("/reademployee")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Employee> readEmployee() {
		EntityManager entitymanager = emf.createEntityManager();
		
		entitymanager.getTransaction().begin();
		List<Employee> list = entitymanager.createQuery("select x from Employee x").getResultList();
		entitymanager.getTransaction().commit();
		
		return list;
	}	
	
	
	/**
	 * Adds and employee to employee table utilizing JPA and Employee Entity
	 * 
	 * @param emp takes arg Employee object instance for employee to be added
	 * @return updated complete list of employees from employee table
	 */
	@POST
	@Path("/addemployee")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Employee> addEmployee(Employee emp) {
		EntityManager entitymanager = emf.createEntityManager();
		
		entitymanager.getTransaction().begin();
		entitymanager.persist(emp);
		entitymanager.getTransaction().commit();

		List<Employee> list = readEmployee();	
		
		return list;
	}
	
	
	/**
	 * Updates and existing employee in the employee table
	 * 
	 * @param emp takes arg Employee object instance for employee to be updated
	 * @return updated complete list of employees from employee table
	 */
	@PUT
	@Path("/updateEmployee")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Employee> jupdateEmployee(Employee emp) {
		EntityManager entitymanager = emf.createEntityManager();
		
		entitymanager.getTransaction().begin();
		Employee e = entitymanager.find(Employee.class, emp.getEmployee_id());
		if (e!=null) {
			entitymanager.merge(emp);
		}
		entitymanager.getTransaction().commit();

		List<Employee> list = readEmployee();	
		
		return list;
	}	
	
	
	/**
	 * Deletes an employee specified by employee_id from the employee table.
	 * 
	 * @param emp takes arg of path parameter which is utilized as an integer to signify 
	 * employee_id of employee to be deleted
	 * @return complete updated employee table as list
	 */
	@DELETE
	@Path("/deleteEmployee/{employee_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Employee> deleteEmployee(@PathParam("employee_id") int emp) {
		EntityManager entitymanager = emf.createEntityManager();
		
		entitymanager.getTransaction().begin();
		Employee e = entitymanager.find(Employee.class, emp);
		if (e!=null) {
			entitymanager.remove(e);
		}
		
		entitymanager.getTransaction().commit();

		List<Employee> list = readEmployee();
		
		return list;
	}
	
	
	/**
	 * Reads in employee_id of employee to update through REST to get instance
	 * 
	 * @param emp takes arg path parameter of employee_id which is utilized as 
	 * an integer leading to the employee_id of the employee to be updated
	 * @return Employee instance object located through employee_id from employee table
	 */
	@GET
	@Path("/readtoupdateEmployee/{employee_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee readToupdateEmployee(@PathParam("employee_id") int emp) {
		EntityManager entitymanager = emf.createEntityManager();
		
		entitymanager.getTransaction().begin();
		Employee e = entitymanager.find(Employee.class, emp);
		entitymanager.getTransaction().commit();
		
		return e;
	}
	
}
