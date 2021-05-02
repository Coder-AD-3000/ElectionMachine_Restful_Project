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
                   		<td class="tableAddBackground"><Button type='submit' name='ok' value=''><b class = "tableAdd">ADD</b></Button></td>
                   		<td><input readonly class="greyed-background" type='number' name='candidate_id' placeholder="Auto incremented." value=''></td> 
                   	 	<td><input required type='text' name='first_name' placeholder="Cannot be blank." value=''></td>  
						<td><input required type='text' name='last_name' placeholder = "Cannot be blank." value=''></td>  
						<td><input required type='text' name='party' placeholder="Cannot be blank." value=''></td>  
						<td><input required type='text' name='location' placeholder="Cannot be blank." value=''></td>  		
						<td><input required type='number' name='age' placeholder="Number." value='' min="18" max="100"></td>  
						<td><input required type='text' name='mission' placeholder="Cannot be blank." value=''></td>  
						<td><input required type='text' name='vision' placeholder="Cannot be blank." value=''></td>  
				        <td><input readonly class="greyed-background" type='text' name='pic' placeholder="Pic will go here." value=''></td>  
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
        <div>                                                                                             
            <div class="table-responsive">   
                   
                <table class="table">                    
                    <thead class = "tableCustom1">
                        <tr>
                            <th>CANDIDATE DATABASE</th>                                                       
                        </tr>
                    </thead>         
                                   
                    <tbody class = "tableCustom1" >
                   		<tr>              				
                   			<td style = "text-align: left;" class="tableAddBackground"><button onclick="location.href='../readcandidate';" value=''/>
                   			<b class = "tableUpdate">SHOW DATABASE</b></Button></td>
                   		</tr>						 						
					</tbody>
				</table> 
				
					<!-- AD Work in progress 
				  	<div class="container3">
                    <input class = "buttonShowHide button1" id = "btnCandResults1" 
                    type="button" value="1st Place" onclick="ShowHideToggle1(this)" > 
                    </div>  
				
					<div id="dvCandResults1" style="display: none">               
                    <div class="container6">
                    		Candidate Database: 
                    	</div>
                    </div>
                    
                    -->
				
					<!-- AD - (Work in Progress) button container, containing the UserResults          
		            
		            <div class="container3">
                    <input class = "buttonShowHide button1" id = "btnCandResults1" 
                    type="button" value="1st Place" onclick="ShowHideToggle1(this)" > 
                    </div> 
                    
                    
                    AD - This HTML markup contains a DIV, which contains inside of it
	                another div element, which possesses show / hide functionality.
	                The button has been assigned a JavaScript Onclick event handler.
	                When clicked, the function is executed. Furthermore, 
	                based on the value of the button, the HTML div toggle 
	                functionality will be executed. AKA the div will be shown, 
	                and the button text and colour changed.      
	                <script type="text/javascript">
                    function ShowHideToggle1(btnCandResults1) {
                        var dvCandResults1 = document.getElementById("dvCandResults1");
                        if (btnCandResults1.value == "1st Place") {
                            dvCandResults1.style.display = "block";
                            btnCandResults1.value = "HIDE";
                            btnCandResults1.style.backgroundColor = "#E76F51";
                            
                        } else {
                            dvCandResults1.style.display = "none";
                            btnCandResults1.value = "1st Place";
                            btnCandResults1.style.backgroundColor = "#2A9D8F";                           
                        }
                    }  
		             
		             
		             This 'hidden div' shows the 1st place suitable candidate.
                        The div becomes visible once the '1st Place Candidate'
                        button is pressed. Conversely, the div disappears once the
                        button is pressed again (toggle button). 
                <div id="dvCandResults1" style="display: none">               
                    <div class="container6">
                    		Candidate Database: 
                    	</div>
                    </div>
                    
		            -->                              
               
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
        </div>
    </div>
                    
                    
    			<!--  AD - This HTML markup contains a DIV, which contains inside of it
                another div element, which possesses show / hide functionality.
                The button has been assigned a JavaScript Onclick event handler.
                When clicked, the function is executed. Furthermore, 
                based on the value of the button, the HTML div toggle 
                functionality will be executed. AKA the div will be shown, 
                and the button text and colour changed. -->    
                <script type="text/javascript">
                    function ShowHideToggle1(btnCandResults1) {
                        var dvCandResults1 = document.getElementById("dvCandResults1");
                        if (btnCandResults1.value == "1st Place") {
                            dvCandResults1.style.display = "block";
                            btnCandResults1.value = "HIDE";
                            btnCandResults1.style.backgroundColor = "#E76F51";
                            
                        } else {
                            dvCandResults1.style.display = "none";
                            btnCandResults1.value = "1st Place";
                            btnCandResults1.style.backgroundColor = "#2A9D8F";                           
                        }
                    } 
                    
                 </script>            


 <!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %> 

</body>
</html>