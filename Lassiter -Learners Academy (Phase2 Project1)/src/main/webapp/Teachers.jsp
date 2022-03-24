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
	
		<h3>Please enter the teacher's name and ID number for entry in the database</h3>

		<form action="TeacherEntry" method="get">
			<input type="text" name="First_Name" placeholder="Teacher's First Name"><br>
			
	        <input type="text" name="Last_Name" placeholder="Teacher's Last Name"><br>
	        
			<input type="text" name="ID_Number" placeholder="Teacher's ID Number"><br>
			
			<input type="submit" style="background-color: #00cc99;">
<br>		 
		<h3>Please click <a href = "TeacherList">here</a> to retrieve a list of all teachers at Learner's Academy</h3>
		</form>

</div>
</body>
</html>