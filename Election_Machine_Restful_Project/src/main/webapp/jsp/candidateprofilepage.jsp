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
	<div class = "candidateSession"><i>Candidate Session Active ${requestScope.fromfilter }</i></div>

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
        <h3 class = "adminTextCorrection1">CANDIDATE PORTAL: Profile Page</h3>
        </div>
       
        <!-- AD - A small container to amend the admin note background section-->
        <div class="container4">             
            <!-- AD - Introductory statement about the ADMIN: Update Candidates page -->
            <h5 class = "adminTextCorrection2">CANDIDATE NOTE: Greetings candidate! 
            This profile page allows you to update your profile data which is stored in our
            database.
                <br><br>
                Only Global Herald IT Admins and yourself have access to your confidential
                profile data.
            </h5>        
        </div>           
       							    

        <!-- AD - End of the central (yellow container)-->
    </div>  

    <!-- AD This is a container to contain the data from the Candidate Table.
    Created utilising bootstrap, this .table-responsive class creates a responsive table
    which will scroll horizontally on small devices (under 768px). 
    When viewing on anything larger than 768px wide, 
    there is no difference:-->
    <div class="containerCandidateProfile">
    
      <form action='../updatecandidate' method='post'>                                                                                         
        <!-- AD - Responsive columns 
        
        <div class="row">
		  <div class="col-sm-4">.col-sm-4</div>
		  <div class="col-sm-4">.col-sm-4</div>
		  <div class="col-sm-4">.col-sm-4</div>
		</div> 
        
        
        -->
         <div class="row"> 
         
         	<div class="col-md-1">
         	</div> 
         	 
            	<div class="col-md-7">
            
             	<a href="../index.jsp"><i class="material-icons resize3">account_balance</i></a>  
            
            <div class="table-responsive">            
                         
	                
	                
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                            <th>PROFILE PAGE</th>
	                            <th>YOUR DETAILS</th>                    
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                        <!-- AD - candidate number field -->
	                         <td class="tableAddBackground ">                
	                            <input readonly type='text' class = "colourAmendment"
	                            name='candidate_id' 
	                            placeholder="Candidate Number"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input readonly class = "greyed-background" 
	                            type='text' name='candidate_id' 
	                            placeholder="1019">
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                 <!-- AD - first name field -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text' name='first_name' 
	                            placeholder="First Name"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input readonly 
	                            type='text' name='first_name' 
	                            placeholder="Mikko">
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                <!-- AD - last name field -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text' name='last_name' 
	                            placeholder="Last Name"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input readonly
	                            type='text' name='last_name' 
	                            placeholder="Koskenranta">
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                <!-- AD - party field -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text' name='party' 
	                            placeholder="Political Party"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input readonly 
	                            type='text' name='party' 
	                            placeholder="The Green Party">
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                <!-- AD - Location field -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text' name='location' 
	                            placeholder="Location"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input readonly 
	                            type='text' name='location' 
	                            placeholder="Helsinki">
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                <!-- AD - Age field -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text' name='age' 
	                            placeholder="Age"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input readonly 
	                            type='text' name='age' 
	                            placeholder="52">
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                <!-- AD - Mission field -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text' name='mission' 
	                            placeholder="Mission"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input readonly 
	                            type='text' name='mission' 
	                            placeholder="Better Social Welfare">
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                <!-- AD - Vision field -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr>	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text' name='vision' 
	                            placeholder="Vision"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input readonly 
	                            type='text' name='vision' 
	                            placeholder="A poverty-free country">
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>       
	                
	                <!-- AD - profession field -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text' name='profession' 
	                            placeholder="Profession"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input readonly 
	                            type='text' name='profession' 
	                            placeholder="Engineer">
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                <!-- AD - Username field -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text' name='username' 
	                            placeholder="Username"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input readonly
	                            type='text' name='username' 
	                            placeholder="GreenMikko21">
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                
	                <!-- AD - Password field -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text' name='password' 
	                            placeholder="Password"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input readonly
	                            type='text' name='password' 
	                            placeholder="Green33214a">
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>             
	                
              
            </div>        
    
    </div> <!-- AD - End of md-7 -->
  
  	<div class="col-md-3">
   		
		<table class="table marginAmendment">                    
            <thead class = "tableCustom1">
                <tr>                                                                      
                    <th>CANDIDATE PORTRAIT</th>                                      
                </tr>
            </thead>            
            <tbody>                    
                <tr> 
                
                <!-- AD - Portrait Display Area -->
                 <td class="tableAddBackground ">                
                    <textarea disabled rows="8" cols="28" name='pic' 
                    placeholder="Portrait Picture"
                    style="font-weight:bold;"></textarea>
                 </td>                                     
	                                        	                                        
                </tr>	                     
            </tbody>                            
        </table>
        
        <!-- AD - Portrait Upload field -->
        <table class="table">                    
                        
            <tbody>                    
                <tr>               
                <!-- AD - Portrait Display Area -->
                 <td class="tableAddBackground">                
                    <input readonly type='text' name='pic' 
                    placeholder="Portrait Picture"
                    class = "colourAmendment"
                    style="font-weight:bold;">
                 </td>                                	                                        
                </tr>	                     
            </tbody>                            
        </table>
        
         <table class="table">                    
            <thead class = "tableCustom1">
                <tr>                                                                      
                    <th>GUIDANCE: Click UPDATE to update your profile
                    and DELETE to delete your profile completely. Please
                    be warned once your profile has been deleted, it 
                    cannot be recovered.</th>                                      
                </tr>
            </thead>            
            <tbody>                    
                <tr> 
                
                <!-- AD - Portrait Display Area -->
                 <td class="tableAddBackground ">                
                    <textarea disabled rows="2" cols="28" name='pic' 
                    placeholder="Extra Guidance"
                    style="font-weight:bold;"></textarea>
                 </td>                                     
	                                        	                                        
                </tr>	                     
            </tbody>                            
        </table>
        
        <!-- AD - Portrait Upload field -->
        <table class="table">                    
                        
            <tbody>                    
                <tr>               
                <!-- AD - Portrait Display Area -->
                 <td class="tableAddBackground">                
                    <input readonly type='text' name='pic' 
                    placeholder="UPLOAD"
                    class = "colourAmendment"
                    style="font-weight:bold;">
                 </td>                                	                                        
                </tr>	                     
            </tbody> 
            
            <tbody>                    
                <tr>               
                <!-- AD - Portrait Display Area -->
                 <td class="tableAddBackground">                
                    <input readonly type='text' name='pic' 
                    placeholder="DELETE"
                    class = "colourAmendment"
                    style="font-weight:bold;">
                 </td>                                	                                        
                </tr>	                     
            </tbody> 
            
            
            <tbody>                    
                <tr>               
                <!-- AD - Portrait Display Area -->
                 <td class="tableAddBackground">                
                    <input readonly type='text' name='pic' 
                    placeholder="BACK"
                    class = "colourAmendment"
                    style="font-weight:bold;">
                 </td>                                	                                        
                </tr>	                     
            </tbody> 
            
            <tbody>                    
                <tr>               
                <!-- AD - Portrait Display Area -->
                 <td class="tableAddBackground">                
                    <input readonly type='text' name='pic' 
                    placeholder="HOME"
                    class = "colourAmendment"
                    style="font-weight:bold;">
                 </td>                                	                                        
                </tr>	                     
            </tbody>
            
                                       
        </table>
        
        
        
        
        
        
        
        
        
        
        
        
        
    </div>
    
    
   
        
    </div>  
    
    
    
    
      
    
    <div class="col-md-1">
    </div> 
         	
         	    
  
  </div> <!-- AD - End of row -->
  
    </form>   
  	    
 </div> <!-- AD - End of containerCandidateProfile -->      
   
         						<!-- AD this div is for the loading animation 
					  			<div class="loaderUpdate"></div>
					  			-->	
        
        						<!--
	                            <th>CANDIDATE_ID</th>
	                            <th>FIRST NAME</th>
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
	                            -->
	                            
	                            
	                              <!--
							    <input readonly class = "greyed-background" type='text' name='candidate_id' value='${requestScope.candidate.candidate_id }'>
	                            
							     
							    <td><input required type='text' name='first_name' value='${requestScope.candidate.first_name }'></td> 						    
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
	                       		
	                       		<td class="tableAddBackground">                  
	                            <input type='submit' name='ok' value='UPDATE' class = "tableUpdate" style="font-weight:bold;">
	                            </td> 
	                       		
	                       		-->
        
        
        
        
    
	<div class="containerCandidateProfile">                                                                                          
        <div class="table-responsive">
                  		
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
                 	
                 	                 	
                 	              	
                 	<!-- AD - This script is for the AJAX -->
                 	<script>
					function sendData(){
						//Create a new Javascript object
						var prey=new Object();
						prey.breed=document.getElementById("breed").value;
						prey.weight=document.getElementById("weight").value;
						
						var jsonPrey=JSON.stringify(prey);
						var xhttp = new XMLHttpRequest();
						
						xhttp.onreadystatechange = function() {
						  if (this.readyState == 4 && this.status == 200) {
						   document.getElementById("responseView").innerHTML = this.responseText;
						   var returned=JSON.parse(this.responseText);
						   document.getElementById("inparts").innerHTML="ID="+returned.id+" Breed="+returned.breed+" Weight="+returned.weight;
						  }
						};
						
						xhttp.open("POST","./rest/hunterservice2/addprey",true);
						xhttp.setRequestHeader("Content-type","application/json");
						xhttp.send(jsonPrey);					
					}
					
					
					</script>     
                	
                	
                	


	 <!-- AD - includes the footer component into this page 
	    (albeit not visible) -->
    
	<%@ include file="../components/footer.jsp" %> 

</body>
</html>