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
        <a href="../jsp/index.jsp"><i class="material-icons resize3">account_balance</i></a>
        
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
    
     
    	<!-- AD - This will need fixing 
      <form action='../updatecandidate' method='post'> 
      -->
      <form action='/updatemyprofile' method='post'> 
                                                                                              
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
            
             	<a href="../jsp/index.jsp"><i class="material-icons resize3">account_balance</i></a>  
            
            <div class="table-responsive">
            
            
            <!-- 
            
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
            
            
            
            
             -->            
                    <input readonly class = "greyed-background" type='hidden' name='pic' placeholder="Portrait pic will go here" value='${requestScope.candidate.pic }'>    
	                
	                
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                            <th>PROFILE PAGE</th>
	                            <th>YOUR DETAILS</th>                    
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                        <!-- AD - candidate number field 
	                        
	                        <td><input readonly class = "greyed-background" 
	                        type='text' name='candidate_id' 
	                        value='${requestScope.candidate.candidate_id }'></td>
	                        
	                        -->
	                         <td class="tableAddBackground ">                
	                            <input readonly type='text' class = "greyed-background"
	                            placeholder="Candidate Number"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input readonly class = "greyed-background" 
	                            type='text' name='candidate_id' 
	                            value='${requestScope.candidate.candidate_id }'>
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                 <!-- AD - first name field 
	                 
	                 <td><input required type='text' 
	                 name='first_name' 
	                 value='${requestScope.candidate.first_name }'></td> 
	                 
	                 -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text' 
	                            placeholder="First Name"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input class="switch" disabled="disabled" required 
	                            type='text' name='first_name' 
	                            value='${requestScope.candidate.first_name }'>
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                <!-- AD - last name field 
	                
	                <td><input required type='text' 
	                name='last_name' 
	                value='${requestScope.candidate.last_name }'></td>
	                
	                -->
	                
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text'
	                            placeholder="Last Name"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input class="switch" disabled="disabled" required
	                            type='text' name='last_name' 
	                            value='${requestScope.candidate.last_name }'>
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                <!-- AD - party field 
	                
	                <td><input required type='text' 
	                name='party' value='${requestScope.candidate.party }'></td>
	                
	                -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text'
	                            placeholder="Political Party"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input class="switch" disabled="disabled" required 
	                            type='text' name='party' 
	                            value='${requestScope.candidate.party }'>
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                <!-- AD - Location field 
	                
	                <td><input required type='text' 
	                name='location' value='${requestScope.candidate.location }'></td>
	                
	                -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text'
	                            placeholder="Location"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input class="switch" disabled="disabled" required 
	                            type='text' name='location' 
	                            value='${requestScope.candidate.location }'>
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                <!-- AD - Age field 
	                
	                <td><input required type='number' 
	                name='age' value='${requestScope.candidate.age }' 
	                min="18" max="100"></td>
	                
	                -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='number'
	                            placeholder="Age"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input class="switch" disabled="disabled" required type='number' 
	                            name='age' value='${requestScope.candidate.age }' 
	                            min="18" max="100"
	                            style="width:182.4px;"
	                            >
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                <!-- AD - Mission field 
	                
	                <td><input required type='text' 
	                name='mission' value='${requestScope.candidate.mission }'>
	                </td> 
	                
	                -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text'
	                            placeholder="Mission"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input class="switch" disabled="disabled" required 
	                            type='text' name='mission' 
	                            value='${requestScope.candidate.mission }'>
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                <!-- AD - Vision field 
	                
	                <td><input required type='text' 
	                name='vision' value='${requestScope.candidate.vision }'></td>
	                
	                -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr>	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text'
	                            placeholder="Vision"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input class="switch" disabled="disabled" required 
	                            type='text' name='vision' 
	                            value='${requestScope.candidate.vision }'>
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>       
	                
	                <!-- AD - profession field 
	                
	                <td><input required type='text' 
	                name='profession' 
	                value='${requestScope.candidate.profession }'></td>
	                
	                -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text'
	                            placeholder="Profession"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input class="switch" disabled="disabled" required 
	                            type='text' name='profession' 
	                            value='${requestScope.candidate.profession }'>
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                <!-- AD - Username field 
	                
	                <td><input required type='text' 
	                name='username' value='${requestScope.candidate.username }'></td> 
	                
	                -->
	                
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text'
	                            placeholder="Username"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input readonly class="greyed-background" required
	                            type='text' name='username' 
	                            value='${requestScope.candidate.username }'>
	                         </td>	                                        
	                        </tr>	                     
	                    </tbody>                            
	                </table>
	                
	                
	                <!-- AD - Password field 
	                
	                <td><input required type='text' 
	                name='password' 
	                value='${requestScope.candidate.password }'></td>
	                
	                -->
	                <table class="table">                    
	                    <thead class = "tableCustom1">
	                        <tr>                                                                      
	                                          
	                        </tr>
	                    </thead>            
	                    <tbody>                    
	                        <tr> 
	                        
	                         <td class="tableAddBackground">                
	                            <input readonly type='text' 
	                            placeholder="Password"
	                            class = "colourAmendment"
	                            style="font-weight:bold;">
	                         </td> 
	                         
	                         <td>
	                            <input class="switch" disabled="disabled" required
	                            type='password' name='password'
	                            value='${requestScope.candidate.password }'>
	                            <!-- AD - This will need to be linked later -->	                            
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
                 	<img src="img/${candidate.pic}" style="max-width: 150px;"> 
                 	<!--                        
                    <textarea disabled rows="8" cols="20" name='pic' 
                    placeholder="Portrait Picture"
                    style="font-weight:bold; background-color:#87CEFA;">                    
                    </textarea>
                    -->
                 </td>                                                               	                                        
                </tr>	                     
            </tbody>                            
        </table>
        
        <!-- AD - Portrait Upload field -->
        <table class="table marginAmendment2">                    
                        
            <tbody>                    
                <tr>               
                <!-- AD - Portrait Display Area 
                
                <td><input readonly class = "greyed-background" 
                type='text' name='pic' 
                placeholder="Portrait pic will go here" 
                value='${requestScope.candidate.pic }'></td>
                
                -->
                
                 <td class="tableAddBackground">                
                    <input onClick="" readonly type='text' name='pic' 
                    placeholder="Upload Portrait Picture"
                    onmouseover="this.style.cursor='pointer';"
                    class = "colourAmendment myBtn-class" id="popup"
                    style="font-weight:bold; text-align: center;">
                 </td>                                	                                        
                </tr>	                     
            </tbody>                            
        </table>
        
         <table class="table marginAmendment2">                    
            <thead class = "tableCustom1">
                <tr>                                                                      
                    <th>GUIDANCE: Click UPDATE to update your profile
                    and DELETE to delete your profile completely. Please
                    be warned once your profile has been deleted, it 
                    cannot be recovered.</th>                                      
                </tr>
            </thead>            
            <tbody class = "tableCustom1">                    
                <tr> 
                
                <!-- AD - Displays Current time and date
                		 via the utilisation of a JS script -->
                 <td class="tableAddBackground">
                 	Time and date (Europe / Helsinki):                
                    <textarea id="displayTimeAndDate"                    
                    disabled rows="1" cols="18" name='pic'                    
                    style="font-weight:bold; color:#B22222; text-align: center;">                  
                    </textarea>
                 </td>                                     
	                                        	                                        
                </tr>	                     
            </tbody>                            
        </table>
        
        <!--  
        <p id="displayTimeAndDate"></p>
        -->
        
        <!-- AD - Portrait Upload field -->
        <table class="table marginAmendment2">                    
                        
            <tbody>                    
                <tr> 
                
                <!-- AD Button code -->
                
                <td class="tableAddBackground">					 
					 
						<Button type = "button" id = "btnUpdateProfile" value='UPDATEvisible' onClick="toggleProfileUpdate(this); enableAll();">
						<b class = "tableUpdate">EDIT PROFILE</b></Button>
						
						<div id ="dvUpdateProfile" style="display: none">
							
							<!--  					 
					  		<p style = "width:125px"><b style = "color: rgba(255, 255, 255, 0.555)">Confirm Profile Changes?</b></p>	
					  		-->
					  		
					  		<table style = "width:215px" class="table">                    
				            <thead class = "tableCustom1">
				                <tr>                                                                      
				                    <th><i style = "color:#cfdefe">NOTICE!</i> - You are about to update your profile.
				                    If you click cancel, all changes will be lost.
				                    Confirm profile Changes?</th>                                      
				                </tr>
				            </thead>
				            </table>
					  			
					  		<!-- AD this div is for the loading animation -->
					  		 <div class="loaderUpdate"></div> 
					  							  								  
							  <table class="table-responsive">
								  <tbody>
									  <tr>
										 <td class="tableAddBackground">									 	
										 						
								 	  		<input type='submit' name='ok' value='UPDATE' class = "tableUpdate" 
								 	  		style="font-weight:bold;">
								 	  	 </td> 							  
									  	 <td>
										   <Button type = "button" value='' onClick="window.location.reload();">
										   <b>CANCEL</b></Button>
										   <!-- AD 
										   Add prevent default										   
										    -->
									  	</td>
									  </tr>								  
								  </tbody>						  
							   </table>
						</div>                      	                                        
                </tr>	                     
            </tbody> 
            
            <tbody>                    
                <tr> 
                
                <!-- AD Button code -->
                
                <td class="tableAddBackground">					 
					 
						<Button type = "button" id = "btnDeleteProfile" value='ADD' onClick="toggleProfileDelete(this)">
						<b class = "tableCustom3">DELETE</b></Button>
						
						<div id ="dvDeleteProfile" style="display: none">							
											  		 
						  	<table style = "width:215px" class="table">                    
				            <thead class = "tableCustom1">
				                <tr>                                                                      
				                    <th style = "color:#FFE4E1"><i style = "color:#ff4444">WARNING!</i> 
				                    - You are about to delete your entire profile!
				                    Once Deleted your profile cannot be recovered.
				                    Confirm Profile Deletion?</th>                                      
				                </tr>
				            </thead>
				            </table>
					  		
					  		<!-- AD this div is for the loading animation -->
					  		 <div class="loaderDelete">
					  		 </div> 
					  							  								  
							  <table class="table-responsive">
								  <tbody>
									  <tr>
										 <td class="tableAddBackground">									 	
										 						
								 	  		<input type='submit' name='ok' value='DELETE' class = "tableCustom3" 
								 	  		style="font-weight:bold;">
								 	  	 </td> 							  
									  	 <td>
										   <Button type = "button" value='' onClick="window.location.reload();">
										   <b>CANCEL</b></Button>
										   <!-- AD 
										   Add prevent default										   
										    -->
									  	</td>
									  </tr>								  
								  </tbody>						  
							   </table>
						</div>                      	                                        
                </tr>	                     
            </tbody> 
            
            
            <tbody>                    
                <tr>               
                <!-- AD - Portrait Display Area -->
                 <td class="tableAddBackground">
                 	<a href="../jsp/index.jsp">                
                    <input readonly type='text' name='pic' 
                    placeholder="BACK" onmouseover="this.style.cursor='pointer';"
                    class = "colourAmendment profilePageButtonMod1"
                    style="font-weight:bold; text-align: center;">
                    </a>
                 </td>                                	                                        
                </tr>	                     
            </tbody> 
            
            <tbody>                    
                <tr>               
                <!-- AD - Portrait Display Area -->
                 <td class="tableAddBackground">                
                    <a href="../jsp/index.jsp"><input readonly type='text' name='pic' 
                    placeholder="HOME" onmouseover="this.style.cursor='pointer';"
                    class = "colourAmendment profilePageButtonMod1"
                    style="font-weight:bold; text-align: center;">
                    </a>
                 </td>                                	                                        
                </tr>	                     
            </tbody>
            
            <!-- 
            <div>
				 <a class = "button-main button1" 
				 href='../deletenewquestion?newquestion_id=${newquestion.newquestionId}'>				 
				 <b>DELETE</b></a> 
			</div>
             -->
                                       
        </table>
        
    </div>
             
    </div>  <!-- AD - End of row -->
      
    
    <div class="col-md-1">
    </div> 
         	
    </form>   
  	    
 </div> <!-- AD - End of containerCandidateProfile -->      
   
         
     <!-- AD - The footer container note -->
    <div class="containerProfileFooter">      
        <!-- AD - A small container to amend the admin note background section-->
        <div class="container4">             
            <!-- AD - Introductory statement about the ADMIN: Update Candidates page -->
            <h5 class = "adminTextCorrection2">CANDIDATE NOTE: If you have any queries, 
            or if you experience any technical issues, please contact our IT Admin team 
        	(support@theherald.com).
            <br><br>
            Only Global Herald IT Admins and yourself have access to your confidential data.
            </h5>        
        </div>           
       							    

        <!-- AD - End of the central (yellow container)-->
    </div> 
    
    <!-- The Modal -->
	<div id="myModal" class="modal">	
		  <!-- Modal content -->
		  <div class="modal-content">
		    <span class="close">&times;</span>
		    <h1>Select file to upload</h1>
			<form name="uploadform" method="post" enctype="multipart/form-data" action="/rest/uploadservice/uploadiamge">
				Select a file : 
				<input type="file" name="file" accept=".jpg" /><br>
				<input type="hidden" name="candidate_id" value="${candidate.candidate_id}" /><br>
				<button onClick="submitform()">UPLOAD</button>
			</form>
		  </div>
	</div>
         
         		<script type="text/javascript">
					function submitform()
					{
					  document.uploadform.submit();
					}
				</script>
         		
    			<script>
    			
    			// Get the modal
                var modal = document.getElementById("myModal");
               
            	// Get the button that opens the modal
				var btn = document.getElementById("popup");
            	btn.onclick = function() {
            		modal.style.display = "block";
            	}
            	
            	//Get the span (x)
               	var span = document.getElementsByClassName("close")[0];
               	span.onclick = function() {
	                   modal.style.display = "none";
	                 }
               	
    			</script>
    
    			<script type="text/javascript">
    				
    				function enableAll(){
    					
    					var x = document.getElementsByClassName('switch');
    					var i;
    					for (i = 0; i < x.length; i++) {
    					  x[i].removeAttribute("disabled");
    					}
            		}
                </script>
                  
    			<!-- 			
    			
    			AD - This HTML markup contains a DIV, which contains inside of it
                another div element, which possesses show / hide functionality.
                The button has been assigned a JavaScript Onclick event handler.
                When clicked, the function is executed. Furthermore, 
                based on the value of the button, the HTML div toggle 
                functionality will be executed. AKA the div will be shown, 
                and the button text and colour changed. -->    
                <script type="text/javascript">
                
                    function toggleProfileUpdate(btnUpdateProfile) {
                        var dvUpdateProfile = document.getElementById("dvUpdateProfile");
                                                
                        if (btnUpdateProfile.value == "UPDATEvisible") {
                            dvUpdateProfile.style.display = "block";                            
                           
                            btnUpdateProfile.style.display = "none";                            
                            
                        } else {
                            dvUpdateProfile.style.display = "none";
                            btnUpdateProfile.value = "UPDATEvisible";
                            btnUpdateProfile.style.backgroundColor = "#2A9D8F";                           
                        }
                    }                     
                    
                    /* AD - This is for the delete profile button */
                    function toggleProfileDelete(btnDeleteProfile) {
                        var dvDeleteProfile = document.getElementById("dvDeleteProfile");
                                                
                        if (btnDeleteProfile.value == "ADD") {
                        	dvDeleteProfile.style.display = "block";                            
                           
                            btnDeleteProfile.style.display = "none";                            
                            
                        } else {
                        	dvDeleteProfile.style.display = "none";
                            btnDeleteProfile.value = "ADD";
                            btnDeleteProfile.style.backgroundColor = "#2A9D8F";                           
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
					
					/* AD - JS function to show the current time */
					var displayTimeAndDate = document.getElementById("displayTimeAndDate");

					function refreshTime() {
					  var dateString = new Date().toLocaleString("en-GB", {timeZone: "Europe/Helsinki"});
					  var formattedString = dateString.replace(", ", " - ");
					  displayTimeAndDate.innerHTML = formattedString;
					}
					
					setInterval(refreshTime, 1000);
					
					</script>     
                	
                	

	 <!-- AD - includes the footer component into this page 
	    (albeit not visible) -->
    
	<%@ include file="../components/footer.jsp" %> 

</body>
</html>