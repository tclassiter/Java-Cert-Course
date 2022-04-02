package FlightSearch;

import jakarta.servlet.ServletException;
 
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

 
public class CustomerSearchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//JDBC Driver, URL and Credentials
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
									
		String Date = request.getParameter("Date");
		String Airline = request.getParameter("Airline");
		String Origin = request.getParameter("Origin");
		String Destination = request.getParameter("Destination");
		String Passengers = request.getParameter("Passengers");
									
		String submit = "INSERT INTO Flights VALUES ('"+Date+"','"+Airline+"','"+Origin+"','"+Destination+"','"+Passengers+"')";				
		stmt.executeUpdate(submit);
		
		pw.println("<br><br><br>"
				   + "<body>"
				   + "<html>"
				   
				   + "<style>"
				   + "body {"
				   + "background-image: URL('Portal.jpg');" 
				   + "background-repeat: no-repeat;"
				   + "background-size: cover;}"
				   + "</style>"
				   
				   + "<br><br><br>"
				   + "<center><h1><font color = 'white'>Looks like that flight is available!</font><h1>"
				   
		 		   + "<table border=1 width=100% height=10% style ='background-color:#ffffff'>"    
                   + "<tr><td> <a href = 'RegistrationPage.jsp'> Book Flight </a></tr></td>"
		 		   
		 		   + "<tr><td> Date </td><td> Airline </td><td> Origin </td><td> Destination </td><td> Number of Passengers </td><td> Price </td></tr>"
		 		   + "<tr><td>" +Date+ "</td><td>" +Airline+ "</td><td>" +Origin+ "</td><td>" +Destination+ "</td><td>" +Passengers+ "</td><td> 300 USD</td></tr>"
                   + "</table>"
		 	       + "</html>"
		 	       + "</body>");  
}
		
			catch(Exception e) {
			e.printStackTrace();
			}  		
} 
}
	