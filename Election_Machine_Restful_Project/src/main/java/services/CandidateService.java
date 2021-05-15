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

/**
 * @author ashley
 * 
 * REST service which handles the candidate entity.
 * The candidate table is also persisted via JPA.
 *
 */
@Path("/candidateservice")
public class CandidateService {	
	
	/**
	 * AD - At the beginning of this class here, the 'EntityManagerFactory' object 'emf'
	 * 		is created from the 'emachinedb' persistence unit.
	 * 
	 * 		This links the candidate entity to the database.		
	 * 
	 */
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("emachinedb");
	/**    This method reads out the candidate table, into list format.
	 * @return a list of all entries in the candidate table
	 */
	@GET
	@Path("/readcandidate")
	@Produces(MediaType.APPLICATION_JSON) /* AD - returns a list of objects in JSON string format*/
	@Consumes(MediaType.APPLICATION_JSON) 
	public List<Candidate> readCandidate() {
		EntityManager entitymanager=emf.createEntityManager();
		entitymanager.getTransaction().begin();
		/* AD - This statement (between begin and commit) 
		 * 		reads all data from the table 'candidate.'
		 * 		The table is called 'candidate' and the data type (Entity)
		 * 		that is used, is 'Candidate.'
		 * 
		 * 		The statement returns a list of objects. Also, due to the
		 * 		annotation @Produces(MediaType.Application_JSON, the code
		 * 		returns a list in JSON string format.		 * 
		 *    */
			
		List<Candidate> list=entitymanager.createQuery("select x from Candidate x").getResultList();	/* AD - Table */
		entitymanager.getTransaction().commit();
		return list;
	}	
	/**
	 * Adds a candidate
	 * 
	 * @param candidate takes the candidate object as an argument (in order to add a new candidate to the list)
	 * @return a list of candidates from the candidate table (includes added candidate)
	 * 	 *  
	 */	
	@POST // We want to create an entry 
	@Path("/addcandidate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Candidate> addCandidate(Candidate candidate) {
		EntityManager entitymanager = emf.createEntityManager();
		entitymanager.getTransaction().begin();
		// AD - The method persist makes an insertion everytime, regardless if the object to be persisted, had an id with an existing value in the emachinedb.
		entitymanager.persist(candidate);// AD - a new 'candidate' object is inserted into the candidate table.
		entitymanager.getTransaction().commit();
		//This calls the method readCandidate() of this service
		List<Candidate> list=readCandidate();		
		return list;
	}	
	
	
	/**
	 * Updates the candidate information
	 * 
	 * @param candidate takes a candidate object instance as the argument. In this way, the candidate data can be updated.
	 * @return a list of candidates from the candidate table (with the amended data included).
	 * 
	 * AD - Updating happens via method merge. When updating (merging) an object,
	 * 		it is assumed that the database already contains a record with the same id as the 
	 * 		object to be updated. If there is no such existing id, the insertion will happen.
	 * 
	 * 		Before the merge takes place, there is a call of function 'find' to ensure that 
	 * 		in the database is a record with the same id.
	 * 
	 * 		PUT is similar to POST, but it is designed for the purpose of updating something.
	 * 		The data sent is not seen in the browser bar.
	 */
	@PUT // Updating in a database
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
		//This calls the method readCandidate() of this service
		List<Candidate> list=readCandidate();		
		return list;
	}	
	/**
	 * This method deletes a candidate from the candidate table.
	 * 
	 * @param candidate_id takes the argument of Path param, which designates the candidate id to be deleted.
	 * @return updated candidate table data is returned as a list
	 * 
	 * AD - The function 'remove' is utilised to delete from the database.
	 * 		Only one parameter is required - the object to be removed.
	 * 		
	 * 		Significantly, 'find' is used to first ensure that there is in fact an object to delete.
	 * 		DELETE behaves similar to get (to get something), yet its purpose is to DELETE something.
	 * 		A client can make a request, via PathParam, which instructs which object is to be deleted
	 * 		from the database.
	 * 
	 * 		On the client side the request method is now delete. On the server side the annotation is
	 * 		"@DELETE". Furthermore, data sent is visible in the browser's location bar.
	 * 
	 */
	@DELETE // Delete 
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
		//This calls the method readCandidate() of this service
		List<Candidate> list=readCandidate();		
		return list;
	}	
	/**
	 * candidate_id is used to designate which candidate to update.
	 * 
	 * @param candidate_id takes the argument path parameter of candidate_id to designate which candidate to update.
	 * @return candidate instance object, determined via the candidate_id
	 * 
	 * 	AD - A candidate type object with the id value of 'candidate_id'
	 * 		is read from the database. Two parameters are required by they 
	 * 		find function. The class of 'entity' and an 'id.'
	 * 
	 * 		The first parameter (Candidate.class) instructs the table
	 * 		name where to search. 
	 */
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
	
	/* candidate_id is used to designate which candidate to delete.
	/**
	 * @param candidate_id takes the argument path parameter of candidate_id to designate which candidate to delete.
	 * @return candidate instance object, determined via the candidate_id
	 */
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
