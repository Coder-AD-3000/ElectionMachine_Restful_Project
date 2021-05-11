package data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author ashley - specifies that the target is an entity
 * AD - For the candidate part of the restful web services,
 * 		this normal java class has been utilised, inside the 
 * 		'data' package.
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
	private String party;
	private String location;
	private int age;
	private String mission;
	private String vision;
	private String pic; /* AD - This variable type may later need to be changed, perhaps to @Lob private Byte[] image; */	
	private String profession; 
	private String username;
	private String password;
	private String role;
	
	/**
	 * Contains all the questions displayed in the questionnaire
	 */
	@Transient //Transient will prevent this attribute being persisted
	private List<Question> questionList;
	/**
	 * Contains all the answers provided by the candidate for the questionnaire
	 */
	@Transient
	private List<Answer> answerList;	
	/**
	 * TotalScore based on the voter-candidate comparison
	 */
	@Transient
	private int totalScore;
	
	public Candidate() {
		
	}
	
	/**
	 * @param candidate_id
	 * @param first_name
	 * @param last_name
	 * @param party
	 * @param location
	 * @param age
	 * @param mission
	 * @param vision
	 * @param pic
	 * @param profession
	 * @param username
	 * @param password
	 */
	public Candidate(int candidate_id, String first_name, 
					 String last_name, String party, String location, 
					 int age, String mission, String vision, String pic,
					 String profession, String username, String password) {	
		
		this.candidate_id=candidate_id;
		this.first_name=first_name;
		this.last_name=last_name;
		this.party=party;
		this.location=location;
		this.age=age;
		this.mission=mission;
		this.vision=vision;
		this.pic=pic;
		this.profession=profession;
		this.username=username;	
		this.password=password;
		this.role = "candidate";
	}
	
 
	/**
	 * Used when we add a new candidate
	 * @param candidate_id
	 * @param first_name
	 * @param last_name
	 * @param party
	 * @param location
	 * @param age
	 * @param mission
	 * @param vision
	 * @param pic
	 * @param profession
	 * @param username
	 * @param password
	 * @param role
	 */
	public Candidate(String candidate_id, String first_name, 
					 String last_name, String party, String location, 
					 String age, String mission, String vision, String pic,
					 String profession, String username, String password) {
		
		this.setCandidate_id(candidate_id);
		this.first_name=first_name;
		this.last_name=last_name;
		this.party=party;
		this.location=location;
		this.setAge(age);
		this.mission=mission;
		this.vision=vision;
		this.pic=pic;
		this.profession=profession;
		this.username=username;	
		this.password=password;
		this.role = "candidate"; // Will define user role for login system
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
	
	
	/**
	 * @return the party
	 */
	public String getParty() {
		return party;
	}
	/**
	 * @param party the party to set
	 */
	public void setParty(String party) {
		this.party = party;
	}
	
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
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
	 * @return the mission
	 */
	public String getMission() {
		return mission;
	}
	/**
	 * @param mission the mission to set
	 */
	public void setMission(String mission) {
		this.mission = mission;
	}
	
	
	/**
	 * @return the vision
	 */
	public String getVision() {
		return vision;
	}
	/**
	 * @param vision the vision to set
	 */
	public void setVision(String vision) {
		this.vision = vision;
	}
	
		
	/**
	 * @return the pic
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * @param pic the pic to set
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
	/**
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}
	/**
	 * @param profession the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the user role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * @return totalScore
	 */
	public int getTotalScore() {
		return totalScore;
	}

	/**
	 * @param totalScore is the score calculated while comparing answers with the voter
	 */
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	/**
	 * @param questionList takes the list of quiz questions
	 */
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	/**
	 * @return question list containing the quiz's questions
	 */
	public List<Question> getQuestionList() {
		return questionList;
	}
	
	/**
	 * @param answerList takes a list of candidate answers
	 */
	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	/**
	 * @return answer list containing the candidate's answers to the quiz questions
	 */
	public List<Answer> getAnswerList() {
		return answerList;
	}
	
	
	public String toString() {
		return this.candidate_id + ": "
		+ this.first_name + " / " 
		+ this.last_name + " / " 
		+ this.party + " / "
		+ this.location + " / "
		+ this.age + " / "
		+ this.mission + " / "
		+ this.vision + " / "
		+ this.pic + " / "
		+ this.profession + " / "
		+ this.username + " / "
		+ this.password;
	}



	
}
