<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>

	<!-- EK - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
 
    <title>New Question Form</title>
    
    <!-- EK - includes the header component, into this page -->
    <%@ include file="../components/headerBootstrap.jsp" %>    
    
</head>
<body>

	<!-- EK - A message in the top left to show an active session message -->
	<div class = "adminSession"><i>Admin Session Active ${requestScope.fromfilter }</i></div> 

    <!-- EK - includes the navbarBootstrap component, 
    		which is modified version of our regular navbar,
    		in order to offset some negative effects
    		caused by bootstrap, onto our code. -->
    <%@ include file="../components/navbarBootstrap.jsp" %>
    
    
    <!-- EK - Beginning the central (yellow container)-->
    <div class="containerMainUpdateCandidates">
        <a href="../index.jsp"><i class="material-icons resize3">account_balance</i></a>
        
        <!-- EK - customises the 'ADMIN: Updates Candidates' message-->
        <div class="container6a"> 
        <h3 class = "adminTextCorrection1">ADMIN PORTAL: Update Candidates</h3>
        </div>
       
        <!-- EK - A small container to amend the admin note background section-->
        <div class="container4">             
            <!-- EK - Introductory statement about the ADMIN: Update Candidates page -->
            <h5 class = "adminTextCorrection2">ADMIN NOTE: Once logged in, this page allows for a 'Global Herald Newspaper' 
                IT Admin to add, edit and remove candidate information.
                <br><br>
                Regular users and candidates do not have access to this page 
                (or its functionality).
            </h5>        
        </div>           
       							    

        <!-- EK - End of the central (yellow container)-->
    </div>  

	
		<!-- EK - This container contains a form (with table) to add 
    	newquestions to the newquestion table in the emachinedb database.-->
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
			
			
	<!-- EK - This container contains a form (with table) to add 
    	newquestions to the newquestion table in the emachinedb database.-->
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
        	
        		<div class="containerInnerCandidatesTable2">
					<li><b class="buttonColourMod2">New Question Number: </b>${newquestion}</li> 
				</div>
				<hr>
				 
			<div class="containerInnerCandidatesTable2 buttonMarginCorrection2">	 
				 
				 <div>
				 <a class = "button-main button1" 
				 href='../deletenewquestion?newquestion_id=${newquestion.newquestionId}'>				 
				 <b>DELETE</b></a> 
				 </div>
				 
				 
				 <div>
				 <a class = "buttonShowHide2 button1 buttonGreen" 
				 href='../readtoupdatenewquestion?newquestion_id=${newquestion.newquestionId}'>				 
				 <b class = "buttonColourMod1">UPDATE</b></a> 
				 </div>
				 		 
			</div>
				 			
			
			</div>
			
			</c:forEach>
		</ol>
		
		</div>
	
	 </div>
	</div>       	


	 <!-- EK - includes the footer component into this page 
	    (albeit not visible) -->
    
	<%@ include file="../components/footer.jsp" %> 

</body>
</html>