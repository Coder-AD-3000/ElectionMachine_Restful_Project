package services;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Newquestion;

@Path("/newquestionservice")
public class NewquestionService {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("emachinedb");
	@GET
	@Path("/readnewquestion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Newquestion> readNewquestion() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Newquestion> list=em.createQuery("select xyx from Newquestion xyx").getResultList();		
		em.getTransaction().commit();
		return list;
	}	
	@POST
	@Path("/addnewquestion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Newquestion> addNewquestion(Newquestion newquestion) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(newquestion);//The actual insertion line
		em.getTransaction().commit();
		//Calling the method readFish() of this service
		List<Newquestion> list=readNewquestion();		
		return list;
	}	
	@PUT
	@Path("/updatenewquestion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Newquestion> updateNewquestion(Newquestion newquestion) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Newquestion nq=em.find(Newquestion.class, newquestion.getNewquestionId());
		if (nq!=null) {
			em.merge(newquestion);//The actual update line
		}
		em.getTransaction().commit();
		//Calling the method readFish() of this service
		List<Newquestion> list=readNewquestion();		
		return list;
	}	
	@DELETE
	@Path("/deletenewquestion/{newquestion_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Newquestion> deleteNewquestion(@PathParam("newquestion_id") int newquestion_id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Newquestion nq=em.find(Newquestion.class, newquestion_id);
		if (nq!=null) {
			em.remove(nq);//The actual insertion line
		}
		em.getTransaction().commit();
		//Calling the method readFish() of this service
		List<Newquestion> list=readNewquestion();		
		return list;
	}	
	@GET
	@Path("/readtoupdatenewquestion/{newquestion_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Newquestion readToUpdateNewquestion(@PathParam("newquestion_id") int newquestion_id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Newquestion nq=em.find(Newquestion.class, newquestion_id);
		em.getTransaction().commit();
		return nq;
	}	
}

