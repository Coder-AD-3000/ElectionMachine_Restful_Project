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
			Add a New Question: <input type='text' name='new_question' value=''>
<!-- 			<input type='submit' name='ok' value='OK'> -->
		<input type='button' name='ok' value='Send' onclick='sendDataWithJavascript(this.form);'><br>
		<input type='button' name='ok' value='Get All' onclick='getData();'><br>

		</form>
<!-- 	<ol> -->
<%-- 		<c:forEach var="newquestion" items="${requestScope.newquestionlist }"> --%>
<%-- 			<li>${newquestion} <a href='../deletenewquestion?newquestion_id=${newquestion.newquestionId}'>Delete</a> <a href='../readtoupdatenewquestion?newquestion_id=${newquestion.newquestionId}'>Update</a> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ol> -->

<script>
function sendDataWithJavascript(form){
    var newquestion=new Object();
    newquestion.new_question=form.new_question.value;
   
    var jsonLaptop=JSON.stringify(newquestion);
       
   
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
       document.getElementById("response").innerHTML = this.responseText;
      }
    };
    xhttp.open("POST", "/rest/newquestionservice/addnewquestion", true);
//    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.setRequestHeader("Content-type", "application/json");
   
    xhttp.send(jsonNewquestion);
}

function getData(){
    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
    	// First to the result field JSON as is        
    	var result=this.responseText;
        document.getElementById("result").innerHTML = result;
     // Then decompress it into a Javascript object table 
        laptoplist = JSON.parse(result);
        var txt="";
     // Go through the table one at a time and append
        // the values of each individual object in the variable txt
        for (index in newquestionlist){
              txt += newquestionlist[index].new_question + "<br>";
            
        }
       
        //The same with normal for-statement
/*        for (i=0;i<laptoplist.length;i++){
              txt += laptoplist[i].brand + "<br>";
             txt += laptoplist[i].price + "<br>";
            txt += laptoplist[i].weight + "<br>";
        }
*/       
	//Add the resulting string to the result2 field
	document.getElementById("result2").innerHTML = txt;
       }
    };
    xmlhttp.open("GET", "/rest/newquestionservice/readnewquestion", true);
    xmlhttp.send();   
}

</script>

	</body>
</html>