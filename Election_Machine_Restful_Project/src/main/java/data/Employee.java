package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Employee object instances to carry columns from employee table utilizing JPA.
 * 
 * @author Les
 * @version 1.0
 * Date: May 3, 2021
 */
@Entity
public class Employee {	
	/**
	 * Primary key employee_id is an integer based value from employee table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int employee_id;
	/**
	 * String based value for first_name column in employee table
	 */
	private String first_name;
	/**
	 * String based value for last_name column in employee table
	 */
	private String last_name;
	/**
	 * String based value for username column in employee table
	 */
	private String username;
	/**
	 * String based value for password column in employee table
	 */
	private String password;
	/**
	 * String based value for role column in employee table
	 */
	private String role;
	
	
	/***************************************************************************
	 ************************   CONSTRUCTORS   ********************************* 
	 ***************************************************************************/
	/**
	 * Default constructor for Employee class
	 */
	public Employee() {
		
	}
	
	/**
	 * String based parameterized constructor for Employee class
	 * 
	 * @param employee_id takes arg String of employee_id for employee table.
	 * @param first_name takes arg String of first_name for employee table.
	 * @param last_name takes arg String of last_name for employee table.
	 * @param username takes arg String of username for employee table.
	 * @param password takes arg String of password for employee table.
	 */
	public Employee(String employee_id, String first_name, String last_name, String username, String password) {
		setEmployee_id(employee_id);
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * String based parameterized constructor for Employee class
	 * 
	 * @param employee_id takes arg int of employee_id for employee table.
	 * @param first_name takes arg String of first_name for employee table.
	 * @param last_name takes arg String of last_name for employee table.
	 * @param username takes arg String of username for employee table.
	 * @param password takes arg String of password for employee table.
	 */
	public Employee(int employee_id, String first_name, String last_name, String username, String password) {
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
	}
	
	 
	/***************************************************************************
	 ***********************   SETTERS/GETTERS   ******************************* 
	 ***************************************************************************/
	/**
	 * employee_id getter method
	 * 
	 * @return int value of employee_id from employees table
	 */
	public int getEmployee_id() {
		return employee_id;
	}

	/**
	 * employee_id setter method
	 * 
	 * @param employee_id takes arg int of employee_id
	 */
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	
	/**
	 * employee_id setter method
	 * 
	 * @param employee_id takes arg String of employee_id
	 */
	public void setEmployee_id(String employee_id) {
		try {
			this.employee_id = Integer.parseInt(employee_id);
		} catch (NumberFormatException | NullPointerException e) {
		}
	}

	/**
	 * first_name getter method
	 * 
	 * @return String value of first_name from employee table
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * first_name setter method
	 * 
	 * @param first_name takes String based value of first_name
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * last_name getter method
	 * 
	 * @return String based value of last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * last_name setter method
	 * 
	 * @param last_name takes String based arg of last_name
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * username getter method
	 * 
	 * @return String based value of username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * username setter method
	 * 
	 * @param username takes String based arg of username 
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * password getter method
	 * 
	 * @return String based value of password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * password setter method
	 * 
	 * @param password takes String based arg of password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return String based value of role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role takes String based arg of role
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/***************************************************************************
	 ***************************   METHODS   *********************************** 
	 ***************************************************************************/
	/**
	 * toString method returns String of all attributes from employee table
	 */
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", username=" + username + ", password=" + password + "]";
	}


	
}
