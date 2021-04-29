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
	private String surname;
	private String firstname;	
	private int age;
	
	public Candidate() {
		
	}
	public Candidate(String surname, String firstname, int age) {
		this.surname=surname;
		this.firstname=firstname;
		this.age=age;
	}
	public Candidate(int candidate_id, String surname, String firstname, int age) {		
		this.candidate_id=candidate_id;
		this.surname=surname;
		this.firstname=firstname;
		this.age=age;
	}
	public Candidate(String surname, String firstname, String age) {
		this.surname=surname;
		this.firstname=firstname;
		this.setAge(age);
	}
	public Candidate(String candidate_id, String surname, String firstname, String age) {
		this.setCandidate_id(candidate_id);
		this.surname=surname;
		this.firstname=firstname;
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
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String toString() {
		return this.candidate_id+": "+this.surname+" / "+this.firstname+" / "+this.age;
	}
}
