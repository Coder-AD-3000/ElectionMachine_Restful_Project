package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Question object instances to carry columns from question table utilizing JPA.
 * 
 * @author Les
 * @version 1.0
 * Date: April 30, 2021
 */
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * Integer value representing question_id column from question table.
	 */
	private int question_id;
	/**
	 * String value representing question column from question table.
	 */
	private String question;
	
	
	/**
	 * Parameterized String based constructor for Question class.
	 * 
	 * @param id takes String arg for question_id from question table.
	 * @param question takes String arg for question from question table
	 */
	public Question(String id, String question) {
		setId(id);
		this.question=question;
	}
	
	/**
	 * Parameterized int and String based constructor for Question class.
	 * 
	 * @param id takes int arg for question_id from question table.
	 * @param question takes String arg for question from question table
	 */
	public Question(int id, String question) {
		this.question_id = id;
		this.question = question;
	}
	
	/**
	 * Default constructor for Question class.
	 */
	public Question() {
		// Empty object
	}
	
	
	/**
	 * question_id getter method.
	 * 
	 * @return question_id int for question_id in question table
	 */
	public int getId() {
		//System.out.println("getId()");
		return question_id;
	}
	
	/**
	 * question_id setter method.
	 * 
	 * @param id takes arg id as int for question_id from question table.
	 */
	public void setId(int id) {
		//System.out.println("setId(int id)");
		this.question_id = id;
	}
	
	/**
	 * guestion_id setter method.
	 * 
	 * @param id takes arg id as String for question_id form question table.
	 */
	public void setId(String id) {
		//System.out.println("setId(String id)");
		try {
			this.question_id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
		}
	}
	
	/**
	 * question getter method for question from question table.
	 * 
	 * @return String question for question from question table.
	 */
	public String getQuestion() {
		//System.out.println("getQuestion()");
		return question;
	}
	
	/**
	 * question setter method for question from question table.
	 * 
	 * @param question takes arg question as String for question from question table.
	 */
	public void setQuestion(String question) {
		//System.out.println("setQuestion(String question)");
		this.question = question;
	}

	/**
	 * toString method generates String of attributes.
	 */
	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", question=" + question + "]";
	}
	
}
