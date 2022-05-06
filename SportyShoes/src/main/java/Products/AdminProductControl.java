package Products;

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

	 
	public class AdminProductControl extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//Database connection information
			String URL = "jdbc:mysql://localhost:3306/SportyShoes";
			String Username = "root"; 
		    String Password = "123";
		    
		    //Content type and PrintWriter declaration 
			response.setContentType("text/html");
			PrintWriter pw1= response.getWriter();
				
			//Trying to establish database connection and pass a SELECT statement
			try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,Username,Password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ProductBrand,ProductCategory FROM ProductInformation"); 
			
			//Iterative loop to search database
			
				
			String PB1 = request.getParameter("ProductBrand");
			String PC1 = request.getParameter("ProductCategory");
			
			while (rs.next()) {
			String PB2 = rs.getString("ProductBrand");
			String PC2 = rs.getString("ProductCategory");

			//If/Then algorithm to compare JSP parameter values to ResultSet values and display results in HTML
	   	    if ((PB1.equalsIgnoreCase(PB2)) && (PC1.equalsIgnoreCase(PC2))) {
	   	    	
	   	    //PrintWriter method
	   	    pw1.println
	   	    
			 ("<html>"                            
			+ "<style>" 
			+ ".format{"
			+ "margin: 25px 500px;}"
			+ "</style>"
			+ "<body>"
			+ "<div class = 'format'>"
			+ "<br><br><br><br><br><br>"

			+ "<p><font color = 'white'>Product Brand:'"+PB1+"'</font></p><br>"
			+ "<p><font color = 'white'>Product Category:'"+PC1+"'</font></p><br>"

		    + "</div>"    
		    + "</body>"
		    + "</html>");}
	   	    
	   	    //Second half of If/Then algorithm
	   	    else {
	   	    pw1.println
	   		 ("<html>"                            
	   		+ "<body>"
	   		+ "<br><br><br><br><br><br><br><br><br><br><br><br>"
	   		+ "<h1><center>No customer has purchased that product yet.</h1>"
	   		
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
			//JDBC Driver, URL and Credentials
			String URL = "jdbc:mysql://localhost:3306/SportyShoes";
			String Username = "root"; 
			String Password = "123";
									
			//Response content type
			response.setContentType("text/html");
			PrintWriter pw1= response.getWriter();
									
			//Trying to establish database connection and pass parameters from JSPs.
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,Username,Password);
			Statement stmt = con.createStatement();
							
			//Retrieving JSP parameter values
			String ProductBrand = request.getParameter("ProductBrand");
			String ProductCategory = request.getParameter("ProductCategory");
			String ProductDescription = request.getParameter("ProductDescription");
			String ProductPrice = request.getParameter("ProductPrice");
			String ProductAvailability = request.getParameter("ProductAvailability");
			
			//Inserting JSP parameter values into database via INSERT statement
			String submit = "INSERT INTO ProductInformation(ProductBrand,ProductCategory,ProductDescription,ProductPrice,ProductAvailability) "
					      + "VALUES ('"+ProductBrand+"','"+ProductCategory+"','"+ProductDescription+"','"+ProductPrice+"','"+ProductAvailability+"')";						
			
			stmt.executeUpdate(submit);
			
			//PrintWriter method for HTML display of JSP parameter values
			pw1.println
			("<html>"	
		+   "<style>"				
		+	"input[type=submit], select {"
		+	"text-align: center;"
	    +   "width: 20%;"
		+	"padding: 12px 20px;"
		+	"margin: 15px;"
		+	"border: 1px solid #ccc;"
		+	"cursor: pointer;}"		
		+	".DivFormat {"
		+	"text-align: center;"
		+	"width: 60%;"
		+	"margin: 255px 320px;"
		+	"padding: 20px;}"
		+   "</style>"			
		+   "<body>"
		+	"<div class = DivFormat>"
		+   "<form action = 'AdminPortal.jsp'>"
		+   "<h2>This product has been added to the customer database: </h2><br>"					
		+   "<h2>Brand: "+ProductBrand+" | Category: "+ProductCategory+" "
	    +   "| Description: "+ProductDescription+" | Price: "+ProductPrice+" | Availability: "+ProductAvailability+" </h2>"
		+	"<br><br><br>"
		+   "<p>Click here to add more products</p>"
		+   "<input type = submit value = 'Administrator Portal' style ='background-color:#FF0000\"'>"
		+	"</div>"		
	    +   "</body>"
		+   "</html>");
					    
			stmt.close();
			con.close();
					}
//Exception for if database connection fails				
catch(Exception e) {
e.printStackTrace();
}  		
} 
}