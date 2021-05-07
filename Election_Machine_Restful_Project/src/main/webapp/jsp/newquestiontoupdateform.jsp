<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
 
    <title>New Question To Update Form</title>
    
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


			<form action='../updatenewquestion' method='post'>
			
			<div class="containerInnerCandidatesTable"> 	
			
			<table class="table">                    
                <thead class = "tableCustom1">
                    <tr>
			
					<th style = "width:30%">NEW QUESTION ID:</th>
					<th>NEW QUESTION:</th>
					<th></th>
			
					</tr>
           		</thead>
           		
           		<tbody>
            		<tr>
            			<td> 	
						<input readonly class = "greyed-background" style = "width:25%" type='text' name='newquestion_id' value='${requestScope.newquestion.newquestionId }'>
						</td>
						<td>
						<input style = "width:100%" type='text' name='new_question' value='${requestScope.newquestion.newquestion }'>
						</td>
						
											
						<td class="tableAddBackground">			
						
						<!-- EK - This button activates two separate functions. 
							      One function reveals the hidden div, 
							      and the other loads the loading bar animation. -->					 
						<Button type = "button" id = "btnAddEntry" value='ADD' onClick="ShowHideToggle1(this); move();">
						<b class = "tableAdd">ADD</b></Button>
						
						<div id ="dvAddEntry" style="display: none">					 
					  		<p style = "width:125px"><b style = "color: rgba(255, 255, 255, 0.555)">Confirm Amendment?</b></p>	
					  						  		 
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
						
						
						
						
						
						
						
						
						
						
						<!--  
						 <td>
						 <input class = "buttonShowHide2 button1 buttonColourMod1 "type='submit' name='ok' value='UPDATE'>					 
						 </td>
						-->
						
						
						
						
						<!-- 
						
						<td class="tableAddBackground">					 
					 
						<Button id = "btnAddEntry" value='ADD' onClick="ShowHideToggle1(this)">
						<b class = "tableAdd">ADD</b></Button>
						
						<div id ="dvAddEntry" style="display: none">					 
					  		<p style = "width:125px"><b style = "color: rgba(255, 255, 255, 0.555)">Confirm Addition?</b></p>	
					  		
					  			
					  		 AD this div is for the loading animation 
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
												
						 -->
						
					</tr>
            	</tbody>
			</table>
			
			</div>
						
			</form>

 		</div>
	</div>
	
	
							<!-- EK - Loading animation bar -->
							<div id="myProgress">
						  		<div id="myBar">10%</div>
							</div>
						
							<br>
							
							<!-- EK 
							<button onclick="move()">Click Me
							</button> 
							-->
	
	
	
			<!-- EK - animation JavaScript script -->
			<script>			
			var i = 0;
			function move() {
			  if (i == 0) {
			    i = 1;
			    var elem = document.getElementById("myBar");
			    var width = 10;
			    var id = setInterval(frame, 10);
			    function frame() {
			      if (width >= 100) {
			        clearInterval(id);
			        i = 0;
			      } else {
			        width++;
			        elem.style.width = width + "%";
			        elem.innerHTML = width  + "%";
			      }
			    }
			  }
			}
						
			
			/* EK - Toggle button to reveal the update button */			
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
			
			</script>      
		
	
 <!-- AD - includes the footer component into this page 
	    (albeit not visible) -->
    
	<%@ include file="../components/footer.jsp" %> 

</body>
</html>