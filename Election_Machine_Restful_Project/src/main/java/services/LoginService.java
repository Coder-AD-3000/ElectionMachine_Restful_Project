package services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Candidate;

@Path("/loginservice")
public class LoginService {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("emachinedb");
	
	@GET
	@Path("/readcandidate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Candidate> readCandidate() {
		EntityManager entitymanager=emf.createEntityManager();
		entitymanager.getTransaction().begin();
		List<Candidate> list=entitymanager.createQuery("select x from Candidate x").getResultList();
		entitymanager.getTransaction().commit();
		return list;
	}	
	
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello from a protected service method";
	}
	


//	@POST
//	@Path("/candidatelogin/{user}/{pwd}")
//	public String candLogin(@FormParam("user") String user, @FormParam("pwd") String pwd) {
//	
////	ArrayList<Candidate> arrlist = ();//pack all usernames and passwords from table users to arrlist
//	
//	
//	}
	
	
//	@POST
//	@Path("/employeelogin/{user}/{pwd}")
//	public String empLogin(@FormParam("user") String user, @FormParam("pwd") String pwd) {
//	
////	ArrayList<Candidate> arrlist = ();//pack all usernames and passwords from table users to arrlist
//	
//
//	}


}
