<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Customer Login</title>

<style>

body {
background-image: URL("Portal.jpg"); 
background-repeat: no-repeat;
background-size: cover;
}
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
	margin: 15px;
	border: 1px solid #ccc;
	cursor: pointer;

</style>
</head>

<div align = center>

<br><br><br><br>

<h1><font color = "white">Please Enter Your Username and Password</font></h1>

<form action = CustomerLoginControl method = post>
<input type = text name = UserName placeholder = Username>
<input type = text name = PassWord placeholder = Password><br>
<input type = submit style = "background-color: #00cc99;">
</form>


<form action = NewCustomerLogin.jsp>
<input type = submit value = "Create a New Login" style = "background-color: #00cc99;">
</form>

</div>
</body>
</html>