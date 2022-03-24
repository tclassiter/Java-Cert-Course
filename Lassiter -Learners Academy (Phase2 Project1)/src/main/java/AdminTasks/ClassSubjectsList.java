package AdminTasks;

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

 
public class ClassSubjectsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		//JDBC Driver, URL and Credentials
		String URL = "jdbc:mysql://localhost:3306/Phase2Project1";
		String Username = "root";
		String Password = "123";
				
		//Response content type
		response.setContentType("text/html");
	    PrintWriter pw = response.getWriter();
						
		//Trying to establish database connection and pass parameters from JSPs.
		try{
							
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,Username,Password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ClassSubjects"); 
					
		    pw.println("<table border=1 width=100% height=15%>");  
		    pw.println("<tr><th>Class ID Number</th>"
		            + "<th>Subject ID Number1</th><th>Subject ID Number2</th><th>Subject ID Number3</th>"
		            + "<th>Subject ID Number4</th><th>Subject ID Number5</th></tr>");  
		            
		    while (rs.next()) 
		         {  
		           String ClassID = rs.getString("Class_ID");  
		           String Subject1 = rs.getString("Subject_ID_Number1");  
		           String Subject2 = rs.getString("Subject_ID_Number2"); 
		           String Subject3 = rs.getString("Subject_ID_Number3");  
		           String Subject4 = rs.getString("Subject_ID_Number4"); 
		           String Subject5 = rs.getString("Subject_ID_Number5");   
		             
		           pw.println ("<tr><td>" +ClassID+ "</td><td>" 
		                                  +Subject1+ "</td><td>" +Subject2+ "</td><td>" +Subject3+ "</td><td>" 
		                                  +Subject4+ "</td><td>" +Subject5+ "</td></tr>");   
		            }  
		            
		            pw.println("</table>");  
		            pw.println("</html></body>");  
		            con.close();  
		           }  
		
			catch(Exception e) {
				
			e.printStackTrace();
			}  				
}
}
		           
		     
		    
	