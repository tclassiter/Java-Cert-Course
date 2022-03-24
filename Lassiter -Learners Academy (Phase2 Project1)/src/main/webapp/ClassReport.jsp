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

<title>Class Report</title>
<body>
		<div align=center>
	
		   <h3>Please enter a class ID, as well as the class' students, subjects and teacher for entry in the Class Report:</h3>
		    <form action="ClassReportEntry" method="get">
			<input type="text" name="Class_ID_Number" placeholder="Class ID Number"><br>
			<input type="text" name="Student_First_Name" placeholder="Student's First Name">
			<input type="text" name="Student_Last_Name" placeholder="Student's Last Name">
			<input type="text" name="Student_ID_Number" placeholder="Student's ID Number"><br>
            <input type="text" name="Subject_ID_Number1" placeholder="Subject ID Number"><br>
			<input type="text" name="Subject_ID_Number2" placeholder="Subject ID Number"><br>			
			<input type="text" name="Subject_ID_Number3" placeholder="Subject ID Number"><br>			
			<input type="text" name="Subject_ID_Number4" placeholder="Subject ID Number"><br>			
			<input type="text" name="Subject_ID_Number5" placeholder="Subject ID Number"><br>			
			<input type="text" name="Teacher_First_Name" placeholder="Teacher's First Name">			
			<input type="text" name="Teacher_Last_Name" placeholder="Teacher's Last Name">			
			<input type="text" name="Teacher_ID_Number" placeholder="Teacher ID Number"><br>
			
			<input type="submit" style="background-color: #00cc99;">
		</form>

		<form>
			<h3>Please click <a href = "ClassReportList">here</a> to retrieve a complete Class Report</h3>
		</form>

</div>
</body>
</html>