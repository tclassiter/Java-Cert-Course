<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Login</title>

<style>

body {
background-image: URL("Customer.jpg"); 
background-repeat: no-repeat;
background-size: cover;
}

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
	margin: 15px;
	border: 1px solid #ccc;
	cursor: pointer;
}	
</style>
</head>

<div align = center> 
<br><br><br><br><br><br><br><br><br><br><br>
<h1><font color = 'white'>Please Enter Your New Account Information</font></h1><br> 
                   
<form action = NewCustomerLogin method = post>
<input type = text name = CustomerFirstName placeholder = "First Name"><br>
<input type = text name = CustomerLastName placeholder = "Last Name"><br>
<input type = text name = NewUserName placeholder = "User Name"><br>
<input type = text name = NewPassWord placeholder = "Pass Word"><br><br>
<input type = submit name = SubmitButton  style = "background-color: #00cc99">
</form>
</div>

</body>
</html>


