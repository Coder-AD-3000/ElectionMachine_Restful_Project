<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Candidate To Update Form</title>
<style>
.container2 {
color: #F0FFFF;
background-color: grey;
width: 95%;
display: flex;
justify-content: center;
border-radius: 10px;
margin: 50px auto;
padding: 10px;
}
.greyed-background {
background-color: grey;
}
</style>
</head>
	<body>
		<div class = "container2">
			<form action='../updatecandidate' method='post'>		
		    Candidate ID (Read Only):<input class = "greyed-background" type='text' name='candidate_id' value='${requestScope.candidate.candidate_id }' readonly>
			First Name:<input type='text' name='first_name' value='${requestScope.candidate.first_name }'>
			Last Name:<input type='text' name='last_name' value='${requestScope.candidate.last_name }'>
			Party: <input type='text' name='party' value='${requestScope.candidate.party }'>		
			Age:<input type='text' name='age' value='${requestScope.candidate.age }'>
			<input type='submit' name='ok' value='OK'>
			</form>
		</div>
	</body>
</html>