package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * This class represents the database table newquestion where the new entries are saved.
 * @author EK
 * @version 1.0
 * Date: May 4, 2021
 */
@Entity
public class Newquestion {
	/**
	 * Id annotation specifies the primary key of an entity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	/**
	 * integer based value representing the newquestion_id column in newquestion table of the batabase.
	 */
	private int newquestion_id;
	/**
	 * String based value representing the new_question column in newquestion table of the batabase.
	 */
	private String new_question;
	
	/**
	 * Empty constructor.
	 */
	public Newquestion() {
		
	}
	
	/**
	 * Constructor uses identical variable types for parameters as in the DB table
	 * @param new_question
	 */
	public Newquestion(String new_question) {
		this.new_question=new_question;
	}
	/**
	 * This constructs a New question with a specified newquestion_id and newquestion.
	 * Constructor uses mixed types as parameter.
	 * @param newquestion_id represents the id of the new question.
	 * @param new_question represents the new question entered by the admin.
	 */
	public Newquestion(int newquestion_id, String new_question) {
		this.newquestion_id=newquestion_id;
		this.new_question=new_question;
	}
	
	/**
	 * Constructor uses only Strings as parameter
	 * @param newquestion_id represents the id of the new question.
	 * @param new_question represents the new question entered by the admin.
	 */
	public Newquestion(String newquestion_id, String new_question) {
		this.setNewquestionId(newquestion_id);
		this.new_question=new_question;
	}
	/**
	 * This method returns the id of the new question from the new newquestion entries.
	 * @return
	 */
	public int getNewquestionId() {
		return newquestion_id;
	}
	/**
	 * @param newquestion_id identifies the id of the new question entry from DB table.
	 */
	public void setNewquestionId(int newquestion_id) {
		this.newquestion_id = newquestion_id;
	}
	/**
	 * Attribute is taken as String
	 * @param newquestion_id: a number representing the new question.
	 */
	public void setNewquestionId(String newquestion_id) {
		try {
			this.newquestion_id = Integer.parseInt(newquestion_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
	}
	/**
	 * @return new_question: representing the new question entered.
	 */
	public String getNewquestion() {
		return new_question;
	}
	/**
	 * Uses String as parameter.
	 * @param new_question: representing the new question entered.
	 */
	public void setNewquestion(String new_question) {
		this.new_question = new_question;
	}
	/**
	 * The toString method returns String of the attributes from the new question table.
	 */
	public String toString() {
		return this.newquestion_id+": "+this.new_question+" / ";
	}
}

