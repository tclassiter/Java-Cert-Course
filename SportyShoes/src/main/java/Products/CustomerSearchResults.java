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

 
public class CustomerSearchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//JDBC Driver, URL and Credentials
		String URL = "jdbc:mysql://localhost:3306/SportyShoes";
		String Username = "root"; 
		String Password = "123";
								
		//Response content type
		response.setContentType("text/html");
		PrintWriter pw1 = response.getWriter();
								
		//Trying to establish database connection and pass parameters from JSPs.
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL,Username,Password);
		Statement stmt = con.createStatement();
							
		//Retrieving JSP parameter values
		String ProductBrand = request.getParameter("ProductBrand");
		String ProductCategory = request.getParameter("ProductCategory");
		
		//Placing JSP parameter values into database via INSERT statement
		String submit = "INSERT INTO ProductInformation (ProductBrand,ProductCategory) "
				      + "VALUES ('"+ProductBrand+"','"+ProductCategory+"')";						
		stmt.executeUpdate(submit);
		
		//Retrieving database values via ResultSet method
		ResultSet Price = stmt.executeQuery("SELECT ProductPrice FROM ProductInformation");	
		
		//Iterative loop to retrieve database values
		while (Price.next()) {
		
		//PrintWriter method to print HTML page with JSP parameter values 
		pw1.println
		("<html>"
	+   "<style>"			
	+   "body {"
    +	"background-image: URL('Customer.jpg');" 
	+	"background-repeat: no-repeat;"
	+	"background-size: cover;"
	+	"background-color: #d3d3d3;}"			    	
	+	"input[type=submit], select {"
	+	"text-align: center;"
    +   "width: 20%;"
	+	"padding: 12px 20px;"
	+	"margin: 15px;"
	+	"border: 1px solid #ccc;"
	+	"cursor: pointer;}"			    		
	+	".Format {"
	+	"text-align: center;"
	+	"width: 60%;"
	+	"margin: 155px 100px;"
	+	"padding: 20px;}"
	+   "</style>"		
	
	+   "<body>"
	+	"<div class = Format>"
	+   "<form action = 'PaymentGateway.jsp'>"
	+   "<h2><font color = 'white'>Yes, those shoes are available! </font>"		
	
		//For purposes of this project, I have coded $120 into the HTML just for visual effect. For real world use, the 
		//"Price" will be replaced with variable +ProductPrice+ and the value will be pulled from the 
	    //SQL database via the RusultSet method using 'ProductPrice' in the SQL statement.
		
	+   "<h2><font color = 'white'>Brand: "+ProductBrand+" | Category: "+ProductCategory+" | Price: $120 <br><br><br><br>"
	+   "Availability: Here on the portal and at your local shopping center</h2></font>"		
	+   "<input type = submit value = 'Purchase' style ='background-color:#00cc99\"'>"
	+   "</form>"
	
	+	"<br><br><br><br><br>"
	+   "<form action  = 'CustomerPortal.jsp'>"
	+   "<h2><font color = 'white'>Not done shopping?<br>"
	+   "<input type = submit value = 'Customer Portal' style ='background-color:#00cc99\"'>"
	+	"</div>"		
    +   "</body>"
	+   "</html>");
}
}
//Exception if database connection fails			
catch(Exception e) {
e.printStackTrace();
}  		
} 
}