<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
 
    <title>New Questions Form</title>
    
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
        <h3 class = "adminTextCorrection1">ADMIN PORTAL: Update New Questions</h3>
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
                
            <table class="table">                    
                <thead class = "tableCustom1">
                    <tr>
                        <th>ADD</th>
                        
                        <!-- EK 
                        <th>NEW QUESTION ID</th>                         
                        -->
                        <th>NEW QUESTION</th>                
                    </tr>
                </thead>
                <tbody>                    
                    <tr>                     
                                                          	
                     <td class="tableAddBackground">					 
					 
						<Button id = "addButton" value='ADD' onClick="toggleB(this)">
						<b class = "tableAdd">ADD</b></Button>
						
						<div id ="newEntryDiv" style="display: none">					 
					  		<p style = "width:125px"><b style = "color: rgba(255, 255, 255, 0.555)">Confirm Addition?</b></p>	
					  		
					  			
					  		<!-- EK - animation container -->
					  		 <div class="loader"></div> 
					  							  								  
							  <table class="table-responsive">
								  <tbody>
									  <tr>
										 <td class="tableAddBackground">									 	
										 						
								 	  		<input type='submit' name='ok' value='ADD ENTRY' class = "tableAdd" 
								 	  		style="font-weight:bold;">
								 	  	 </td> 							  
									  	 <td>
										   <Button value='' onClick="window.location = '../jsp/newquestionform.jsp';">
										   <b>CANCEL</b></Button>
									  	</td>
									  </tr>								  
								  </tbody>						  
							   </table>
						</div>								 
	                 	
	                 	<!-- EK
						<td><input readonly class="greyed-background" type='number' name='newquestion_id' placeholder="Auto Incremented" value=''></td> 
	                  	 -->	 
	                  	<td><input required type='text' name='new_question' placeholder="Cannot be blank" value=''></td>  
										                        
                    </tr>                     
                </tbody>                   
            </table>            
          </form>
       </div>       
    </div>                   
           
    <!-- AD - Beginning the central (yellow container)-->
    <div class="containerUpdateCandidatesTable">
        <a href="../index.jsp"><i class="material-icons resize3">account_balance</i></a>
                                                                                                 
           <div class="table-responsive">                  
               <table class="table">                
				<thead class = "tableCustom1"> 						
						<tr>                   			
                   			<th style = "text-align: left;" class="tableCandidateDB"><button onclick="location.href='../readnewquestion';" value=''>
                   			<b class = "tableUpdate">SHOW DATABASE</b></Button></th>                  		
                  			</tr>
                     </thead>                        
                </table>                 
                            			
                <c:forEach var="newquestion" items="${requestScope.newquestionlist }">           
                    
                   <div class="showDatabaseContainer"> 
                  
                      <div class="table-responsive">                  
           			    <table class="table">                        
                        
	                        <thead class = "tableCustom1">
	                          <tr>
		                        <th>DELETE</th>  
		                        <th>UPDATE</th>                          
		                        <th>NEW QUESTION ID</th>                         
                        		<th>NEW QUESTION</th> 
	                          </tr>
	                        </thead> 
	                        
	                        <tbody>	                        
		                      <tr> 
		                        <td class="tableAddBackground">	                        							
									
									<form action='../deletenewquestion?newquestion_id=${newquestion.newquestionId}' method='post'>
									<input type='submit' name='ok' value='DELETE' class = "tableCustom3 buttonMarginCorrection1" style="font-weight:bold;">
									</form>
																								
									</td>
									<td class="tableAddBackground">
									<form action='../readtoupdatenewquestion?newquestion_id=${newquestion.newquestionId}' method='post'>
									<input type='submit' name='ok' value='UPDATE' class = "tableUpdate buttonMarginCorrection2" style="font-weight:bold;">
									</form>
									</td>
								    
								    <!--  
								    <td id = "candidate number"><textarea disabled class = "greyed-background" name='newquestion_id' >${newquestion.newquestionId }</textarea></td> 
								    -->
								    
								    <td><textarea disabled name='new_question'>${newquestion.new_question }</textarea></td> 						
									
									<!-- 
									<c:forEach var="newquestion" items="${requestScope.newquestionlist }">
										<li>${newquestion} <a href='../deletenewquestion?newquestion_id=${newquestion.newquestionId}'>Delete</a> <a href='../readtoupdatenewquestion?newquestion_id=${newquestion.newquestionId}'>Update</a>
									</c:forEach>
									
									
									 -->
									
																	
								   </tr>	                        
			                     </tbody>		                     
	                    	</table>      
						  </div>
						</div>  		                        
		             </c:forEach>            
	         </div>      
	    </div>         
                    
    			<!-- 			
    			
    			EK - Hide toggle button -->    
                <script type="text/javascript">
                
                    function toggleB(addButton) {
                        var newEntryDiv = document.getElementById("newEntryDiv");
                                                
                        if (addButton.value == "ADD") {
                            newEntryDiv.style.display = "block";                            
                           
                            addButton.style.display = "none";                            
                            
                        } else {
                            newEntryDiv.style.display = "none";
                            addButton.value = "ADD";
                            addButton.style.backgroundColor = "#2A9D8F";                           
                        }
                    } 
                              
	                               
                 	</script>     
                	
                	

	 <!-- EK - includes the footer component into this page 
	    (albeit not visible) -->
    
	<%@ include file="../components/footer.jsp" %> 

</body>
</html>