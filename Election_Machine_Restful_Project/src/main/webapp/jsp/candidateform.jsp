
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  


<!DOCTYPE html>
<html>
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
 
    <title>Candidate Form</title>
    
    <!-- AD - includes the header component, into this page -->
    <%@ include file="../components/headerBootstrap.jsp" %>    
    
</head>
<body>

    <!-- AD - includes the navbarBootstrap component, 
    		which is modified version of our regular navbar,
    		in order to offset some negative effects
    		caused by bootsrap, onto our code. -->
    <%@ include file="../components/navbarBootstrap.jsp" %>
    
    
    <!-- AD - Beginning the central (yellow container)-->
    <div class="containerMainUpdateCandidates">
        <i class="material-icons resize3">account_balance</i>
        
        <!-- AD - customises the 'ADMIN: Updates Candidates' message-->
        <div class="container6a"> 
        <h3 class = "adminTextCorrection1">ADMIN PORTAL: Update Candidates</h3>
        </div>
       
        <!-- AD - A small container to amend the admin note background section-->
        <div class="container4">             
            <!-- AD - Introductory statement about the ADMIN: Update Candidates page -->
            <h5 class = "adminTextCorrection2">ADMIN NOTE: Once logged in, this page allows for a 'Global Herald Newspaper' 
                IT Admin to add, edit and remove candidate information.
                <br><br>
                Regular users and candidates do not have access to this page 
                (or its functionality).
            </h5>        
        </div>        

        <!-- AD - End of the central (yellow container)-->
    </div>
    
    <!-- AD This is a container to contain the data from the Candidate Table.
    Created utilising bootstrap, this .table-responsive class creates a responsive table
    which will scroll horizontally on small devices (under 768px). 
    When viewing on anything larger than 768px wide, 
    there is no difference:-->
    <div class="containerUpdateCandidatesTable">   
        <div>                                                                                             
            <div class="table-responsive">
            <form action = "/AdminAddCandidate" method="POST" id="addCandidate">          
                <table class="table">                    
                    <thead class = "tableCustom1">
                        <tr>
                            <th>ADD</th>                           
                            <th>CANDIDATE_ID</th>
                            <th>SURNAME</th>
                            <th>FIRSTNAME</th>
                            <th>PARTY</th>
                            <th>LOCATION</th>
                            <th>AGE</th>
                            <th>REASON FOR RUNNING</th>
                            <th>AIMS AND GOALS</th>
                            <th>PROFESSION</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                        <tr>                   
                            <td class = "tableAddBackground"><Button type="submit"><b class = "tableAdd">ADD</b></Button></td>                           
                            <td><input disabled type="text" name="CANDIDATE_ID" placeholder="Auto incremented" ></td>
                            <td><input required type="text" name="SURNAME" placeholder="Cannot be blank." ></td>
                            <td><input required type="text" name="FIRSTNAME" placeholder="Cannot be blank." ></td>
                            <td><input required type="text" name="PARTY" placeholder="Cannot be blank." ></td>
                            <td><input required type="text" name="LOCATION" placeholder="Cannot be blank." ></td>
                            <td><input required type="number" name="AGE" placeholder="Cannot be blank." ></td>
                            <td><input required type="text" name="REASON_FOR_RUNNING" placeholder="Cannot be blank." ></td>
                            <td><input required type="text" name="AIMS_AND_GOALS" placeholder="Cannot be blank." ></td>
                            <td><input required type="text" name="PROFESSION" placeholder="Cannot be blank." ></td>             
                        </tr>
                     
                    </tbody>                        
                            
                </table>
                </form>
            </div>
        </div>
    </div>
    
    
    
    
    
    
     

		<div class="containerUpdateCandidatesTable">   
                                                                                           
           	<div class="table-responsive">
			<form action='../addcandidate' method='post'>
			First Name: <input required type='text' name='first_name' placeholder="Cannot be blank." value=''>
			Last Name: <input required type='text' name='last_name' placeholder = "Cannot be blank." value=''>
			Party: <input required type='text' name='party' placeholder="Cannot be blank." value=''>
			Location: <input required type='text' name='location' placeholder="Cannot be blank." value=''>		
			Age:<input required type='text' name='age' placeholder="Cannot be blank." value=''>
			Mission:<input required type='text' name='mission' placeholder="Cannot be blank." value=''>
			Vision:<input required type='text' name='vision' placeholder="Cannot be blank." value=''>
	        Picture:<input readonly class = "greyed-background" type='text' name='pic' placeholder="Pic will go here." value=''>
	        Profession:<input required type='text' name='profession' placeholder="Cannot be blank." value=''> 
			Username:<input required type='text' name='username' placeholder="Cannot be blank." value=''>
			Password:<input required type='text' name='password' placeholder="Cannot be blank." value=''>
			<input type='submit' name='ok' value='OK'>
			</form>
			
			</div>
		</div>
<ol>
<c:forEach var="candidate" items="${requestScope.candidatelist }">
	<li>${candidate} <a href='../deletecandidate?candidate_id=${candidate.candidate_id}'>Delete</a> <a href='../readtoupdatecandidate?candidate_id=${candidate.candidate_id}'>Update</a>
</c:forEach>
</ol>

 <!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %> 

</body>
</html>