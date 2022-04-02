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


public class FinalFlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String URL = "jdbc:mysql://localhost:3306/Phase2Project2";
		String Username = "root";
		String Password = "123";
	
		
		//Response content type
		response.setContentType("text/html");
	    PrintWriter pw= response.getWriter();
				
			//Trying to establish database connection and pass parameters from JSPs.
			try{
					
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(URL,Username,Password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Flights"); 
		
	            while (rs.next()) 
	            {  
	            	String FirstName = request.getParameter("FirstName");
	            	String LastName = request.getParameter("LastName");
	            	String MailingAddress = request.getParameter("MailingAddress");
	            	String EmailAddress = request.getParameter("EmailAddress");
	            	String Date = rs.getString("Date");  
	                String Airline = rs.getString("Airline");
	                String Origin = rs.getString("Origin");  
	                String Destination = rs.getString("Destination");
	                String Passengers = rs.getString("Passengers");  
	 
	            pw.println
	                      ("<html>"
	                    		  
	                      +"<style>"
	                      +"body {"
	                      +"background-image: URL('Portal.jpg');" 
	                      +"background-repeat: no-repeat;"
	                      +"background-size: cover;}"
	                      +"</style>"	
	                      
	            		  +"<body>"
	                      +"<br><br><br><br>"
	                      +"<h1><font color = 'white'><center>Overview of your contact information and flight details</font></h1>"
	                      
	                      +"<br><br><br>"
	                      
	                      +"<table border=1 width=100% height=15% style ='background-color:#ffffff'>"
	                      
						  +"<tr><th> First Name </th><th> Last Name </th><th> Mailing Address </th><th> Email Address </th></tr>"
						  +"<tr><td>" +FirstName+ "</td><td>" +LastName+ "</td><td>" +MailingAddress+ "</td><td>" +EmailAddress+ "</td></tr>" 
	                      
	                      +"<tr><th> Date </th><th> Airline </th><th> Origin </th><th> Destination </th><th> Passengers </th></tr>"
	                      +"<tr><td>" +Date+ "</td><td>" +Airline+ "</td><td>" +Origin+ "</td><td>" +Destination+ "</td><td>" +Passengers+ "</td></tr>"  
	                      
	                      +"</table>"
	                      +"<br><br><br>"
	                      +"<form action = 'PaymentGateway.jsp'>"
	                      +"<center><input type = 'submit' value = 'Please click here to purchase your flight' style = 'background-color: #00cc99;'>"
	                      +"</form>"
	                      +"</body>"	  
	                      +"</html>");

	            con.close();  
	           }  
			}
			catch(Exception e) {
			e.printStackTrace();
			}  				
}
}












