package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Candidate;
import data.Employee;

/**
 * @author Daniel
 * Service methods for the CheckUser Servlet class
 */
@Path("/loginservice")
public class LoginService {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("emachinedb");
	
	/**
	 * Will fetch all candidate data out from database
	 * @return list of candidate objects
	 */
	@SuppressWarnings("unchecked")
	@GET
	@Path("/readcandidate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Candidate> readCandidate() {
		EntityManager entitymanager = emf.createEntityManager();
		entitymanager.getTransaction().begin();
		List<Candidate> list = entitymanager.createQuery("select x from Candidate x").getResultList();
		entitymanager.getTransaction().commit();
		return list;
	}
	
	/**
	 * read all employee data out from database
	 * @return list of employee objects
	 */
	@SuppressWarnings("unchecked")
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
	
	
//	@GET
//	@Path("/hello")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String sayHello() {
//		return "Hello from a protected service method";
//	}
}
