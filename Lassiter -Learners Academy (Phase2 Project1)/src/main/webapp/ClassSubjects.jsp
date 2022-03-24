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
	margin: 20px;
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

<title>Subjects for Classes</title>
<body>
<br>
	<div align=center>
	
		<h3>Please enter the class and subject ID numbers for inclusion in the database:</h3>
	
		<form action="ClassSubjectsEntry" method="get">
		
			<input type="text" name="Class_ID_Number" placeholder="Class ID"><br>
			
			<input type="text" name="Subject_ID_Number1" placeholder="Subject ID Number"><br>
			
			<input type="text" name="Subject_ID_Number2" placeholder="Subject ID Number"><br>
			
			<input type="text" name="Subject_ID_Number3" placeholder="Subject ID Number"><br> 
			
			<input type="text" name="Subject_ID_Number4" placeholder="Subject ID Number"><br>
			
			<input type="text" name="Subject_ID_Number5" placeholder="Subject ID Number"><br>
			
			<input type="submit" style="background-color: #00cc99;">
		</form>

		<form>
			<h3>Please click <a href = "ClassSubjectsList">here</a> to retrieve a list of classes and their subjects</h3>
		</form>
	
</div>
</body>
</html>