<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<title>test</title>
	</head>
	
	
	<body>
		<ol>
			<!-- In JSTL library requestScope.image is the same as request.getAttribute('image') in Servlet class!!! -->
			<!-- Right click on the web page and select View page source to see the code after being compiled -->
			<li><img alt="test image" src='${requestScope.image}'>
			<li><img alt="test image" src="img/test.jpg">
		</ol>
		

	</body>
</html>