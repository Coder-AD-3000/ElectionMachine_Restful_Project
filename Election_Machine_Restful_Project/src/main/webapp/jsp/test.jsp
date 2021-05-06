<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Tag Example</title>
</head>
<body>
<c:set var="quantity" scope="session" value="0"/>
<c:choose>
  <c:when test="${accessoryDetail.storeQuantity} gt 0">
    <p>${quantity} Available</p>
  </c:when>
  <c:otherwise>
    <p>Not available</p>
  </c:otherwise>
</c:choose>
</body>
</html>