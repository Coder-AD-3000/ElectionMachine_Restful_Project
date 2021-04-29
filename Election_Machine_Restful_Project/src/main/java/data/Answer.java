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
public class Answer {
	
	
	/**
	 * AD - Id specifies the primary key of an entity
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int question_id;
	private int candidate_id;
	private int answer;
	private String comment;	
	
	
	public Answer() {
		
	}
	public Answer(int candidate_id, int question_id, int answer, String comment) {
		this.candidate_id = candidate_id;
		this.question_id = question_id;
		this.answer = answer;
		this.comment = comment;
	}
	public Answer(String candidate_id, String question_id, String answer, String comment) {
		this.candidate_id = Integer.parseInt(candidate_id);
		this.question_id = Integer.parseInt(question_id);
		this.answer = Integer.parseInt(answer);
		this.comment = comment;
	}
	 
	public int getCandidateId() {
		return candidate_id;
	}
	public void setCandidateId(int candidate_id) {
		this.candidate_id = candidate_id;
	}
	
	public void setCandidateId(String candidate_id) {
		try {
			this.candidate_id = Integer.parseInt(candidate_id);
		}
		catch (NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
	}
	

	public int getAnswer() {
		return answer;
	}
	
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public void setAnswer(String answer) {
		try {
			this.answer = Integer.parseInt(answer);
		}
		catch (NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
	}
	
	public int getQuestionId() {
		return question_id;
	}
	public void setQuestionId(int question_id) {
		this.question_id = question_id;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
