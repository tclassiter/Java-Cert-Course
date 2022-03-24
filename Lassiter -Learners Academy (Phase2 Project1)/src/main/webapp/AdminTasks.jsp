<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

<style>

input[type=text], select {
	text-align: left;
	width: 50%;
	padding: 12px 20px;
	margin: 15px;
	border: 1px solid #ccc;
}
input[type=submit], select {
	text-align: left;
	width: 25%;
	padding: 12px 20px;
	margin: 15px;
	border: 1px solid #ccc;
	display: block;
	cursor: pointer;
}
</style>

<title>Administrative Tasks</title>
</head>
<body>
<div align = center>
<br>
		<h2>Welcome to Learner Academy's Management Portal</h2>
	
		<h3>Create or Show Lists:</h3>

		<form action="ClassSubjects.jsp">
			<input type="submit" value="All Subjects for All Classes" style="background-color: #00cc99;">
		</form>
		
		<form action="Teachers.jsp">
			<input type = "submit" value ="All Teachers" style="background-color: #00cc99;">
		</form>
		
		<form action="Classes.jsp">
			<input type="submit" value="All Classes" style="background-color: #00cc99;">
		</form>
		
		<form action="TeachersClassesSubjects.jsp">
			<input type="submit" value="Assign Teachers to a Class for a Subject" style="background-color: #00cc99;">
		</form>
		
		<form action="Students.jsp">
			<input type="submit" value="All Students" style="background-color: #00cc99;">
		</form>
		
		<form action="ClassReport.jsp">
			<input type="submit" value="Class Report of Students, Subjects and Teachers" style="background-color: #00cc99;">
		</form>
</div>
</body>
</html>
