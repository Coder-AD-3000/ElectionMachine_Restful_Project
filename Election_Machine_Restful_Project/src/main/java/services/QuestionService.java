package services;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Question;


@Path("/questionservice")
public class QuestionService {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("emachinedb");
	
	@GET
	@Path("/readquestion")
	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Question> readQuestion(Question question) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			@SuppressWarnings("unchecked")
			ArrayList<Question> arrlist = (ArrayList<Question>) em.createQuery("select * from emachinedb.question").getResultList();	
//			ArrayList<Question> arrlist = (ArrayList<Question>) em.createQuery("select xyx from question xyx").getResultList();		
			em.getTransaction().commit();
			
			System.out.println("Questions read from table..");
			return arrlist;
		}

}
