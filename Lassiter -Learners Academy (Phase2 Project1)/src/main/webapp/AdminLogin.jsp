<%@ page language="java" 
contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

<style>
body{
  background-image: ("Library.jpg");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: center;
}
input[type=text], select {
	text-align: center;
	width: 30%;
	padding: 10px 20px;
	margin: 20px;
	border: 1px solid #ccc;
}
input[type=submit], select {
	text-align: center;
	width: 30%;
	padding: 12px 20px;
	margin: 15px;
	border: 1px solid #ccc;
	cursor: pointer;
}	
</style>

<title>Administrator Login</title>
</head>

<body>
<br>
<br>

	<div align=center>
	
		<h3>Administrator Login</h3>
		<form action=LoginControl method=post>

			<input type="text" name="Username" placeholder="Username"> <br>
			<input type="text" name="Password" placeholder="Password"> <br>
			<input type="submit" style="background-color: #00cc99;">

		</form>
	</div>
</body>
</html>
