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
                    
                    <!-- AD this is the original nice styling
                    
                    <td class="tableAddBackground">
                    <Button type='submit' name='ok' value=''>
                    <b class = "tableAdd">ADD</b></Button></td>
                    
                    And this is the new, not so nice:
                    
                     <td class="tableAddBackground">	  								
						<input class = "tableAdd" id = "btnAddEntry" 
                 				value="ADD" onclick="ShowHideToggle1(this)" 
                 				style="font-weight:bold;"> 
                 				
                 				
                 	And this is the nice delete button:
                 	
                 	<form action='../deletecandidate?candidate_id=${candidate.candidate_id}' method='post'>
					<input type='submit' name='ok' value='DELETE' class = "tableCustom3" style="font-weight:bold;">
					</form>	
                    
                    
                    Turn it into this:
                    <Button value='' onClick="window.location = '../jsp/candidateform.jsp';">
										   <b class = "tableCustom3">CANCEL</b></Button>
                    
                     -->                                       	
                     <td class="tableAddBackground">					 
					 
						<Button id = "btnAddEntry" value='ADD' onClick="ShowHideToggle1(this)">
						<b class = "tableAdd">ADD</b></Button>
						
						<div id ="dvAddEntry" style="display: none">					 
					  		<p style = "width:125px"><b style = "color: rgba(255, 255, 255, 0.555)">Confirm Addition?</b></p>	
					  		
					  			
					  		<!-- AD this div is for the loading animation -->
					  		 <div class="loader"></div> 
					  							  								  
							  <table class="table-responsive">
								  <tbody>
									  <tr>
										 <td class="tableAddBackground">									 	
										 						
								 	  		<input type='submit' name='ok' value='ADD ENTRY' class = "tableAdd" 
								 	  		style="font-weight:bold;">
								 	  	 </td> 							  
									  	 <td>
										   <Button value='' onClick="window.location = '../jsp/candidateform.jsp';">
										   <b>CANCEL</b></Button>
									  	</td>
									  </tr>								  
								  </tbody>						  
							   </table>
						</div>								 
	                 			 
						<td><input readonly class="greyed-background" type='number' name='candidate_id' placeholder="Auto Incremented" value=''></td> 
	                  	<td><input required type='text' name='first_name' placeholder="Cannot be blank" value=''></td>  
						<td><input required type='text' name='last_name' placeholder = "Cannot be blank" value=''></td>  
						<td><input required type='text' name='party' placeholder="Cannot be blank" value=''></td>  
						<td><input required type='text' name='location' placeholder="Cannot be blank" value=''></td>  		
						<td><input required type='number' name='age' placeholder="Number" value='' min="18" max="100"></td>  
						<td><input required type='text' name='mission' placeholder="Cannot be blank" value=''></td>  
						<td><input required type='text' name='vision' placeholder="Cannot be blank" value=''></td>  
				        <td><input readonly class="greyed-background" type='text' name='pic' placeholder="Portrait pic will go here" value=''></td>  
				        <td><input required type='text' name='profession' placeholder="Cannot be blank" value=''></td>   
						<td><input required type='text' name='username' placeholder="Cannot be blank" value=''></td>  
						<td><input required type='text' name='password' placeholder="Cannot be blank" value=''></td>	                        
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
                   			<th style = "text-align: left;" class="tableCandidateDB"><button onclick="location.href='../readcandidate';" value=''>
                   			<b class = "tableUpdate">SHOW DATABASE</b></Button></th>                  		
                  			</tr>
                     </thead>                        
                </table>                 
                            			
                <c:forEach var="candidate" items="${requestScope.candidatelist}">           
                    
                   <div class="showDatabaseContainer"> 
                  
                      <div class="table-responsive">                  
           			    <table class="table">                        
                        
	                        <thead class = "tableCustom1">
	                          <tr>
		                        <th>DELETE</th>  
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
								
									<!-- AD The original elite working code
									
									<form action='../deletecandidate?candidate_id=${candidate.candidate_id}' method='post'>
									<input type='submit' name='ok' value='DELETE' class = "tableCustom3" style="font-weight:bold;">
									</form>
									
									-->
													
									
									<!-- AD the original modal example code
									
									Trigger/Open The Modal
									<button id="myBtn">Open Modal</button>
									
									The Modal
									<div id="myModal" class="modal">
									
									  Modal content
									  <div class="modal-content">
									    <span class="close">&times;</span>
									    <p>Some text in the Modal..</p>
									  </div>
									
									</div>									
									
									 -->
									 
									<!-- AD This is the original workgin code with the modal number 
									<button id="myBtn">Open Modal</button>									
									<div id="myModal" class="modal">									  
									  <div class="modal-content">${candidate.candidate_id }									  	
									    <span class="close">&times;</span>
									    <p>Are you sure you want to delete?</p>
									  </div>									
									</div>								
																
									-->
									
									
									
									
								
									
									<form action='../readtodeletecandidate?candidate_id=${candidate.candidate_id}' method='post'>
									<input type='submit' name='ok' value='DELETE' class = "tableCustom3 buttonMarginCorrection1" style="font-weight:bold;">
									</form>
																								
									</td>
									<td class="tableAddBackground">
									<form action='../readtoupdatecandidate?candidate_id=${candidate.candidate_id}' method='post'>
									<input type='submit' name='ok' value='UPDATE' class = "tableUpdate buttonMarginCorrection2" style="font-weight:bold;">
									</form>
									</td>
								    <td id = "candidate number"><textarea disabled class = "greyed-background" name='candidate_id' >${candidate.candidate_id }</textarea></td> 
								    <td><textarea disabled name='first_name'>${candidate.first_name }</textarea></td> 
									<td><textarea disabled name='last_name' >${candidate.last_name }</textarea></td> 
									<td><textarea disabled name='party' >${candidate.party }</textarea></td> 
									<td><textarea disabled name='location'>${candidate.location }</textarea></td>		
									<td><textarea disabled name='age' >${candidate.age }</textarea></td> 
									<td><textarea disabled name='mission' >${candidate.mission }</textarea></td> 
									<td><textarea disabled name='vision' >${candidate.vision }</textarea></td> 
							        <td><textarea disabled class ="greyed-background" name='pic' placeholder="Portrait pic will go here">${candidate.pic }</textarea></td>  
									<td><textarea disabled name='profession' >${candidate.profession }</textarea></td> 
									<td><textarea disabled name='username' >${candidate.username }</textarea></td> 
									<td><textarea disabled name='password' >${candidate.password }</textarea></td> 
								   </tr>	                        
			                     </tbody>		                     
	                    	</table>      
						  </div>
						</div>  		                        
		             </c:forEach>            
	         </div>      
	    </div>         
                    
    			<!-- 			
    			
    			AD - This HTML markup contains a DIV, which contains inside of it
                another div element, which possesses show / hide functionality.
                The button has been assigned a JavaScript Onclick event handler.
                When clicked, the function is executed. Furthermore, 
                based on the value of the button, the HTML div toggle 
                functionality will be executed. AKA the div will be shown, 
                and the button text and colour changed. -->    
                <script type="text/javascript">
                
                    function ShowHideToggle1(btnAddEntry) {
                        var dvAddEntry = document.getElementById("dvAddEntry");
                                                
                        if (btnAddEntry.value == "ADD") {
                            dvAddEntry.style.display = "block";                            
                           
                            btnAddEntry.style.display = "none";                            
                            
                        } else {
                            dvAddEntry.style.display = "none";
                            btnAddEntry.value = "ADD";
                            btnAddEntry.style.backgroundColor = "#2A9D8F";                           
                        }
                    } 
                       
                    
                    /* AD - This script is to create a 'modal' pop up */
                  
	                 // Get the modal
	                 var modal = document.getElementById("myModal");
	
	                 // Get the button that opens the modal
	                 var btn = document.getElementById("myBtn");
	
	                 // Get the <span> element that closes the modal
	                 var span = document.getElementsByClassName("close")[0];
	
	                 // When the user clicks the button, open the modal 
	                 btn.onclick = function() {
	                   modal.style.display = "block";
	                 }
	
	                 // When the user clicks on <span> (x), close the modal
	                 span.onclick = function() {
	                   modal.style.display = "none";
	                 }
	
	                 // When the user clicks anywhere outside of the modal, close it
	                 window.onclick = function(event) {
	                   if (event.target == modal) {
	                     modal.style.display = "none";
	                   }
	                 }
                  
	              
	                 
	                 
                 	</script> 
                 	
                 	
                 	              	
                 	<!-- AD
                 	
                 	<button type="button" class="collapsible">Open Collapsible</button>
						<div class="content">
						
						  <p> AD - Collapsible box</p>
						</div>
                 	
                 	 -->  
                 	 
                 	 
                 	 <!-- AD 	
                 	 				
						<input class = "buttonShowHide button1" id = "btnAddEntry" 
               			type="button" value="1st Place" onclick="ShowHideToggle1(this)" > 
		
              			<div id="dvAddEntry" style="display: none"> 
              			
              			This works:
              			<input class = "buttonShowHide" id = "btnAddEntry" 
              			type="button" value="1st Place" onclick="ShowHideToggle1(this)" > 
              			
              			                   
                	-->	         
                	
                	
                	


	 <!-- AD - includes the footer component into this page 
	    (albeit not visible) -->
    
	<%@ include file="../components/footer.jsp" %> 

</body>
</html>