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

 
public class AdminFullEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//JDBC Driver, URL and Credentials
				String URL = "jdbc:mysql://localhost:3306/Phase2Project2";
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
									
				String Date = request.getParameter("Date");
				String Airline = request.getParameter("Airline");
				String Origin = request.getParameter("Origin");
				String Destination = request.getParameter("Destination");
				String Passengers = request.getParameter("Passengers");
									
				String submit = "INSERT INTO Flights VALUES ('"+Date+"','"+Airline+"','"+Origin+"','"+Destination+"','"+Passengers+"')";
									
				stmt.executeUpdate(submit);
									
				pw1.println("<html>"
					    +   "<style>"
						+   "body {"
						+   "background-image: URL('AdminLogin.jpg');" 
						+   "background-repeat: no-repeat;"
						+   "background-size: cover;}"
						+   "</style>"
						+   "<body>"
						+ 	"<br><br><br><br><br><br>"
						+   "<center>"
						+   "<font color = 'white'>The airline name, airport of origin and destination and number of passengers have been added to the database.</font><br><br>"
						+   "<font color = 'white'>Please click <a href = 'AdminPortal.jsp'> here </a> if you would like to input more information.</font>"
						+   "</body>"
						+   "</html>");
									    
						stmt.close();
						con.close();
						}
							
						catch(Exception e) {
						e.printStackTrace();
								}  		
								} 
		}