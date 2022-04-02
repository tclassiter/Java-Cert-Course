<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Fly Away Customer Portal</title>

<style>
body {
background-image: URL("Portal.jpg"); 
background-repeat: no-repeat;
background-size: cover;
}
input[type=text], select {
	text-align: center;
	width: 11%;
	padding: 10px 20px;
	margin: 20px;
	border: 1px solid #ccc;
}
input[type=submit], select {
	text-align: center;
	width: 20%;
	padding: 12px 20px;
	margin: 15px;
	border: 1px solid #ccc;
	cursor: pointer;
}	
</style>
</head>

<br><br><br><br><br>
<body>
<div align = center>

<h1><font color = "white">Please Register to Book This Flight</font></h1><br>
 
<form action = FinalFlightDetails method = get>
<input type = text name = FirstName placeholder = "First Name">
<input type = text name = LastName placeholder = "Last Name">
<input type = text name = MailingAddress placeholder = "Mailing Address">
<input type = text name = EmailAddress placeholder = "Email Address"><br>
<input type="submit" value = "Continue to Book Flight" style="background-color: #00cc99;">
</form>

</div>
</body>
</html>