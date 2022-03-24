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

 
public class TeachersClassesSubjectsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		//JDBC Driver, URL and Credentials
		String URL = "jdbc:mysql://localhost:3306/Phase2Project1";
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
			ResultSet rs = stmt.executeQuery("select * from TeachersClassesSubjects"); 
					
		    pw.println("<table border=1 width=100% height=15%>");  
		    pw.println("<tr><th>Teacher First Name</th><th>Teacher Last Name</th><th>Teacher ID Number</th>"
		            		+  "<th>Class ID Number</th><th>Subject ID Number</th>");  
		            
		    while (rs.next()) 
		    {  
		     String Fname = rs.getString("Teacher_First_Name");  
		     String Lname = rs.getString("Teacher_Last_Name");  
		     String Number = rs.getString("Teacher_ID_Number");
		     String ClassID = rs.getString("Class_ID_Number"); 
		     String Subject = rs.getString("Subject_ID_Number");  
		          
		            
		     pw.println("<tr><td>" +Fname+ "</td><td>" +Lname+ "</td><td>" +Number+ "</td><td>" 
		                           +ClassID+ "</td><td>" +Subject+ "</td></tr>");   
		            }  
		            
		            pw.println("</table>");  
		            pw.println("</html></body>");  
		            con.close();  
		           }  
				
		            catch (Exception e) 
		           {  
		            pw.println("error");  
		           }  
}  
}  