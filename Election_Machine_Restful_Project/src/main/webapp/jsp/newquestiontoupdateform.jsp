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
<form action='../updatenewquestion' method='post'>
<input type='text' name='newquestion_id' value='${requestScope.newquestion.newquestionId }'>
<input type='text' name='new_question' value='${requestScope.newquestion.newquestion }'>
<input type='submit' name='ok' value='OK'>
</form>
</body>
</html>