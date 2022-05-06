<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Sporty Shoes Customer Portal</title>
<style>

body {
	background-image: URL("Customer.jpg"); 
	background-repeat: no-repeat;
	background-size: cover;
}
.Format {
	text-align: center;
	width: 70%;
	margin: 155px 50px;
	padding: 20px;
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
	width: 18%;
	padding: 12px 20px;
	margin: 15px;
	border: 1px solid #ccc;
	cursor: pointer;
}	

</style>
</head>

<body>
<div class = Format>

<br><br>
<h2><font color = "white">Search shoes by name brand, type or price range</font></h2>

<form action = CustomerSearchResults method = post>
<input type = text name = ProductBrand placeholder = "Brand Name">
<input type = text name = ProductCategory placeholder = "Category">
<input type="submit" value = "Let's Go!" style="background-color: #00cc99;">
</form>

<br><br><br><br><br><br>
<h2><font color = "white">Join our discount and subscription club</font></h2>
<form action = CustomerInformation method = post>
<input type = text name = CustomerFirstName placeholder = "First Name">
<input type = text name = CustomerLastName placeholder = "Last Name">
<input type = text name = EmailAddress placeholder = "Email Address">
<input type = text name = PostalAddress placeholder = "Postal Address">
<input type= submit value = "Let's Go!" style="background-color: #00cc99;">
</form>

</div>
</body>
</html>