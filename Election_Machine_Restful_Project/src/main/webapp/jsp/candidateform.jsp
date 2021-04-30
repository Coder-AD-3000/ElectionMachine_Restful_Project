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
		First Name: <input required type='text' name='first_name' placeholder="Cannot be blank." value=''>
		Last Name: <input required type='text' name='last_name' placeholder="Cannot be blank." value=''>
		Party: <input required type='text' name='party' placeholder="Cannot be blank." value=''>
		Location: <input required type='text' name='location' placeholder="Cannot be blank." value=''>		
		Age:<input required type='text' name='age' placeholder="Cannot be blank." value=''>
		Mission:<input required type='text' name='mission' placeholder="Cannot be blank." value=''>
		Vision:<input required type='text' name='vision' placeholder="Cannot be blank." value=''>
		Username:<input required type='text' name='username' placeholder="Cannot be blank." value=''>
		Password:<input required type='text' name='password' placeholder="Cannot be blank." value=''>
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