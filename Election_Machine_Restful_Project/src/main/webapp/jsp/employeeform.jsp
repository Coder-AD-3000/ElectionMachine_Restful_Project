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
				 <div class="containerInnerCandidatesTable3"> 		
					<div class="table-responsive"> 
						<table class="table">                    
			                <thead class = "tableCustom1">
			                    <tr>		
									<th>FIRST NAME:</th>
									<th>LAST NAME:</th>
									<th>USERNAME:</th>
									<th>PASSWORD:</th>
									<th></th> <!-- intentionally left blank for submit -->						
							 	</tr>
			            	</thead>		
				            <tbody>
				            	<tr>
				            		<td>            		
				            			<input type='text' name='first_name' value=''>
				            		</td>
				            		<td>  
										<input type='text' name='last_name' value=''>
									</td>
									<td>
										<input type='text' name='username' value=''>
									</td>
									<td> 
										<input type='text' name='password' value=''>            		
				            		</td>	
				            	    <td>
									 	<input style = "width:80%" class = "buttonShowHide2 button1" 
									 	type='submit' name='ok' value='SUBMIT'> 					 
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
    
	<%@ include file="../components/footer.jsp" %> 
</body>
</html>