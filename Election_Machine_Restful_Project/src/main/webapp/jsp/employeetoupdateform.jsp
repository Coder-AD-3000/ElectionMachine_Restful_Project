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
                IT Admin to add, edit and remove employee information.
                <br>
                <br>
                Regular users and candidates do not have access to this page 
                (or its functionality).
            </h5>        
        </div>           
    </div>  

	<!-- 	update employees -> empoloyee.emachinedb	-->
    <div class="containerUpdateCandidatesTable">                                                                                                
    	<div class="table-responsive"> 
			<form action='../updateemployee' method='post'>
				<div class="containerInnerCandidatesTable"> 	
					<table class="table">                    
	            		<thead class = "tableCustom1">
		                    <tr>
								<th style = "width:30%">NEW EMPLOYEE ID:</th>
								<th>FIRST NAME:</th>
								<th>LAST NAME:</th>
								<th>USERNAME:</th>
								<th>PASSWORD:</th>
								<th></th><!-- intentionally left blank for submit -->
							</tr>
	           			</thead>
	           			<tbody>
		            		<tr>         		
		            			<td> 	
									<input readonly class="greyed-background" style = "width:25%" type='text' name='employee_id' value='${requestScope.employee.employee_id }'>
								</td>
								<td>
									<input style = "width:100%" type='text' name='first_name' value='${requestScope.employee.first_name }'>
								</td>
								<td>
									<input style = "width:100%" type='text' name='last_name' value='${requestScope.employee.last_name }'>
								</td>
								<td>
									<input style = "width:100%" type='text' name='username' value='${requestScope.employee.username }'>
								</td>
								<td>
									<input style = "width:100%" type='text' name='password' value='${requestScope.employee.password }'>
								</td>
							 	<td>
							 		<input class = "buttonShowHide2 button1 buttonColourMod1 "type='submit' name='ok' value='UPDATE'>					 
							 	</td>
							</tr>
						</tbody>
					</table>
				</div>
			</form>
		</div>
	</div>   
	<%@ include file="../components/footer.jsp" %> 
</body>
</html>