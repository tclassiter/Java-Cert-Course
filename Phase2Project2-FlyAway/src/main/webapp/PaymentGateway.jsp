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

<br><br><br><br><br><br>
<body>
<div class = format align = center>

<h1><font color = "white">Please Enter Your Credit Card Information for Payment</font></h1><br>

<br><br><br><br>

<form action = FinalConfirmation method = post>
<input type = text name = CardFirstName placeholder = "First Name on Card">
<input type = text name = CardLastName placeholder = "Last Name on Card">
<input type = text name = CardAddress placeholder = "Billing Address">
<input type = text name = CardNumber placeholder = "Card Number">
<input type = text name = CardExp placeholder = "Card Expiration Date">
<input type = text name = CardSecurity placeholder = "Security Code">

<br><br><br>
<input type="submit" value = "Let's Go!" style="background-color: #00cc99;">
</form>

</div>
</body>
</html>