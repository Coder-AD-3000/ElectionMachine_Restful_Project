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
	
	<h2>Fill in - this form uses AJAX</h2>
<form action="#" method='post' onsubmit='return false;'>
Add a New Question: : <input id='new_question' type='text' name='new_question' value='' placeholder='Add a new question'><br>
<input type='button' name='ok' value='Add' onclick='sendData();'><br>
</form>
<p id='responseView'>The response will be shown here!
</p>
<p id='inparts'>The response in parts will be shown here!
</p>
	
	
	<script>
function sendData(){
	//Create a new Javascript object
	var newquestion=new Object();
	prey.new_question=document.getElementById("new_question").value;
	
	var jsonNewquestion=JSON.stringify(newquestion);
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
	   document.getElementById("responseView").innerHTML = this.responseText;
	   var returned=JSON.parse(this.responseText);
	   document.getElementById("inparts").innerHTML="ID="+returned.newquestion_id+" new_question="+returned.new_question;
	  }
	};
	
	xhttp.open("POST","./services/newquestionservice/addnewquestion",true);
	xhttp.setRequestHeader("Content-type","application/json");
	xhttp.send(jsonNewquestion);
 	
}
</script>
</head>
  
</body>
</html>