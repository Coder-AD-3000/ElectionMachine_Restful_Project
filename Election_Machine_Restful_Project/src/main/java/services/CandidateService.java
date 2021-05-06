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

import data.Candidate;

@Path("/candidateservice")
public class CandidateService {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("emachinedb");
	@GET
	@Path("/readcandidate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Candidate> readCandidate() {
		EntityManager entitymanager=emf.createEntityManager();
		entitymanager.getTransaction().begin();
		List<Candidate> list=entitymanager.createQuery("select x from Candidate x").getResultList();	/* AD - Table */
		entitymanager.getTransaction().commit();
		return list;
	}	
	@POST
	@Path("/addcandidate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Candidate> addCandidate(Candidate candidate) {
		EntityManager entitymanager = emf.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(candidate);//The actual insertion line
		entitymanager.getTransaction().commit();
		//Calling the method readCandidate() of this service
		List<Candidate> list=readCandidate();		
		return list;
	}	
	@PUT
	@Path("/updatecandidate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Candidate> updateCandidate(Candidate candidate) {
		EntityManager entitymanager = emf.createEntityManager();
		entitymanager.getTransaction().begin();
		Candidate cand = entitymanager.find(Candidate.class, candidate.getCandidate_id());
		if (cand!=null) {
			entitymanager.merge(candidate);//The actual update line
		}
		entitymanager.getTransaction().commit();
		//Calling the method readCandidate() of this service
		List<Candidate> list=readCandidate();		
		return list;
	}	
	@DELETE
	@Path("/deletecandidate/{candidate_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Candidate> deleteCandidate(@PathParam("candidate_id") int candidate_id) {
		EntityManager entitymanager=emf.createEntityManager();
		entitymanager.getTransaction().begin();
		Candidate cand = entitymanager.find(Candidate.class, candidate_id);
		if (cand!=null) {
			entitymanager.remove(cand);//The actual insertion line
		}
		entitymanager.getTransaction().commit();
		//Calling the method readCandidate() of this service
		List<Candidate> list=readCandidate();		
		return list;
	}	
	@GET
	@Path("/readtoupdatecandidate/{candidate_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Candidate readToUpdateCandidate(@PathParam("candidate_id") int candidate_id) {
		EntityManager entitymanager=emf.createEntityManager();
		entitymanager.getTransaction().begin();
		Candidate cand=entitymanager.find(Candidate.class, candidate_id);
		entitymanager.getTransaction().commit();
		return cand;
	}
	
	/* AD - This is a useful addition */	
	@GET
	@Path("/readtodeletecandidate/{candidate_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Candidate readTodeletecandidate(@PathParam("candidate_id") int candidate_id) {
		EntityManager entitymanager=emf.createEntityManager();
		entitymanager.getTransaction().begin();
		Candidate cand=entitymanager.find(Candidate.class, candidate_id);
		entitymanager.getTransaction().commit();
		return cand;
	}
	
	
	
	
}
