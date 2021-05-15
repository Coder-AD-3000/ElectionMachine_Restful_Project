package data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * AD - For the candidate part of the restful web services,
 * 		this normal java class has been utilised, inside the 
 * 		'data' package.
 * @author ashley - specifies that the target is an entity
 */
@Entity
public class Candidate {
	
	/**
	 * AD - Id specifies the primary key of an entity
	 */
	/**
	 * candidate_id - int based value for the candidate_id column in the candidate table.
	 */ 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int candidate_id;
	/**
	 * first_name String based value for the first_name column in the candidate table.
	 */
	private String first_name;
	/**
	 * last_name - String based value for the last_name column in the candidate table.
	 */
	private String last_name;	 
	/**
	 * party - String based value for the party column in the candidate table.
	 */
	private String party;
	/**
	 * location - String based value for the location column in the candidate table.
	 */
	private String location;
	/**
	 * age - int based value for the age column in the candidate table.
	 */
	private int age;
	/**
	 * mission - String based value for the mission column in the candidate table.
	 */
	private String mission;
	/**
	 * vision - String based value for the vision column in the candidate table.
	 */
	private String vision;
	/**
	 * pic - String based value for the pic column in the candidate table.
	 */
	private String pic; 	
	/**
	 * profession - String based value for the profession column in the candidate table.
	 */
	private String profession; 
	/**
	 * username - String based value for the username column in the candidate table.
	 */
	private String username;
	/**
	 * password - String based value for the password column in the candidate table.
	 */
	private String password;
	/**
	 * role - String based value for the role column in the candidate table.
	 */
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
	
	/**
	 * Candidate non-parameterised constructor
	 */
	public Candidate() {
		
	}
	
	/**
	 * parameterised constructor (some ints, but mostly Strings) for the candidate class
	 * 
	 * @param candidate_id - int based argument taken for the parameterised constructor
	 * @param first_name - String based argument taken for the parameterised constructor
	 * @param last_name - String based argument taken for the parameterised constructor
	 * @param party - String based argument taken for the parameterised constructor
	 * @param location - String based argument taken for the parameterised constructor
	 * @param age - int based argument taken for the parameterised constructor
	 * @param mission - String based argument taken for the parameterised constructor
	 * @param vision - String based argument taken for the parameterised constructor
	 * @param pic - String based argument taken for the parameterised constructor
	 * @param profession - String based argument taken for the parameterised constructor
	 * @param username - String based argument taken for the parameterised constructor
	 * @param password - String based argument taken for the parameterised constructor
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
	 * parameterised constructor (String-based) for the candidate class
	 * 
	 * Used when we add a new candidate
	 * @param candidate_id - String based argument taken for the parameterised constructor
	 * @param first_name - String based argument taken for the parameterised constructor
	 * @param last_name - String based argument taken for the parameterised constructor
	 * @param party - String based argument taken for the parameterised constructor
	 * @param location - String based argument taken for the parameterised constructor
	 * @param age - String based argument taken for the parameterised constructor
	 * @param mission - String based argument taken for the parameterised constructor
	 * @param vision - String based argument taken for the parameterised constructor
	 * @param pic - String based argument taken for the parameterised constructor
	 * @param profession - String based argument taken for the parameterised constructor
	 * @param username - String based argument taken for the parameterised constructor
	 * @param password - String based argument taken for the parameterised constructor
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
	
	
	/**
	 * candidate_id getter method
	 * @return candidate_id (int value) from the candidate table.
	 */
	public int getCandidate_id() {
		return candidate_id;
	}
	/**
	 * candidate_id setter method
	 * @param candidate_id setter
	 */
	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}
	
	 
	/**
	 * candidate_id setter method (parses to String)
	 * @param candidate_id takes argument String candidate_id
	 */
	public void setCandidate_id(String candidate_id) {
		try {
			this.candidate_id = Integer.parseInt(candidate_id);
		}
		catch (NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
	}
	 
	
	/**
	 * first_name getter method
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * first_name setter method
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	
	/**
	 * last_name getter method
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * last_name setter method
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
	/**
	 * party getter method
	 * @return the party
	 */
	public String getParty() {
		return party;
	}
	/**
	 * party setter method
	 * @param party the party to set
	 */
	public void setParty(String party) {
		this.party = party;
	}
	
	/**
	 * location getter method
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * location setter method
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * age getter method
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * age setter method
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
 
	/**
	 * Setter method for age attribute (parses to String)
	 * @param age takes age String
	 */
	public void setAge(String age) {
		try {
			this.age = Integer.parseInt(age);
		}
		catch (NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
	}
	 
	
	/**
	 * mission getter method
	 * @return the mission
	 */
	public String getMission() {
		return mission;
	}
	/**
	 * mission setter method
	 * @param mission the mission to set
	 */
	public void setMission(String mission) {
		this.mission = mission;
	}
	
	
	/**
	 * vision getter method
	 * @return the vision
	 */
	public String getVision() {
		return vision;
	}
	/**
	 * vision setter method
	 * @param vision the vision to set
	 */
	public void setVision(String vision) {
		this.vision = vision;
	}
	
		
	/**
	 * pic getter method
	 * @return the pic
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * pic setter method
	 * @param pic the pic to set
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
	/**
	 * profession getter method
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}
	/**
	 * profession setter method
	 * @param profession the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	
	/**
	 * username getter method
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * username setter method
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	/**
	 * password getter method
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * password setter method
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * role getter method
	 * @return the user role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * role setter method
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * getter method for totalscore
	 * @return totalScore
	 */
	public int getTotalScore() {
		return totalScore;
	}

	/**
	 * setter method for totalscore
	 * @param totalScore is the score calculated while comparing answers with the voter
	 */
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	/**
	 * setter method for questionList
	 * @param questionList takes the list of quiz questions
	 */
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	/**
	 * getter method for questionList
	 * @return question list containing the quiz's questions
	 */
	public List<Question> getQuestionList() {
		return questionList;
	}
	
	/**
	 * setter method for answerList
	 * @param answerList takes a list of candidate answers
	 */
	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	/**
	 * getter method for answerList
	 * @return answer list containing the candidate's answers to the quiz questions
	 */
	public List<Answer> getAnswerList() {
		return answerList;
	}
	
	
	/**
	 * Returns a string representation of the object. 
	 * In general, the toString method returns a string that"textually represents" this object.
	 * So here, all of the candidate data is returned.
	 */
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
