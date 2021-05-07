<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>

	<!-- LH - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
 
    <title>Employee Form</title>
    
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

		
		
		<!-- LH
		
			<form action='/addnewquestion' method='post'>
			
			<input type='text' name='new_question' value=''>
			<input type='submit' name='ok' value='OK'>
			
			</form>
			
			
			
			
			
			
	<ol>
		<c:forEach var="newquestion" items="${requestScope.newquestionlist }">
			<li>${newquestion} <a href='../deletenewquestion?newquestion_id=${newquestion.newquestionId}'>Delete</a> <a href='../readtoupdatenewquestion?newquestion_id=${newquestion.newquestionId}'>Update</a>
		</c:forEach>
	</ol>
		
		
		
		
		
		
		
		
		LH fields:
		
			<input type='text' name='new_question' value=''>
			<input type='submit' name='ok' value='OK'>
			
			
				("employee_id"), 
				request.getParameter("first_name"),
				request.getParameter("last_name"), 
				request.getParameter("username"),
				request.getParameter("password"));
			
		
			<input type='text' name='first_name' value=''>
			<input type='text' name='last_name' value='OK'>
			<input type='text' name='username' value=''>
			<input type='text' name='password' value='OK'>
		
		
		
		
		 -->

			



	
		<!-- LH - This container contains a form (with table) to add 
    	candidates to the candidate table in the emachinedb database.-->
    <div class="containerUpdateCandidatesTable">                                                                                                
       <div class="table-responsive"> 
	
			<form action='/addemployee' method='post'>
			
			
		 <div class="containerInnerCandidatesTable"> 	
			
				<table class="table">                    
	                <thead class = "tableCustom1">
	                    <tr>		
							<th>FIRST NAME:</th>
							<th>LAST NAME:</th>
							<th>USERNAME:</th>
							<th>PASSWORD:</th>
							<th>SUBMIT</th>							
					 	</tr>
	            </thead>		
				
	            <tbody>
	            	<tr>
	            		<td>  
	            		
	            		<!--          	
	            		<input type='text' style = "width:100%" name='new_question' value=''>				
	            		 --> 
	            		<input type='text' name='first_name' value=''>
						<input type='text' name='last_name' value=''>
						<input type='text' name='username' value=''>
						<input type='text' name='password' value=''>
	            		
	            		
	            		
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
			
			
	<!-- LH - This container contains a form (with table) to add 
    	candidates to the candidate table in the emachinedb database.-->
    <div class="containerUpdateCandidatesTable">                                                                                                
       <div class="table-responsive"> 		
		
		
		<div class="containerInnerCandidatesTable">
		
			
			
		<ol>
			<c:forEach var="newquestion" items="${requestScope.employeelist }">
			
			<table class="table">                    
	                <thead class = "tableCustom1">
	                    <tr>		
							<th>NEW EMPLOYEE DATABASE ENTRY</th>												
					 	</tr>
	            </thead>
	            
        	</table> 
        
        	<div class="containerInnerCandidatesTable1">
        	
        		<div class="containerInnerCandidatesTable2">
					<li><b class="buttonColourMod2">New Employee Number: </b>${employee}</li> 
				</div>
				<hr>
				 
			<div class="containerInnerCandidatesTable2 buttonMarginCorrection2">	 
				 
				 <div class = "button-main button1">
				 <a href='../deleteemployee?employee_id=${employee.employee_id}'>
				 <b>DELETE</b>
				 </a> 
				 </div>
				 
				 
				 <div class = "buttonShowHide2 button1">
				 <a href='../readtoupdateemployee?employee_id=${employee.employee_id}'>
				 <b class = "buttonColourMod1">UPDATE</b>
				 </a> 
				 </div>
				 
			 
			</div>
				 
			
				<!-- LH
				<a href='../deletenewquestion?newquestion_id=${newquestion.newquestionId}'>Delete</a> 
				<a href='../readtoupdatenewquestion?newquestion_id=${newquestion.newquestionId}'>Update</a>
				
				
				<li>${newquestion} <a href='../deletenewquestion?newquestion_id=${newquestion.newquestionId}'>Delete</a> 
				<a href='../readtoupdatenewquestion?newquestion_id=${newquestion.newquestionId}'>Update</a>
				
				<th style = "text-align: left;" class="tableCandidateDB">
				<button onclick="location.href='../readcandidate';" value=''>
                 <b class = "tableUpdate">SHOW DATABASE</b></Button></th>
				
				<input type='submit' name='ok' value='DELETE' 
				class = "tableCustom3 buttonMarginCorrection1" 
				style="font-weight:bold;">
				
				 -->
			
			</div>
			
			</c:forEach>
		</ol>
		
		</div>
	
	 </div>
	</div>       	


	 <!-- LH - includes the footer component into this page 
	    (albeit not visible) -->
    
	<%@ include file="../components/footer.jsp" %> 

</body>
</html>