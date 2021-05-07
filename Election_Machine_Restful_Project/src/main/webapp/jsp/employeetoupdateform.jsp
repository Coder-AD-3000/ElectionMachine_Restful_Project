<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>

	<!-- LH - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
 
    <title>New Employee To Update Form</title>
    
    <!-- LH - includes the header component, into this page -->
    <%@ include file="../components/headerBootstrap.jsp" %>    
    
</head>
<body>

	<!-- LH - A message in the top left to show an active session message -->
	<div class = "adminSession"><i>Admin Session Active ${requestScope.fromfilter }</i></div> 

    <!-- LH - includes the navbarBootstrap component, 
    		which is modified version of our regular navbar,
    		in order to offset some negative effects
    		caused by bootstrap, onto our code. -->
    <%@ include file="../components/navbarBootstrap.jsp" %>
    
    
    <!-- LH - Beginning the central (yellow container)-->
    <div class="containerMainUpdateCandidates">
        <a href="../index.jsp"><i class="material-icons resize3">account_balance</i></a>
        
        <!-- LH - customises the 'ADMIN: Updates Candidates' message-->
        <div class="container6a"> 
        <h3 class = "adminTextCorrection1">ADMIN PORTAL: Update Candidates</h3>
        </div>
       
        <!-- LH - A small container to amend the admin note background section-->
        <div class="container4">             
            <!-- LH - Introductory statement about the ADMIN: Update Candidates page -->
            <h5 class = "adminTextCorrection2">ADMIN NOTE: Once logged in, this page allows for a 'Global Herald Newspaper' 
                IT Admin to add, edit and remove candidate information.
                <br><br>
                Regular users and candidates do not have access to this page 
                (or its functionality).
            </h5>        
        </div>           
       							    

        <!-- LH - End of the central (yellow container)-->
    </div>  

	
		<!-- LH - This container contains a form (with table) to add 
    	candidates to the candidate table in the emachinedb database.-->
    <div class="containerUpdateCandidatesTable">                                                                                                
       <div class="table-responsive"> 


			<form action='../updateemployee' method='post'>
			
			<div class="containerInnerCandidatesTable"> 	
			
			<table class="table">                    
                <thead class = "tableCustom1">
                    <tr>
			
					<th style = "width:30%">NEW EMPLOYEE ID:</th>
					<th>FIRST NAME:</th>
					<th>LAST NAME:</th>
					<th>USERNAME:</th>
					<th>PASSWORD:</th>
					<th></th>
			
					</tr>
           		</thead>
           		
           		<tbody>
            		<tr>
            		
	            		<!-- 
	            		
	            		<td> 	
							<input style = "width:25%" type='text' name='newquestion_id' value='${requestScope.newquestion.newquestionId }'>
							</td>
							<td>
							<input style = "width:100%" type='text' name='new_question' value='${requestScope.newquestion.newquestion }'>
						</td>
	            		     		
	            		 -->
            		
            			<td> 	
						<input readonly class="greyed-background" style = "width:25%" type='text' name='employee_id' value='${requestScope.employee.employee_id }'>
						</td>
						<td>
						<input style = "width:100%" type='text' name='first_name' value='${requestScope.employee.first_name }'>
						</td>
						<td>
						<input style = "width:100%" type='text' name='last_name' value='${requestScope.employee.last_name }'>
						</td>
						<td>
						<input style = "width:100%" type='text' name='username' value='${requestScope.employee.username }'>
						</td>
						<td>
						<input style = "width:100%" type='text' name='password' value='${requestScope.employee.password }'>
						</td>
						
						 <td>
						 <input class = "buttonShowHide2 button1 buttonColourMod1 "type='submit' name='ok' value='UPDATE'>					 
						 </td>
						
						<!-- LH
						
						("employee_id"), 
						request.getParameter("first_name"),
						request.getParameter("last_name"), 
						request.getParameter("username"),
						request.getParameter("password"));
					
				
						<input type='text' name='first_name' value=''>
						<input type='text' name='last_name' value='OK'>
						<input type='text' name='username' value=''>
						<input type='text' name='password' value='OK'>
						
						
						
						
						
						
						
						
						 
						<td>
						<input type='submit' name='ok' value='OK'>
						</td>
						
						<div class = "buttonShowHide2 button1">
							-->
			
			
					</tr>
            	</tbody>
			</table>
			
			</div>
						
			</form>

 		</div>
	</div>      
	
	
	<!-- 
	
    <div class="containerUpdateCandidatesTable">                                                                                                
       <div class="table-responsive"> 
	
			<form action='/addnewquestion' method='post'>
			
			<table class="table">                    
                <thead class = "tableCustom1">
                    <tr>		
						<th>NEW QUESTION:</th>						
				 	</tr>
            </thead>		
			
            <tbody>
            	<tr>
            		<td>            	
            		<input type='text' name='new_question' value=''>				
            		</td>
            		<td>
            		<input type='submit' name='ok' value='OK'>
           			</td>
	           	</tr>
            </tbody>
			</table>
			
			</form>
			
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	 --> 	


	 <!-- LH - includes the footer component into this page 
	    (albeit not visible) -->
    
	<%@ include file="../components/footer.jsp" %> 

</body>
</html>