<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>

	<title>Admin Portal</title>

    <!-- AD - includes the header component, into this page -->
    <%@ include file="../components/header.jsp" %>     

</head>
<body>

    <!-- AD - includes the navbar component, into this page -->
    <%@ include file="../components/navbar.jsp" %>    
    
    <!-- if not logged in as admin -> index page -->

    <div class = "container1">
        <div class = "container1c">          
            <h5>WELCOME</h5>     
            <a href="../jsp/index.jsp"><i class="material-icons resize3">account_balance</i></a>   
            <h5>ELECTION MACHINE</h5>            
        </div>

        <!-- AD - Configures the Admin Portal -->
        <div class = "containerAdminPortal">
            <form action="RegistrationServlet" method="post">                                      
                    <legend class = "adminPortal2"><b>ADMIN PORTAL </b></legend>
                    <hr>
                    <legend class = "adminPortal3"><b>MENU: </b></legend>
                    <hr>  
                    <table>                    
					<tr><td><b class = "adminPortal4">Access:</b><a href="/jsp/employeeform.jsp" target="_blank"> <u><b>Employee Data </b></u></a></td></tr> 
                    <tr><td><b class = "adminPortal4">Access:</b><a href="/jsp/candidateform.jsp" target="_blank"> <u><b>Candidate Data </b></u></a></td></tr>                  
                    <tr><td><b class = "adminPortal4">Access:</b><a href="/jsp/newquestionform.jsp" target="_blank"> <u><b>New Questions </b></u></a></td></tr>                                      
                    <tr><td><b class = "adminPortal4">Access:</b><a href="/jsp/index.jsp" target="_blank"> <u><b>Home Page </b></u></a></td></tr>
                    <tr><td></td><td><br>
                    </table>
                    <hr>        
            </form> 
        </div>        
    </div>
    
    <!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %>

</body>
</html>