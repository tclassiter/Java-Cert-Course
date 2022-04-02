<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Login</title>

<style>
body {
background-image: URL("AdminLogin.jpg"); 
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
}	
</style>
</head>



<div align = center>
<br>
<br>
<br>
<h1 align = center><font color = "white">Please Enter a New Username and Password</font></h1><br>

<form action = NewAdminLogin method = post>

<input type = text name = NewUserName placeholder = Username><br>
<input type = text name = NewPassWord placeholder = Password><br><br>

<input type = submit style ="background-color: #00cc99">

</form>
</div>
</body>
</html>