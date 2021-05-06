<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- AD - This file is a 'navbar' page component, which is to 
              be included on all pages. -->

    <!-- AD - customises the navbar-->
    <div class="container-nav1">

        <div class="container-nav3">
            <div class="container-nav4">
                <!-- AD - icon customisation -->
                <div class = "container-nav-links-icon">
                	<c:set var="role" scope="session" value="${sessionScope.role}"/>
					<c:choose>
					  <c:when test="${role == 'candidate'}">
					    <a href="../jsp/candidatePortal.jsp"><i class="material-icons resize3a">account_balance</i></a>
					  </c:when>
					  <c:when test="${role == 'employee'}">
					    <a href="../jsp/adminPortal.jsp"><i class="material-icons resize3a">account_balance</i></a>
					  </c:when>
					  <c:otherwise>
					    <a href="../jsp/index.jsp"><i class="material-icons resize3a">account_balance</i></a>
					  </c:otherwise>
					</c:choose>                </div>
                <div class = "container-nav-links">
                    <a href="../about.jsp"><h5 class = "adminTextCorrection3">About</h5></a>
                </div>
                <div class = "container-nav-links">
                    <a href="../ShowQuestions"><h5 class = "adminTextCorrection3">Quiz</h5></a>
                </div>
                <div class = "container-nav-links">
                    <a href="../ShowCandidates"><h5 class = "adminTextCorrection3">Candidates</h5></a>
                </div>
                <div class = "container-nav-links">               

                    <c:set var="role" scope="session" value="${sessionScope.role}"/>
					<c:choose>
					  <c:when test="${role == 'candidate'}">
					    <a href=#>
	                    	<h5>
			                    <form class=logout-button action="../logout" method="post">
	                        		<input type="submit" value="Logout" >
	                        	</form>
	                    	</h5>
                    	</a>
					  </c:when>
					  <c:when test="${role == 'employee'}">
					    <a href=#>
	                    	<h5>
			                    <form class=logout-button action="../logout" method="post">
	                        		<input type="submit" value="Logout" >
	                        	</form>
	                    	</h5>
                    	</a>
					  </c:when>
					  <c:otherwise>
					    <p><a href="../jsp/loginPage.jsp"><h5>Login </h5></a></p>
					  </c:otherwise>
					</c:choose>

                </div>           
            </div>
        </div>
        
    </div>
