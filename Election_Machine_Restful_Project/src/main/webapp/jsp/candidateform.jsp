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
    		caused by bootstrap, onto our code. -->
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
    
    	<!-- AD - This container contains a form (with table) to add 
    	candidates to the candidate table in the emachinedb database.-->
    <div class="containerUpdateCandidatesTable">                                                                                                
            <div class="table-responsive">            
	            <form action='../addcandidate' method='post'>                
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>
	                            <th>ADD</th>                           
	                            <th>CANDIDATE_ID</th>
	                            <th>FIRST NAME</th>
	                            <th>LAST NAME</th>
	                            <th>PARTY</th>
	                            <th>LOCATION</th>                            
	                            <th>AGE</th>
	                            <th>MISSION</th>
	                            <th>VISION</th>
	                            <th>PICTURE</th>
	                            <th>PROFESSION</th>
	                            <th>USERNAME</th>
	                            <th>PASSWORD</th>
	                        </tr>
	                    </thead>
	                    <tbody>                    
	                        <tr>                                                	                        	               
	                       		<td class = "tableAddBackground"><Button type='submit' name='ok' value=''><b class = "tableAdd">ADD</b></Button></td>
	                       		<td><input readonly class = "greyed-background" type='number' name='candidate_id' placeholder="Auto incremented." value=''></td> 
	                       	 	<td><input required type='text' name='first_name' placeholder="Cannot be blank." value=''></td>  
								<td><input required type='text' name='last_name' placeholder = "Cannot be blank." value=''></td>  
								<td><input required type='text' name='party' placeholder="Cannot be blank." value=''></td>  
								<td><input required type='text' name='location' placeholder="Cannot be blank." value=''></td>  		
								<td><input required type='number' name='age' placeholder="Number." value='' min="18" max="100"></td>  
								<td><input required type='text' name='mission' placeholder="Cannot be blank." value=''></td>  
								<td><input required type='text' name='vision' placeholder="Cannot be blank." value=''></td>  
						        <td><input readonly class = "greyed-background" type='text' name='pic' placeholder="Pic will go here." value=''></td>  
						        <td><input required type='text' name='profession' placeholder="Cannot be blank." value=''></td>   
								<td><input required type='text' name='username' placeholder="Cannot be blank." value=''></td>  
								<td><input required type='text' name='password' placeholder="Cannot be blank." value=''></td>                            
	                        </tr>                     
	                    </tbody>                   
	                </table>
                </form>
            </div>       
    </div>    

 <div class="containerUpdateCandidatesTable"> 
	 <ol>
		<c:forEach var="candidate" items="${requestScope.candidatelist }">
			<li>${candidate}</li>
 
 				<div class="table-responsive">                         
                	<table>                    
                    	<tbody>
                    		<tr>
                    			<br>
								<td>								 
									<form action='../deletecandidate?candidate_id=${candidate.candidate_id}' method='post'>
									<input type='submit' name='ok' value='DELETE' class = "tableCustom3" style="font-weight:bold;">	
									</form>									 									 
						        </td>						   
						        <td>						                   
									<form action='../readtoupdatecandidate?candidate_id=${candidate.candidate_id}' method='post'>
									<input type='submit' name='ok' value='UPDATE' class = "tableUpdate" style="font-weight:bold;">	
									</form>
								</td>														 
						 	</tr>						 						
						</tbody>
				    </table>
			   </div>			   
			   	<hr>
  		</c:forEach>
	</ol>
 </div>

<!-- AD Backup code of the original layout 

<c:forEach var="candidate" items="${requestScope.candidatelist }">
		<li>${candidate} <a href='../deletecandidate?candidate_id=${candidate.candidate_id}'>Delete</a> <a href='../readtoupdatecandidate?candidate_id=${candidate.candidate_id}'>Update</a>
</c:forEach>


 <div class="containerUpdateCandidatesTable"> 		
	<ol>
	<c:forEach var="candidate" items="${requestScope.candidatelist }">
		<li>${candidate}</li> 
		<a href='../deletecandidate?candidate_id=${candidate.candidate_id}'>Delete</a>
		<a href='../readtoupdatecandidate?candidate_id=${candidate.candidate_id}'>Update</a>
	</c:forEach>
	</ol>
</div>



<form action='../updatecandidate' method='post'>

<input type='submit' name='ok' value='UPDATE'>	

-->

 <!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %> 

</body>
</html>