<!--


Author: Les
Date: May 7, 2021
Version: 1
-->


<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../components/meta.jsp" %>
    <title>New Employee To Update Form</title>
    <%@ include file="../components/headerBootstrap.jsp" %>        
</head>
<body>
	<div class = "adminSession"><i>Admin Session Active ${requestScope.fromfilter }</i></div> 
    <%@ include file="../components/navbarBootstrap.jsp" %>
       
    <!-- central yellow container start-->
    <div class="containerMainUpdateCandidates">
        <a href="../index.jsp"><i class="material-icons resize3">account_balance</i></a>
        <div class="container6a"> 
        <h3 class = "adminTextCorrection1">ADMIN PORTAL: Update Employees</h3>
        </div>
        <div class="container4">             
            <h5 class = "adminTextCorrection2">ADMIN NOTE: Once logged in, this page allows for a 'Global Herald Newspaper' 
                IT Admin to update employee information.
                <br>
                <br>
                Regular users and candidates do not have access to this page 
                (or its functionality).
            </h5>        
        </div>           
    </div>  

	<!-- 	update employees -> employee.emachinedb	-->
    <div class="containerUpdateCandidatesTable">                                                                                                
    	<div class="table-responsive"> 
			<form action='../updateemployee' method='post'>
				<div class="containerUpdateEmployeeTable"> 	
					<table class="table">                    
	            		<thead class = "tableCustom1">
		                    <tr>
								<th style = "width:15%">NEW EMPLOYEE ID:</th>
								<th>FIRST NAME:</th>
								<th>LAST NAME:</th>
								<th>USERNAME:</th>
								<th>PASSWORD:</th>
								<th></th><!-- intentionally left blank for UPDATE button -->
							</tr>
	           			</thead>
	           			<tbody>
		            		<tr>         		
		            			<td> 	
									<input readonly class="greyed-background" style = "width:20%" type='text' name='employee_id' value='${requestScope.employee.employee_id }'>
								</td>
								<td>
									<input required style = "width:100%" type='text' name='first_name' value='${requestScope.employee.first_name }'>
								</td>
								<td>
									<input required style = "width:100%" type='text' name='last_name' value='${requestScope.employee.last_name }'>
								</td>
								<td>
									<input required style = "width:100%" type='text' name='username' value='${requestScope.employee.username }'>
								</td>
								<td>
									<input required style = "width:100%" type='text' name='password' value='${requestScope.employee.password }'>
								</td>
								
								
							 	<td class="tableAddBackground">			
						
						<!-- LH - This button activates two separate functions. 
							      One function reveals the hidden div, 
							      and the other loads the loading bar animation. -->					 
						<Button type = "button" id = "btnAddEntry" value='ADD' onClick="ShowHideToggle1(this); move();">
						<b class = "tableAdd">UPDATE</b></Button>
						
						<div id ="dvAddEntry" style="display:none">					 
					  		<p style = "width:125px"><b style = "color: rgba(255, 255, 255, 0.555)">Confirm Update?</b></p>	
					  			
					  			
					  			<div class="loaderEmployee2"></div>
													  
							  <table class="table-responsive">
								  <tbody>
									  <tr>
										 <td class="tableAddBackground">									 	
										 						
								 	  		<input type='submit' name='ok' value='CONFIRM' class = "tableAdd" 
								 	  		style="font-weight:bold;">
								 	  	 </td> 							  
									  	 <td>
										   <Button type="button" value='' onClick="window.location = '../reademployee';">
										   <b>CANCEL</b></Button>
									  	</td>
									  	<td>								  
									  	
									  	</td>
									  </tr>								  
								  </tbody>						  
							   </table>
							 	
							 </div>	
							 	
							</tr>
						</tbody>
					</table>
					
							<!-- The loading bar -->
							<div id="myProgress" style="display: none">
						  		<div id="myBar">10%</div>
							</div>		
					
				</div>
			</form>
		</div>
	</div>   
	
	
					<!-- LH - animation JavaScript script -->
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
								
					
					/* LH - Toggle button to reveal the hidden div */			
					 function ShowHideToggle1(btnAddEntry) {
		                     var dvAddEntry = document.getElementById("dvAddEntry");
		                                             
		                     if (btnAddEntry.value == "ADD") {
		                         dvAddEntry.style.display = "block";
		                         
		                         /* LH - This is for the loading bar */
		                         myProgress.style.display = "block";
		                        
		                         btnAddEntry.style.display = "none";                            
		                         
		                     } else {
		                         dvAddEntry.style.display = "none";
		                         btnAddEntry.value = "ADD";
		                         btnAddEntry.style.backgroundColor = "#2A9D8F";                           
		                     }
		                 } 	
					
					</script>      	
	
	
	
	
	<%@ include file="../components/footer.jsp" %> 
</body>
</html>