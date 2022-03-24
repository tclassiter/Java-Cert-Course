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


<title>List of All Classes</title>
<body>
    <br>
	<br>
	<br>
 
	<div align=center>
	
		<h3>Please enter the class level (Freshmen, Sophomore, etc...) and ID number for entry in the database:</h3>

		<form action="ClassEntry" method="get">
		
			<input type="text" name="ClassLevel" placeholder="Class Level"><br>
		
			<input type="text" name="ClassIDNumber" placeholder="Class ID Number"><br>
			
			<input type="submit" style="background-color: #00cc99;">
		
		</form>


		<form>
		<h3>Please click <a href = "ClassList">here</a> to retrieve a list of all Classes at Learner's Academy</h3>
		</form>

</div>
</body>
</html>