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

public class StudentList extends HttpServlet {
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
			ResultSet rs = stmt.executeQuery("select * from Students"); 
			
            pw.println("<table border=1 width=100% height=15%>");  
            pw.println("<tr><th>First Name</th><th>Last Name</th><th>ID Number</th><th>Class ID Number</th><th>Class ID Number</th></tr>");  
            
            while (rs.next()) 
            {  
                String Fname = rs.getString("First_Name");  
                String Lname = rs.getString("Last_Name");  
                int Number = rs.getInt("ID_Number");   
                String Class1 = rs.getString("Class_ID_Number1");  
                String Class2 = rs.getString("Class_ID_Number2"); 
                pw.println("<tr><td>" +Fname+ "</td><td>" +Lname+ "</td><td>" +Number+ "</td><td>" 
                                      +Class1+ "</td><td>" +Class2+ "</td>></tr>");   
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