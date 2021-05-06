<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>

	<body>
		<form action='/addnewquestion' method='post'>
			<input type='text' name='new_question' value=''>
			<input type='submit' name='ok' value='OK'>
		</form>
	<ol>
		<c:forEach var="newquestion" items="${requestScope.newquestionlist }">
			<li>${newquestion} <a href='../deletenewquestion?newquestion_id=${newquestion.newquestionId}'>Delete</a> <a href='../readtoupdatenewquestion?newquestion_id=${newquestion.newquestionId}'>Update</a>
		</c:forEach>
	</ol>
	</body>
</html>