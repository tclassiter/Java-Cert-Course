<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

<style>
input[type=text], select {
	text-align: center;
	width: 25%;
	padding: 10px 20px;
	margin: 10px;
	border: 1px solid #ccc;
}
input[type=submit], select {
	text-align: center;
	width: 25%;
	padding: 12px 20px;
	margin: 12px;
	border: 1px solid #ccc;
	cursor: pointer;
}	
</style>
</head>

<title>List of Teachers</title>
<body>
	<div align = center>
	
		<br>
		<br>
		<h3>Please enter the teacher's name and ID number for assignment to a class and subject</h3>

		<form action="TeachersClassesSubjectsEntry" method="get">
		
			<input type="text" name="Teacher_First_Name" placeholder="Teacher First Name"><br>
	        <input type="text" name="Teacher_Last_Name" placeholder="Teacher Last Name"><br>
			<input type="text" name="Teacher_ID_Number" placeholder="Teacher ID Number"><br>
			<input type="text" name="Class_ID_Number" placeholder="Class ID Number"><br>
			<input type="text" name="Subject_ID_Number" placeholder="Subject ID Number"><br>
			<input type="submit" style="background-color: #00cc99;">
			
		
			<h3>Please click <a href ="TeachersClassesSubjectsList">here</a> to retrieve a list of teachers and which classes and subjects they are teaching</h3>
		</form>
</div>
</body>
</html>