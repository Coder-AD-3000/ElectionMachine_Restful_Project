<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
// init empty vars
String role = (String) request.getSession().getAttribute("role");


//AD - If there is an ID showing up, then it gives you a logout button.
if (role != null) {
%>

    <!-- AD - This file is a 'navbar' page component, which is to 
              be included on all pages. -->

    <!-- AD - customises the navbar-->
    <div class="container-nav1">

        <div class="container-nav3">
            <div class="container-nav4">
                <!-- AD - icon customisation -->
                <div class = "container-nav-links-icon">
                <a href="../jsp/adminPortal.jsp"><i class="material-icons resize3a">account_balance</i></a>              
                </div>
                <div class = "container-nav-links">
                    <a href="../jsp/about.jsp"><h5>About</h5></a>
                </div>
                <div class = "container-nav-links">
                    <a href="../readallquestion"><h5>Questionnaire</h5></a>
                </div>
                <div class = "container-nav-links">
                    <a href="../ShowCandidates"><h5>Candidates</h5></a>
                </div>
                <div class = "container-nav-links">               

                    <a href=#>
                    	<h5>
		                    <form class=logout-button action="../logout" method="post">
                        <input type="submit" value="Logout" >
                        </form>
                    	</h5>
                    </a>

                </div>           
            </div>
        </div>
        
    </div>

<%
}
else {
	// AD - if you don't have an ID showing up, then it gives you a login button.
	%>
    <!-- AD - This file is a 'navbar' page component, which is to 
              be included on all pages. -->

    <!-- AD - customises the navbar-->
    <div class="container-nav1">

        <div class="container-nav3">
            <div class="container-nav4">
                <!-- AD - icon customisation -->
                <div class = "container-nav-links-icon">
                <a href="../jsp/adminPortal.jsp"><i class="material-icons resize3a">account_balance</i></a>              
                </div>
                <div class = "container-nav-links">
                    <a href="../jsp/about.jsp"><h5>About</h5></a>
                </div>
                <div class = "container-nav-links">
                    <a href="../readallquestion"><h5>Questionnaire</h5></a>
                </div>
                <div class = "container-nav-links">
                    <a href="../ShowCandidates"><h5>Candidates</h5></a>
                </div>
                <div class = "container-nav-links">
                  <a href="../jsp/loginPage.jsp"><h5>Login</h5></a>
                </div>           
            </div>
        </div>
        
    </div>
     <%
}
%>

     


