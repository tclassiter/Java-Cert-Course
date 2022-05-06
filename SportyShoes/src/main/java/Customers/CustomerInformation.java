package Customers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Trying to create a JDBC connection
		String URL = "jdbc:mysql://localhost:3306/SportyShoes";
		String Username = "root"; 
	    String Password = "123";
		String CFN1 = request.getParameter("CustomerFirstName");
		String CLN1 = request.getParameter("CustomerLastName");
		response.setContentType("text/html");
		PrintWriter pw1= response.getWriter();
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL,Username,Password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT CustomerFirstName,CustomerLastName,EmailAddress,PostalAddress FROM CustomerInformation"); 
   	    
   	    //Iterative while loop to retrieve JSP parameter and ResultSet values from SQL database
   		while (rs.next()) {
   			
   		//Variable declarations for JSP parameter and ResultSet values	
   		String CFN2 = rs.getString("CustomerFirstName");  
   	   	String CLN2 = rs.getString("CustomerLastName");
   	    String EA = rs.getString("EmailAddress");
   	    String PA = rs.getString("PostalAddress");

   	    //If algorithm to test parameter and ResultSet values against user inputs
   	    if ((CFN1.equalsIgnoreCase(CFN2)) && (CLN1.equalsIgnoreCase(CLN2))) {
   	    	
   	    //PrintWriter method to display HTML with JSP parameter and ResultString variables
   	    pw1.println
		 ("<html>"                            
		+ "<style>" 
		+ ".format{"
		+ "margin: 25px 500px;}"
		+ "</style>"
		+ "<body>"
		+ "<div class = 'format'>"
		+ "<br><br><br><br><br><br>"
		+ "<p><font color = 'white'>Customer's First Name: '"+CFN2+"' </font></p><br>"
		+ "<p><font color = 'white'>Customer's Last Name: '"+CLN2+"' </font></p><br>"
		+ "<p><font color = 'white'>Customer's Email Address: '"+EA+"' </font></p><br>"
		+ "<p><font color = 'white'>Customer's Postal Address: '"+PA+"' </font></p><br>"
	    + "</div>"    
	    + "</body>"
	    + "</html>");}
   	    
   	    //Second part of If/Else algorithm.
   	    else {
   	    pw1.println
   		 ("<html>"                            
   		+ "<body>"
   		+ "<br><br><br><br><br><br><br><br><br><br><br><br>"
   		+ "<h1><center>No customer by that name</h1>"
   		+ "<form action = 'AdminPortal.jsp'>"
   		+ "<p><center>Please select the button below to return to the admin portal</p>"
   		+ "<center><input type = submit value = 'Return to Admin Portal'>"
   		+ "</form>"
   		+ "</body>"
   		+ "</html>");}
}
}
//Exception if database connection fails
catch(Exception e) {
e.printStackTrace();
}  		
}

	
	
	
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			////JDBC Driver, URL and Credentials
			String URL = "jdbc:mysql://localhost:3306/SportyShoes";
			String Username = "root"; 
			String Password = "123";
									
			//Response content type
			response.setContentType("text/html");
			PrintWriter pw1= response.getWriter();
									
			//Trying to establish database connection and pass parameters from JSPs.
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(URL,Username,Password);
				Statement stmt = con.createStatement();
					
				//Retrieving JSP parameter values
				String CFN = request.getParameter("CustomerFirstName");
				String CLN = request.getParameter("CustomerLastName");		
				String Email = request.getParameter("EmailAddress");
				String Mailing = request.getParameter("PostalAddress");	
				
				//Placing JSP parameter values into database via INSERT statement
				String submit = "INSERT INTO CustomerInformation (CustomerFirstName,CustomerLastName,EmailAddress,PostalAddress)"
							  + "VALUES ('"+CFN+"','"+CLN+"','"+Email+"','"+Mailing+"')";	
				
				stmt.executeUpdate(submit);
				
				//PrintWriter method to print HTML
				pw1.println
				(   "<html>"
			    +   "<style>"	
				+   "body {"
				+	"background-image: URL('Customer.jpg');" 
				+	"background-repeat: no-repeat;"
				+	"background-size: cover;}"		    	
				+	"input[type=submit], select {"
				+	"text-align: center;"
				+	"width: 20%;"
				+	"padding: 12px 20px;"
				+	"margin: 10px;"
				+	"border: 1px solid #ccc;"
				+	"cursor: pointer;}"
				+	".format {"
				+ 	"margin: 200px 400px;}"
				+   "</style>"
				+   "<body>"
				+   "<div class = format>"
				+   "<h2><font color = 'white'> Congrats!<br><br>"
				+   "You have joined our member club for discounts and newsletters!</font></h2>"
				+   "<form action = 'CustomerPortal.jsp'>"				
				+   "<input type = submit value = 'Return to Customer Portal' style ='background-color:#00cc99'>"
				+   "</div>"
				+   "</body>"
				+   "</html>");
						    
				stmt.close();
				con.close();				
}		
//Exception for if database connection fails
catch(Exception e) {
e.printStackTrace();}  									 
}
}

	
	
	

