package data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * This is the model class for all the answrs collected from the questionnaire
 * @author Daniel
 *
 */
@Entity
public class Answer {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int answer_id;
	private int question_id;
	private int candidate_id;
	private int answer;
	private String comment;
	// Transient will prevent this attribute being persisted
	@Transient
	private List<Question> questionList;
	
	
	/**
	 * Empty constructor.
	 */
	public Answer() {
		
	}
	/**
	 * Constructor uses identical variable types for parameters as in the DB table.
	 * @param candidate_id identifies the candidate selected (if there is any)
	 * @param question_id identifies the question answerd
	 * @param answer is an int representing the answer value chosen from a scale
	 * @param comment is optional
	 */
	public Answer(int candidate_id, int question_id, int answer, String comment) {
		this.candidate_id = candidate_id;
		this.question_id = question_id;
		this.answer = answer;
		this.comment = comment;
	}
	/**
	 * Constructor uses only Strings as parameter
	 * @param candidate_id identifies the candidate selected (if there is any)
	 * @param question_id identifies the question answerd
	 * @param answer is an int representing the answer value chosen from a scale
	 * @param comment is optional
	 */
	public Answer(String candidate_id, String question_id, String answer, String comment) {
		this.candidate_id = Integer.parseInt(candidate_id);
		this.question_id = Integer.parseInt(question_id);
		this.answer = Integer.parseInt(answer);
		this.comment = comment;
	}
	/**
	 * Constructoruses mixed types as parameter
	 * @param candidate_id identifies the candidate selected (if there is any)
	 * @param question_id identifies the question answerd
	 * @param answer is an int representing the answer value chosen from a scale
	 * @param comment is optional
	 */
	public Answer(String candidate_id, int question_id, String answer, String comment) {
		this.candidate_id = Integer.parseInt(candidate_id);
		this.question_id = question_id;
		this.answer = Integer.parseInt(answer);
		this.comment = comment;
	}
	/**
	 * Constructor made for voter entries
	 * @param question_id identifies the question answerd
	 * @param answer is an int representing the answer value chosen from a scale
	 */
	public Answer(int question_id, String answer) {
		this.question_id = question_id;
		this.answer = Integer.parseInt(answer);
	}
	
	/**
	 * @return answer_id identifies the answer from DB table
	 */
	public int getAnswerId() {
		return answer_id;
	}
	/**
	 * @param answer_id identifies the answer from DB table
	 */
	public void setAnswerId(int answer_id) {
		this.answer_id = answer_id;
	}
	
	/**
	 * @return candidate_id: a number representing candidate
	 */
	public int getCandidateId() {
		return candidate_id;
	}
	/**
	 * @param candidate_id: a number representing candidate
	 */
	public void setCandidateId(int candidate_id) {
		this.candidate_id = candidate_id;
	}
	
	/**
	 * Attribute is taken as String
	 * @param candidate_id: a number representing candidate
	 */
	public void setCandidateId(String candidate_id) {
		try {
			this.candidate_id = Integer.parseInt(candidate_id);
		}
		catch (NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
	}
	

	/**
	 * @return answer: a number representing user answer
	 */
	public int getAnswer() {
		return answer;
	}
	
	/**
	 * @param answer: a number representing user answer
	 */
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	/**
	 * Uses String as param.
	 * @param answer: a number representing user answer
	 */
	public void setAnswer(String answer) {
		try {
			this.answer = Integer.parseInt(answer);
		}
		catch (NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
	}
	
	/**
	 * @return question_id representing the current question
	 */
	public int getQuestionId() {
		return question_id;
	}
	
	/**
	 * @param question_id representing the current question
	 */
	public void setQuestionId(int question_id) {
		this.question_id = question_id;
	}
	
	/**
	 * @return comment is text conatining additional info associated with answer
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment is text conatining additional info associated with answer
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
}
