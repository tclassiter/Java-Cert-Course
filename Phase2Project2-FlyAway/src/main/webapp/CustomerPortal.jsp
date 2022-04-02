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
	width: 12%;
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
<div class = format align = center>

<h1><font color = "white">Welcome to the Fly Away Customer Portal</font></h1>

<p><font color = "white">Please fill in the below fields to search for a flight</font></p><br>

<form action = CustomerSearchResults method = post>
<input type = text name = Date placeholder = "Date (yyyy-mm-dd)">
<input type = text name = Airline placeholder = "Airline">
<input type = text name = Origin placeholder = "Airport of Origin">
<input type = text name = Destination placeholder = "Airport of Destination ">
<input type = text name = Passengers placeholder = "Passengers">
<input type="submit" value = "Let's Go!" style="background-color: #00cc99;">
</form>

</div>
</body>
</html>