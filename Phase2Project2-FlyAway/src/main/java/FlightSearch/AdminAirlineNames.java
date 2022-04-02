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

 
public class AdminAirlineNames extends HttpServlet {
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
				   
					while (rs.next()) { 
					
				    String AirlineName = rs.getString("Airline"); 
						
		            pw.println
		                      ("<table border=1 width=100% height=15%>" 
		            		 + "<tr><th>Airline</th></tr>" 
		            		 + "<tr><td>" +AirlineName+ "</td></tr>" 
		            		 + "</table>"  
		            		 + "</html>"
		            		 + "<style>"
		            		 + "<body> {"
		            		 + "background-image: URL('AdminLogin.jpg');"
		            		 + "background-repeat: no-repeat;"
		            		 + "background-size: cover;}"
		            		 + "</style>"
		            		 + "</body>");  
		            
		            
		            }
		            con.close();  
		            }  
					catch(Exception e) {
					e.printStackTrace();
					}  				
					}
}