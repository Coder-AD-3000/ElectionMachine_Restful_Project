package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Candidate;

@Path("/profileservice")
public class ProfileService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("emachinedb");
	@GET
	@Path("/readtoupdateprofile/{candidate_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Candidate readToUpdateCandidate(@PathParam("candidate_id") int candidate_id) {
		EntityManager entitymanager = emf.createEntityManager();
		entitymanager.getTransaction().begin();
		Candidate cand=entitymanager.find(Candidate.class, candidate_id);
		entitymanager.getTransaction().commit();
		return cand;
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/readallcandidate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Candidate> readAllCandidate() {
		EntityManager entitymanager=emf.createEntityManager();
		entitymanager.getTransaction().begin();
		List<Candidate> list=entitymanager.createQuery("select x from Candidate x").getResultList();
		entitymanager.getTransaction().commit();
		return list;
	}
	
	@PUT
	@Path("/updatecandidate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCandidate(Candidate candidate) {
		EntityManager entitymanager = emf.createEntityManager();
		entitymanager.getTransaction().begin();
		Candidate cand = entitymanager.find(Candidate.class, candidate.getCandidate_id());
		if (cand!=null) {
			entitymanager.merge(candidate);//The actual update line
		}
		entitymanager.getTransaction().commit();
		//Calling the method readCandidate() of this service		
	}
	
	@DELETE
	@Path("/deletecandidate/{candidate_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteCandidate(@PathParam("candidate_id") int candidate_id) {
		EntityManager entitymanager=emf.createEntityManager();
		entitymanager.getTransaction().begin();
		Candidate cand = entitymanager.find(Candidate.class, candidate_id);
		if (cand!=null) {
			entitymanager.remove(cand);//The actual insertion line
		}
		entitymanager.getTransaction().commit();	
	}		
}
