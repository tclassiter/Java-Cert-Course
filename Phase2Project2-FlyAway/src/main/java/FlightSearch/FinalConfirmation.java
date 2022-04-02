package FlightSearch;

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
		
		//JDBC Driver, URL and Credentials
		String URL = "jdbc:mysql://localhost:3306/Phase2Project2";
		String Username = "root"; 
		String Password = "123";
		String CardFirstName = request.getParameter("CardFirstName");
		String CardLastName = request.getParameter("CardLastName");
		String CardAddress = request.getParameter("CardAddress"); 
		String CardNumber = request.getParameter("CardNumber");  
		String CardExp = request.getParameter("CardExp");  
		String CardSecurity = request.getParameter("CardSecurity");					
		
		//Trying to establish database connection and pass parameters from JSPs.
		try{							
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL,Username,Password);
		Statement stmt = con.createStatement();
		
		//Response content type
		response.setContentType("text/html");
	    PrintWriter pw= response.getWriter();	
	    ResultSet rs = stmt.executeQuery("select * from Flights"); 
		
        while (rs.next()){  
        	
            String Date = rs.getString("Date");  
            String Airline = rs.getString("Airline");  
            String Origin = rs.getString("Origin");  
            String Destination = rs.getString("Destination");  
            String Passengers = rs.getString("Passengers");  

            pw.println
            
    		
   		 ("<html>"                            
   		+ "<style>" 
   				 
   		+ "body {"	                    
   		+ "background-image: URL('Portal.jpg');" 	                    			 
   		+ "background-repeat: no-repeat;"                   
   		+ "background-size: cover;}"
   		+ "</style>"	
   		
   		+ "<body>"
   		+ "<br><br><br>"
   		
   		+ "<h1><font color = 'white'><center>Confirmation Page</font></h1>"
   		+ "<p><font color = 'white'><center>Please print and keep this page!</font></h1>"
   		
   		+ "<br><br><br>"
   		
   	    + "<table border=1 width=100% height=15% style ='background-color:#ffffff'>"
   	    
   	    + "<tr><th> Your First Name </th><th> Your Last Name </th><th> Your Mailing Address </th></tr>"
   	    + "<tr><td>" +CardFirstName+ "</td><td>" +CardLastName+ "</td><td>" +CardAddress+ "</td></tr>"
   	    
   	    + "<tr><th> Credit Card Number </th><th> Card Expiration </th><th> CardSecurity </th></tr>"
   	    + "<tr><td>" +CardNumber+ "</td><td>" +CardExp+ "</td><td>" +CardSecurity+ "</td></tr>"
   	    
   	    + "<tr><th>Travel Date</th><th>Airline</th><th> Origin </th><th> Destination </th><th> Passengers </th></tr>"
   	    + "<tr><td>" +Date+ "</td><td>" +Airline+ "</td><td>" +Origin+ "</td><td>" +Destination+ "</td><td>" +Passengers+ "</td></tr>"
   	    
   	    + "</table>"
   	    
   	    + "<br><br><br>"       		
   	    + "</body>"
   	    + "</html>");	
        }	      
}  
		
		catch(Exception e) {
		e.printStackTrace();
		}  		
} 
}          	         













