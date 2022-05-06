package CheckOut;

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
 
public class FinalConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
      	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//JDBC connection information and variable declarations for JSP parameter values
		String URL = "jdbc:mysql://localhost:3306/SportyShoes";
		String Username = "root"; 
		String Password = "123";				
		
		//Response content type
		response.setContentType("text/html");
	    PrintWriter pw = response.getWriter();	
	    
		//Trying to establish database connection
		try{							
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL,Username,Password);
		Statement stmt = con.createStatement();
		
		//Retrieving JSP parameter values
		String CardFirstName = request.getParameter("CardFirstName");
		String CardLastName = request.getParameter("CardLastName");
		String CardAddress = request.getParameter("CardAddress"); 
		String CardNumber = request.getParameter("CardNumber");  
		String CardExp = request.getParameter("CardExp");  
		String CardSecurity = request.getParameter("CardSecurity");	
	    
	    //Putting JSP parameter values from into database
	    String submit = "INSERT INTO PurchaseInformation(CustomerFirstName,CustomerLastName,CardAddress,CardNumber,CardExp,CardSecurity) "
	    		+ "VALUES ('"+CardFirstName+"','"+CardLastName+"','"+CardAddress+"','"+ CardNumber +"','"+CardExp+"','"+CardSecurity+"')";
	    		stmt.executeUpdate(submit); 

	    //Retrieving values from SQL database for PrintWriter method
		ResultSet rs = stmt.executeQuery("SELECT ProductBrand,ProductCategory FROM ProductInformation"); 
		
		//Creating iterative loop to retrieve ResultSet variables from SQL database
		while(rs.next() ) {
	    String ProductBrand = rs.getString("ProductBrand");  
	   	String ProductCategory = rs.getString("ProductCategory");

	    //PrintWriter method printing HTML page        
	   	pw.println
   		 ("<html>"                            
   		+ "<style>" 
   		+ "body {"	                    
   		+ "background-image: URL('Customer.jpg');" 	                    			 
   		+ "background-repeat: no-repeat;"                   
   		+ "background-size: cover;}"	 
   	
   		
   		+ "<body>"
   		+ "<br><br><br><br><br><br>"
   		+ "<h1><font color = 'white'><center>Confirmation Page</font></h1>"
   		+ "<h2><font color = 'white'><center>Please print and keep this page!</font></h2>"
   		+ "<br><br><br>"
   		+ "<div class = 'format'>"
   		
   		//I have encoded $120 into the HTML for visual effect. When deployed, this application will "call" 
   		//the price amounts that the administrator places in the database via AdminProductControl.
   		  
   		+ "<h2><font color = 'white'>Order: "+ProductBrand+" | "+ProductCategory+" | $120 USD <br><br><br>" 
   	    + "First Name: "+CardFirstName+" <br> "
   	    + "Last Name: "+CardLastName+" <br> "
   	    + "Mailing Address: "+CardAddress+" <br> "
   	    + "Credit Card Number: "+CardNumber+" <br> "		
   	    + "Card Expiration Date: "+CardExp+" <br> Security Code: "+CardSecurity+"</font><p>"
   	    + "</div>"    
   	    + "</body>"
   	    + "</html>");}
}
//The exception for if the application cannot connect to the database.
catch(Exception e) {
e.printStackTrace();
}  		
} 
}
       	         