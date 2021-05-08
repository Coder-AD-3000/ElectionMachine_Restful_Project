<!--
JSP code creates view pane for performing post-create CRUD operations on employee.emachinedb

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
    <title>Employee Form</title>
    <%@ include file="../components/headerBootstrap.jsp" %>        
</head>
<body>
	<div class = "adminSession"><i>Admin Session Active ${requestScope.fromfilter }</i></div> 
    <%@ include file="../components/navbarBootstrap.jsp" %>
    <!-- central yellow container-->
    <div class="containerMainUpdateCandidates">
        <a href="../index.jsp"><i class="material-icons resize3">account_balance</i></a>
        <div class="container6a"> 
        <h3 class = "adminTextCorrection1">ADMIN PORTAL: Update Employees</h3>
        </div>
	        <div class="container4">             
	            <h5 class = "adminTextCorrection2">ADMIN NOTE: Once logged in, this page allows for a 'Global Herald Newspaper' 
	                IT Admin to add, edit and remove employee information.
	                <br>
	                <br>
	                Regular users and candidates do not have access to this page 
	                (or its functionality).
	            </h5>        
			</div>           
    	</div>  
	
	<!-- 	create employees -> empoloyee.emachinedb	-->
    <div class="containerUpdateCandidatesTable">                                                                                                
       <div class="table-responsive"> 
			<form action='/addemployee' method='post'>	
				 <div class="containerEmployeeCreate"> 		
					<div class="table-responsive"> 
						<table class="table">                    
			                <thead class = "tableCustom1">
			                    <tr>
			                    	<th></th>
			                    	<th>EMPLOYEE_ID</th>		
									<th>FIRST NAME:</th>
									<th>LAST NAME:</th>
									<th>USERNAME:</th>
									<th>PASSWORD:</th>
									<th></th> <!-- intentionally left blank for submit -->						
							 	</tr>
			            	</thead>		
				            <tbody>
				            	<tr>
				            	
				            	<td class="tableAddBackground">					 
					 
								<Button type = "button" id = "buttonAddEmployee" value='ADD' onClick="employeeToggle(this)">
								<b class = "tableAdd">SUBMIT</b></Button>
								
								<div id ="divAddEmployee" style="display: none">					 
							  		<p style = "width:125px"><b style = "color: rgba(255, 255, 255, 0.555)">Confirm Addition?</b></p>	
							  								  		
							  		<div class="loaderEmployee"></div> 
							  		
							  						  								  
									  <table class="table-responsive">
										  <tbody>
											  <tr>
												 <td class="tableAddBackground">									 	
												 						
										 	  		<input type='submit' name='ok' value='ADD ENTRY' class = "tableAdd" 
										 	  		style="font-weight:bold;">
										 	  	 </td> 							  
											  	 <td>
												   <Button type = "button" value='' onClick="window.location = '../jsp/employeeform.jsp';">
												   <b>CANCEL</b></Button>
												   
											  	</td>
											  </tr>								  
										  </tbody>						  
									   </table>
								</div>
				            		<td>
				            		<input readonly class="greyed-background" type='number' 
				            		name='employee_id' placeholder="Auto Incremented" value=''>
				            		</td>			            	
				            		<td>            		
				            			<input required type='text' name='first_name' value='' placeholder="Required..">
				            		</td>
				            		<td>  
										<input required type='text' name='last_name' value='' placeholder="Required..">
									</td>
									<td>
										<input required type='text' name='username' value='' placeholder="Required..">
									</td>
									<td> 
										<input required type='text' name='password' value='' placeholder="Required..">            		
				            		</td>
					           	</tr>
				            </tbody>
						</table>
					</div>
				</div>		
			</form>
		</div>
	</div> 		
			
	<!-- delete/update options-->
    <div class="containerUpdateCandidatesTable">                                                                                                
    	<div class="table-responsive"> 	
    	
    		<div class="table-responsive">                  
               <table class="table">                
				<thead class = "tableCustom1"> 						
						<tr>                   			
                   			<th style = "text-align: left;" class="tableCandidateDB"><button onclick="location.href='../reademployee';" value=''>
                   			<b class = "tableUpdate">SHOW DATABASE</b></Button></th>                  		
                  			</tr>
                     </thead>                        
                </table> 
    		</div> 	
    		
			<div class="containerInnerCandidatesTable">	
				<ol>
					<c:forEach var="employee" items="${requestScope.employeelist }">
						<table class="table">                    
	        				<thead class = "tableCustom1">
                    			<tr>		
									<th>NEW EMPLOYEE DATABASE ENTRY</th>												
				 				</tr>
	            			</thead>  
        				</table> 
        				<div class="containerInnerCandidatesTable1">
        					<div class="containerInnerCandidatesTable2">
								<li>
									<table>
										<tr>
											<td> 
												<b>Name:</b> 
											</td>
											<td> 
												${employee.first_name} ${employee.last_name}
											</td>
										</tr>
										<tr>
											<td> 
												<b>Employee_id:</b> 
											</td>
											<td> 
												${employee.employee_id}
											</td>
										</tr>
										<tr>
											<td> 
												<b>Username:</b> 
											</td>
											<td> 
												${employee.username}
											</td>
										</tr>
										<tr>
											<td> 
												<b>Password:</b> 
											</td>
											<td> 
												******
											</td>
										</tr>
									</table>	
								</li> 
							</div>
							<hr> 
							<div class="containerInnerCandidatesTable2 buttonMarginCorrection2">
										
								<div>
								 <a class = "button-main button1" 
								 href='../deleteemployee?employee_id=${employee.employee_id}'>				 
								 <b>DELETE</b>
								 </a> 
								</div>
															
								 <div>
								 <a class = "buttonShowHide2 button1" 
								 href='../readtoupdateemployee?employee_id=${employee.employee_id}'>				 
								 <b class = "buttonColourMod1">UPDATE</b></a> 
								</div>				
					
							</div>			
						</div>	
					</c:forEach>
				</ol>
			</div>
	 	</div>
	</div>
	
	<!-- js for 'add employee' div -->
	<script type="text/javascript">
		function employeeToggle(buttonAddEmployee) {
		    var divAddEmployee = document.getElementById("divAddEmployee");
		                            
		    if (buttonAddEmployee.value == "ADD") {
		    	divAddEmployee.style.display = "block";                            
		       
		        buttonAddEmployee.style.display = "none";                            
		    } else {
		    	divAddEmployee.style.display = "none";
		        buttonAddEmployee.value = "ADD";
		        buttonAddEmployee.style.backgroundColor = "#2A9D8F";                           
		    }
		}                                                     
	</script> 
    
	<%@ include file="../components/footer.jsp" %> 
</body>
</html>