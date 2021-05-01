package services;


import java.util.ArrayList;
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
import data.Question;


@Path("/questionservice")
public class QuestionService {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("emachinedb");
	
	@GET
	@Path("/readquestion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Question> readQuestion() {
		EntityManager entitymanager = emf.createEntityManager();
		entitymanager.getTransaction().begin();
		
		System.out.println("about to read question");
		
		List<Question> list = entitymanager.createQuery("select x from Question x").getResultList();
		
		System.out.println("I read the fucking question");
		
		entitymanager.getTransaction().commit();
		return list;
	}

}
