package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Newquestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int newquestion_id;
	private String new_question;
	
	public Newquestion() {
		
	}
	public Newquestion(String new_question) {
		this.new_question=new_question;
	}
	public Newquestion(int newquestion_id, String new_question) {
		this.newquestion_id=newquestion_id;
		this.new_question=new_question;
	}
	
	public Newquestion(String newquestion_id, String new_question) {
		this.setNewquestionId(newquestion_id);
		this.new_question=new_question;
	}
	public int getNewquestionId() {
		return newquestion_id;
	}
	public void setNewquestionId(int newquestion_id) {
		this.newquestion_id = newquestion_id;
	}
	public void setNewquestionId(String newquestion_id) {
		try {
			this.newquestion_id = Integer.parseInt(newquestion_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
	}
	public String getNewquestion() {
		return new_question;
	}
	public void setNewquestion(String new_question) {
		this.new_question = new_question;
	}

	public String toString() {
		return this.newquestion_id+": "+this.new_question+" / ";
	}
}

