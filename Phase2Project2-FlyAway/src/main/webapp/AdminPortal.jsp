<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Administrative Tasks</title>

<style>
body {
background-image: URL("AdminLogin.jpg"); 
background-repeat: no-repeat;
background-size: cover;
}

input[type=text], select {
	text-align: center;
	width: 13%;
	padding: 10px 20px;
	margin: 20px;
	border: 1px solid #ccc;
}
input[type=submit], select {
	text-align: center;
	width: 15%;
	padding: 12px 20px;
	margin: 15px;
	border: 1px solid #ccc;
	cursor: pointer;
}	
</style>
</head>

 
<body>
<div align = center>
<br><br><br><br><br><br>

<h1><font color = "white">Fly Away Administrative Portal</font></h1>
<p><font color = "white">Add name of airline, airport of origination and destination, and passengers into the customer's database</font></p>

<form action="AdminFullEntry" method = "post">
<input type ="text" name = "Date" placeholder = "Date of Flight">
<input type ="text" name = "Airline" placeholder = "Name of Airline">
<input type ="text" name = "Origin" placeholder = "Origin Airport Name">
<input type ="text" name = "Destination" placeholder = "Destination Airport Name">
<input type ="text" name = "Passengers" placeholder = "Passengers"><br>
<input type="submit" style="background-color: #00cc99;">
</form>
</div>
 



<br><br><br><br>
<div align = "center" class = div>
<p align = "center"><font color="white">Or, select one of the below options for a master list</font></p>

<form action = "AdminOriginDestination" method = get>
<input type ="submit" name = "OriginAndDestination" value = "Origin and Destination Airports" style ="background-color: #00cc99">
</form>

<form  action = "AdminAirlineNames" method = get>
<input type ="submit" name = "AirlineName" value = "Names of Airlines"  style ="background-color: #00cc99;">
</form>


</div>


<br><br><br>
<p><font color = "white"> Please click <a href = "NewAdminLogin.jsp">here</a> to reset your admin account password.</font></p>
</body>
</html>