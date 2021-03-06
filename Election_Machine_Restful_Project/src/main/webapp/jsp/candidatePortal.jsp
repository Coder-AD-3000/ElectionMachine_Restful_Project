<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>

	<title>Candidate Portal</title>

    <!-- AD - includes the header component, into this page -->
    <%@ include file="../components/header.jsp" %>     

</head>
<body>

	<!-- AD - A message in the top left to show an active session message -->
	<div class = "candidateSession"><i>Candidate Session Active ${requestScope.fromfilter }</i></div>

    <!-- AD - includes the navbar component, into this page -->
    <%@ include file="../components/navbar.jsp" %>    

    <div class = "container1">
        <div class = "container1c">          
            <h5>WELCOME</h5>     
            <a href="../jsp/index.jsp"><i class="material-icons resize3">account_balance</i></a>   
            <h5>ELECTION MACHINE</h5>            
        </div>

        <!-- AD - Configures the Admin Portal -->
        <div class = "containerAdminPortal">
            <form action="RegistrationServlet" method="post">                                      
                    <legend class = "adminPortal2"><b>CANDIDATE PORTAL </b></legend>
                    <hr>
                    <legend class = "adminPortal3"><b>MENU: </b></legend>
                    <hr>  
                    <table>                    
                    <tr><td><b class = "adminPortal4">Access:</b><a href="/jsp/index.jsp" target="_blank"> <u><b>Home Page </b></u></a></td></tr>
                    <tr><td><b class = "adminPortal4">Access:</b><a href="/readmyprofile" target="_blank"> <u><b>My Profile </b></u></a></td></tr>         
                    <tr><td><b class = "adminPortal4">Access:</b><a href="/readallquestion" target="_blank"> <u><b>Take Questionnaire </b></u></a></td></tr>                                                
                    <tr>                    		                    
                    </tr>                   
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