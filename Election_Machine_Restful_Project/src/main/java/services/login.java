package services;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import data.Candidate;

public class login {
	


	@POST
	@Path("/candidatelogin/{user}/{pwd}")
	public String candLogin(@FormParam("user") String user, @FormParam("pwd") String pwd) {
	
//	ArrayList<Candidate> arrlist = ();//pack all usernames and passwords from table users to arrlist
	
	for (Candidate c: arrlist)
		if (c.username.equals(user) && c.password.equals(pwd)) {
			return c.getId(); //to string
			System.out.println("login match with userId: " + c.getId());
			//start session or add cookie
	  }
	}
	
	
	@POST
	@Path("/employeelogin/{user}/{pwd}")
	public String empLogin(@FormParam("user") String user, @FormParam("pwd") String pwd) {
	
//	ArrayList<Candidate> arrlist = ();//pack all usernames and passwords from table users to arrlist
	
	for (Candidate c: arrlist)
		if (c.username.equals(user) && c.password.equals(pwd)) {
			return c.getId(); //to string
			System.out.println("login match with userId: " + c.getId());
			//start session or add cookie
	  }
	}


}
