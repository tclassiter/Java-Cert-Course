<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

<title>Administrator Login</title>

<style>
body {
background-image: URL("AdminLogin.jpg"); 
background-repeat: no-repeat;
background-size: cover;
}
input[type=text], select {
	text-align: center;
	width: 20%;
	padding: 10px 10px;
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


<br><br><br>
<div align = center>

<h1 align = center><font color = "white">Please Enter Your Administrator Username and Password</font></h1><br>

<form action = AdminLoginControl method = post>

<input type = text name = UserName placeholder = UserName><br>
<input type = text name = PassWord placeholder = PassWord><br><br>

<input type = submit style ="background-color: #00cc99"><br><br>

<br><br><br><br>
<p><font color = "white">Please click <a href="NewAdminLogin.jsp">here </a>to create an administrator login</font></p><br>
</form>
</div>
</body>
</html>