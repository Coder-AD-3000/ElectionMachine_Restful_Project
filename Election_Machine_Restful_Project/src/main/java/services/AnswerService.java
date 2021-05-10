package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Answer;

@Path("/answerservice")
public class AnswerService {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("emachinedb");
	
	@POST
	@Path("/addoneanswer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveOneAnswer(Answer answer) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(answer); //The actual insertion line
			em.getTransaction().commit();
			
			System.out.println("answers saved into the db");
		}
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/readonecandidateanswers/{candidate_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Answer> readOneCandidateAnswers(@PathParam("candidate_id") int candidate_id) {
		EntityManager entitymanager = emf.createEntityManager();
		entitymanager.getTransaction().begin();
		List<Answer> list = entitymanager.createNativeQuery("select * from answer where candidate_id = " + candidate_id, Answer.class).getResultList();
		entitymanager.getTransaction().commit();
		return list;
	}
	
}