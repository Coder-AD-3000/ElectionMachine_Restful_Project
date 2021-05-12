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
//Creation of the EntityManager from the EntityManagerFactory
		EntityManager em=emf.createEntityManager();
//When using default (RESOURCE-LOCAL) transaction type every transaction must begin and end (commit).
		em.getTransaction().begin();	
//Reading all the data from the database table newquestion and returns a list of objects in JSON string format
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
//In the method below, a newquestion object is persisted (inserted) into the database.
		em.persist(newquestion);//The actual insertion line
		em.getTransaction().commit();
//The readNewquestion() method of this service is called.
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
//The function find is called to ensure, that in the database is a record with the same id.
		Newquestion nq=em.find(Newquestion.class, newquestion.getNewquestionId());
		if (nq!=null) {
			em.merge(newquestion);//The actual update line
		}
		em.getTransaction().commit();
//Calling the method readNewquestion() of this service
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
//Calling the method readNewquestion() of this service
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
//In the code below a Newquestion type object with id value newquestion_id is read from the database. 
//The find function needs two parameters: the class of entity and an id. 
//The first parameter (here: Newquestion.class) tells the table name where to search.		
		Newquestion nq=em.find(Newquestion.class, newquestion_id);
		em.getTransaction().commit();
		return nq;
	}	
}

