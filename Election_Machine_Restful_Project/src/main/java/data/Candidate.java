package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ashley - specifies that the target is an entity
 *
 */
@Entity
public class Candidate {
	
	
	/**
	 * AD - Id specifies the primary key of an entity
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int candidate_id;
	private String first_name;
	private String last_name;
	 
	private String surname;		
	private int age;
	
	public Candidate() {
		
	}
	public Candidate(String first_name, String last_name, int age) {
		this.first_name=first_name;
		this.last_name=last_name;		
		this.age=age;
	}
	public Candidate(int candidate_id, String first_name, String last_name, int age) {		
		this.candidate_id=candidate_id;
		this.first_name=first_name;
		this.last_name=last_name;		
		this.age=age;
	}
	public Candidate(String first_name, String last_name, String age) {
		this.first_name=first_name;
		this.last_name=last_name;		
		this.setAge(age);
	}
	public Candidate(String candidate_id, String first_name, String last_name, String age) {
		this.setCandidate_id(candidate_id);
		this.first_name=first_name;
		this.last_name=last_name;		
		this.setAge(age);
	}
	 
	public int getCandidate_id() {
		return candidate_id;
	}
	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}
	
	public void setCandidate_id(String candidate_id) {
		try {
			this.candidate_id = Integer.parseInt(candidate_id);
		}
		catch (NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
	}
	
	
	
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	 
	
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public void setAge(String age) {
		try {
			this.age = Integer.parseInt(age);
		}
		catch (NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
	}
	
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String toString() {
		return this.candidate_id+": "+this.first_name+" / "+this.last_name+" / "+this.age;
	}
	
	
}
