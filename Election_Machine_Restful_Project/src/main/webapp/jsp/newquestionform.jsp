<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
 
    <title>New Question Form</title>
    
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
        <a href="../index.jsp"><i class="material-icons resize3">account_balance</i></a>
        
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
	
			<form action='/addnewquestion' method='post'>
			
			
		 <div class="containerInnerCandidatesTable"> 	
			
				<table class="table">                    
	                <thead class = "tableCustom1">
	                    <tr>		
							<th>NEW QUESTION:</th>
							<th>SUBMIT</th>							
					 	</tr>
	            </thead>		
				
	            <tbody>
	            	<tr>
	            		<td>            	
	            		<input type='text' style = "width:100%" name='new_question' value=''>				
	            		</td>
	            		<td>
	            		<input type='submit' name='ok' value='OK'>
	           			</td>
		           	</tr>
	            </tbody>
				</table>
			
		</div>	
			
			</form>
			
		</div>
	</div> 
			
			
	<!-- AD - This container contains a form (with table) to add 
    	candidates to the candidate table in the emachinedb database.-->
    <div class="containerUpdateCandidatesTable">                                                                                                
       <div class="table-responsive"> 		
		
		
		<div class="containerInnerCandidatesTable">
		
			
			
		<ol>
			<c:forEach var="newquestion" items="${requestScope.newquestionlist }">
			
			<table class="table">                    
	                <thead class = "tableCustom1">
	                    <tr>		
							<th>NEW QUESTION DATABASE ENTRY</th>												
					 	</tr>
	            </thead>
	            
        	</table> 
        
        	<div class="containerInnerCandidatesTable1">
        
				<li>${newquestion} <a href='../deletenewquestion?newquestion_id=${newquestion.newquestionId}'>Delete</a> <a href='../readtoupdatenewquestion?newquestion_id=${newquestion.newquestionId}'>Update</a>
			
			</div>
			
			</c:forEach>
		</ol>
		
		</div>
	
	 </div>
	</div>       	


	 <!-- AD - includes the footer component into this page 
	    (albeit not visible) -->
    
	<%@ include file="../components/footer.jsp" %> 

</body>
</html>