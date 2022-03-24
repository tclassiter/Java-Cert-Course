<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

<style>
input[type=text], select {
	text-align: center;
	width: 20%;
	padding: 10px 20px;
	margin: 10px;
	border: 1px solid #ccc;
}

input[type=submit], select {
	text-align: center;
	width: 20%;
	padding: 12px 20px;
	margin: 12px;
	border: 1px solid #ccc;
	cursor: pointer;
}	

</style>
</head>


<title>List of Teachers</title>
<body>
    <br>
	<br>
	
	<div align=center>
	
		<h3>Please enter the student's name and ID number for entry in the database</h3>

		<form action="StudentEntry" method="get">
		
			<input type="text" name="First_Name" placeholder="Student's First Name"><br>
	        <input type="text" name="Last_Name" placeholder="Student's Last Name"><br>
			<input type="text" name="ID_Number" placeholder="Student's ID Number"><br>
			<input type="text" name="Class_ID_Number1" placeholder="Class 1"><br>
			<input type="text" name="Class_ID_Number2" placeholder="Class 2"><br>
			
			<input type="submit" style="background-color: #00cc99;">
		</form>
<br>
		<form>
		<h3>Please click <a href = "StudentList">here</a> to retrieve a list of all students at Learner's Academy</h3>
		</form>

</div>
</body>
</html>