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
	
	/**
	 * AD - At the beginning of this class here, the 'EntityManagerFactory' object 'emf'
	 * 		is created from the 'emachinedb' persistence unit.
	 * 
	 * 				
	 * 
	 */
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("emachinedb");
	@GET
	@Path("/readcandidate")
	@Produces(MediaType.APPLICATION_JSON) /* AD - returns a list of objects in JSON string format*/
	@Consumes(MediaType.APPLICATION_JSON) /* AD - This has no meaning here, as this method does not consume (get) any data*/
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
	 * @param candidate
	 * @return
	 *  AD - This method receives the values (e.g first_name, last_name, party etc 
	 *  from the html form (JSP in this case). The form sends a POST type request.
	 *  
	 *  Each method's name (signature) must differ from the other methods of the class.
	 *  
	 *  When the data is sent, the POST request is utilised, and so, no data is visible
	 *  in the browser's URL bar.
	 */	
	@POST
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
	 * @param candidate
	 * @return
	 * 
	 * AD - Updating happens via method merge. When updating (merging) an object,
	 * 		it is assumed that the database already contains a record with the same id as the 
	 * 		object to be updated. If there is no such existing id, the insertion will happen.
	 * 
	 * 		Before the merge takes place, there is a call of function 'find' to ensure that 
	 * 		in the databe is a record with the same id.
	 * 
	 * 		PUT is similar to POST, but it is designed for the purpose of updating something.
	 * 		The data sent is not seen in the browser bar.
	 */
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
		//This calls the method readCandidate() of this service
		List<Candidate> list=readCandidate();		
		return list;
	}	
	/**
	 * @param candidate_id
	 * @return
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
	 */
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
		//This calls the method readCandidate() of this service
		List<Candidate> list=readCandidate();		
		return list;
	}	
	/**
	 * @param candidate_id 
	 * @return
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
	
	/* AD - This method operates in a similar fashion to 'readtoupdatecandidate'*/
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
