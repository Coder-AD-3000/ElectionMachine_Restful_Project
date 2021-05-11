<!DOCTYPE html>
<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
    
    <title>Login Page</title>

    <!-- AD - includes the headerScript component, into this page -->
    <%@ include file="../components/headerScript.jsp" %> 
   
</head>

<body>


   <!-- AD - includes the navbar component, into this page -->
   <%@ include file="../components/navbar.jsp" %>  

    <!-- AD - Welcome message inside the Login Section-->
    <div class = "container1">

        <div class = "container1c">          
            <h5>WELCOME</h5>     
            <a href="../jsp/index.jsp"><i class="material-icons resize3">account_balance</i></a>             
            <h5>ELECTION MACHINE</h5>            
        </div>

        <!-- AD - Login Section-->
        <div class = "container1b">
            <form action="../checkuser" method="post">      
                <legend><b>Site Login</b></legend>
                <table>
                    <hr> 
                    <tr>
                        <td><b>Username: </b></td>
                        <td><input type="text" name="user" required="required" /></td>
                    </tr>
                    <tr>
                        <td><b>Password: </b></td>
                        <td><input type="password" name="pwd" required="required" /></td>
                    </tr>                    
                    <tr>                        
                        <td><br><input class = "button-main button1 mainloginButton" type="submit" value="LOGIN" /></td>
                    </tr>
                </table>
                <hr>        
        </form> 
        </div>

        
    </div>
 
</body>

		<!-- AD - 'LoginFooter' container Section-->
        <div class = "containerLoginFooter">
	        <!-- AD - A small container to amend the login note background section-->
	        <div class="container4">             
	            <!-- AD - Introductory statement about the ADMIN: Update Candidates page -->
	            <h5 class = "adminTextCorrection2">LOGIN NOTE: If you forgot your username 
	            or password, or if you experience any technical issues, please contact our IT Admin team 
	        	(support@theherald.com).
	            <br><br>
	            Only Global Herald IT Admins and yourself have access to your confidential data.
	            </h5>        
	        </div> 
		</div>


    <!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %> 

</html>