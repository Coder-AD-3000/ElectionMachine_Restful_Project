<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>

<!-- AD - includes the meta component, into this page -->

    <%@ include file="../components/meta.jsp" %>
   
    
    <title>Candidate To Update Form</title>
    
    <!-- AD - includes the header component, into this page -->
    <%@ include file="../components/headerBootstrap.jsp" %>    
</head>
	<body>
	
	<!-- AD - A message in the top left to show an active session message -->
	<div class = "adminSession"><i>Admin Session Active ${requestScope.fromfilter }</i></div>
	 <!-- AD - includes the navbarBootstrap component, 
    		which is modified version of our regular navbar,
    		in order to offset some negative effects
    		caused by bootstrap, onto our code. -->
    <%@ include file="../components/navbarBootstrap.jsp" %> 
    
    <!-- AD - Beginning the central (yellow container)-->
    <div class="containerMainUpdateCandidates">
        <a href="../jsp/index.jsp"><i class="material-icons resize3">account_balance</i></a>
        
        <!-- AD - customises the 'ADMIN: Updates Candidates' message-->
        <div class="container6a"> 
        <h3 class = "adminTextCorrection1">ADMIN PORTAL: Candidate Data</h3>
        </div>
       
        <!-- AD - A small container to amend the admin note background section-->
        <div class="container4">             
            <!-- AD - Introductory statement about the ADMIN: Update Candidates page -->
            <h5 class = "adminTextCorrection2">ADMIN NOTE: Once logged in, this page allows for a 'Global Herald Newspaper' 
                IT Admin to add, edit and remove candidate information from our Election Machine database.
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
             <form action='../updatecandidate' method='post'>               
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                        	 
	                            <th>UPDATE</th>                                                      
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
	                            <td class="tableAddBackground">	                            
	                            <!-- AD this div is for the loading animation -->
					  			<div class="loaderUpdate"></div>					  			
	                            <input type='submit' name='ok' value='UPDATE' class = "tableUpdate" style="font-weight:bold;">
	                            </td> 
							    						    
							    <td><input readonly class = "greyed-background" type='text' name='candidate_id' value='${requestScope.candidate.candidate_id }'></td> 
								<td><input required type='text' name='first_name' value='${requestScope.candidate.first_name }'></td> 
								<td><input required type='text' name='last_name' value='${requestScope.candidate.last_name }'></td> 
								<td><input required type='text' name='party' value='${requestScope.candidate.party }'></td> 
								<td><input required type='text' name='location' value='${requestScope.candidate.location }'></td>		
								<td><input required type='number' name='age' value='${requestScope.candidate.age }' min="18" max="100"></td> 
								<td><input required type='text' name='mission' value='${requestScope.candidate.mission }'></td> 
								<td><input required type='text' name='vision' value='${requestScope.candidate.vision }'></td> 
						        <td><input readonly class = "greyed-background" type='text' name='pic' placeholder="Portrait pic will go here" value='${requestScope.candidate.pic }'></td>  
								<td><input required type='text' name='profession' value='${requestScope.candidate.profession }'></td> 
								<td><input required type='text' name='username' value='${requestScope.candidate.username }'></td> 
								<td><input required type='text' name='password' value='${requestScope.candidate.password }'></td>                                      
	                        </tr>	                     
	                    </tbody>                            
	                </table>
                </form>
            </div>
        </div>
    </div>        
    
	<div class="containerUpdateCandidatesTable">                                                                                          
        <div class="table-responsive">
                  		
		</div>			
	</div>
	
	<!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %> 
		
	</body>
</html>