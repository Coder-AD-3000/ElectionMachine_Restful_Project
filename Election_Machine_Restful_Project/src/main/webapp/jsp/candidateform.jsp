<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidate Form</title>
<style>
.container {
color: blue;
background-color: grey;
width: 95%;
display: flex;
justify-content: center;
border-radius: 10px;
margin: 50px auto;
padding: 10px;
}
</style>
</head>
<body>
	<div class = "container">
		<form action='../addcandidate' method='post'>
		First Name: <input type='text' name='first_name' value=''>
		Last Name: <input type='text' name='last_name' value=''>
		Party: <input type='text' name='party' value=''>		
		Age:<input type='text' name='age' value=''>
		<input type='submit' name='ok' value='OK'>
		</form>
	</div>
<ol>
<c:forEach var="candidate" items="${requestScope.candidatelist }">
	<li>${candidate} <a href='../deletecandidate?candidate_id=${candidate.candidate_id}'>Delete</a> <a href='../readtoupdatecandidate?candidate_id=${candidate.candidate_id}'>Update</a>
</c:forEach>
</ol>
</body>
</html>