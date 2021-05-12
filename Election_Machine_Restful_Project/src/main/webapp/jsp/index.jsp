<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
    
    <title>Homepage</title>
    
   <!-- AD - includes the header component, into this page -->
    <%@ include file="../components/header.jsp" %>      
   
</head>
<body>

   <!-- AD - includes the navbar component, into this page -->
   <%@ include file="../components/navbar.jsp" %> 

    <!-- AD - Beginning the central (yellow container)-->
    <div class="container">
        <a href="../jsp/index.jsp"><i class="material-icons resize1">account_balance</i></a>
    
        <!-- AD - customises the welcome message-->
        <div class="container6"> 
          
        <h2>Homepage</h2>

        </div>
       
        <!-- AD - This container adds colourings and style to the intro message -->
        <div class="container5">
          <!-- AD - Election machine questions -->
          <h5>Welcome to our site! This election machine website is run by the 'Global Herald Newspaper',
              in association with the 'HAMK's Finest' server programming team. 
              Take our election machine questionnaire to find out which candidate 
              is the right election candidate for you!
          </h5>
        </div>

        <!-- AD - This container customises the 'please register' message-->
        <div class="container7">
	     	<c:set var="msg" scope="session" value="${requestScope.message}"/>
	     	<c:set var="role" scope="session" value="${sessionScope.role}"/>
			<c:choose>
			  <c:when test="${role == 'employee'}">
			    <h3>You are logged in as employee: <c:out value="${sessionScope.username}"></c:out></h3>
			  </c:when>
			  <c:when test="${msg != null}">
					<h3><c:out value="${msg}"></c:out></h3>
			  </c:when>			  
			  <c:otherwise>
			    	<h3>Please click the 'Take Quiz' button to start the questionnaire!</h3>
			  </c:otherwise>
			</c:choose>        
          	
        </div>
    
        <hr>   

        <!-- AD - Beginning of the selection button section (answers)-->
        <div class="container2">           
            <!-- AD - A small container to amend the disclaimer background section-->
            <div class="container4">  
            
                <!-- AD - Questionnaire guidance for the user -->
		        <h5>DISCLAIMER: Neither the 'Global Herald Newspaper' or 'HAMK's Finest'
                are to be held liable for any views or comments expressed by the candidates 
                or users of this site. Your data is confidential and will not be shared or
                sold in any capacity. All rights reserved.</h5>
            
            </div>
		    
            <hr>      
    
            <!-- AD - button container, containing buttons-->
            <div class="container3">
            	    <c:set var="role" scope="session" value="${sessionScope.role}"/>
					<c:choose>
					  <c:when test="${role == 'employee'}">
					    <button class="button-main button1" onclick="window.location.href='/jsp/adminPortal.jsp'"><b>My Portal</b></button>
					  </c:when>
					  <c:otherwise>
					    <button class="button-main button1" onclick="window.location.href='/readallquestion'"><b>Take Quiz</b></button>
					  </c:otherwise>
					</c:choose>                 

                
              
            </div>
        
        <!-- AD - End of the selection button section (answers)-->
        </div>

    <!-- AD - End of the central (yellow container)-->
    </div>
        
    <!-- AD - includes the footer component, into this page (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %>  

</body><!-- AD - End of body-->
</html><!-- AD - End of html-->