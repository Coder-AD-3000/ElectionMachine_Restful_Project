package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Candidate;

@Path("/profileservice")
public class profileservice {
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

}
