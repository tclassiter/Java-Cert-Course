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
 
public class ClassReportList extends HttpServlet {
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
			ResultSet rs = stmt.executeQuery("select * from ClassReport"); 
					
		    pw.println("<table border=1 width=100% height=15%>");  
		    pw.println("<tr><th>Class ID</th><th>Student's First Name</th><th>Student's Last Name</th><th>Student ID</th>"
		    		+ "<th>Subject</th><th>Subject</th><th>Subject</th><th>Subject</th><th>Subject</th>"
		    		+ "<th>Teacher's First Name</th><th>Teacher's Last Name</th><th>Teacher's ID Number</th></tr>");
		            
		    
		            while (rs.next()) 
		            {  
		            	String ClassID = rs.getString("Class_ID_Number");  
		            	
		            	String StudentFname = rs.getString("Student_First_Name");  
		                String StudentLname = rs.getString("Student_Last_Name");  
		                String StudentID = rs.getString("Student_ID_Number");  
		                
		                String Subject1 = rs.getString("Subject_ID_Number1");
		                String Subject2 = rs.getString("Subject_ID_Number2");
		                String Subject3 = rs.getString("Subject_ID_Number3");
		                String Subject4 = rs.getString("Subject_ID_Number4");
		                String Subject5 = rs.getString("Subject_ID_Number5");
		                
		                String TeacherFname = rs.getString("Teacher_First_Name");
		                String TeacherLname = rs.getString("Teacher_Last_Name");
		                String TeacherID = rs.getString("Teacher_ID_Number");
		    
		                pw.println("<tr><td>" 
		                
		                		+ClassID+ "</td><td>"              
		                		+StudentFname+ "</td><td>" +StudentLname+ "</td><td>" +StudentID+ "</td><td>"             
		                		+Subject1+ "</td><td>" +Subject2+ "</td><td>" +Subject3+ "</td><td>" +Subject4+ "</td><td>" +Subject5+ "</td><td>"            
		                		+TeacherFname+ "</td><td>" +TeacherLname+ "</td><td>" +TeacherID+ "</td></tr>");
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

