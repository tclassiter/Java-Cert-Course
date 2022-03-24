package AdminTasks;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
  
public class TeachersClassesSubjectsEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//JDBC Driver, URL and Credentials
		String URL = "jdbc:mysql://localhost:3306/Phase2Project1";
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
			
			
			String Fname = request.getParameter("Teacher_First_Name");
			String Lname = request.getParameter("Teacher_Last_Name");
			String Number = request.getParameter("Teacher_ID_Number");
			String ClassID = request.getParameter("Class_ID_Number");
			String Subject = request.getParameter("Subject_ID_Number");
			
			
			String submit = "INSERT INTO TeachersClassesSubjects " + "VALUES ('"+Fname+"','"+Lname+"','"+Number+"','"+ClassID+"','"+Subject+"')";
			stmt.executeUpdate(submit);
			
			pw1.println("<html>"
					+   "<body>"
					+ 	"<br><br><br>"
					+   "<center>The teacher, class and subject have been added to the database. <br><br>"
					+   "Please click <a href = 'TeachersClassesSubjects.jsp'> here </a> if you would like to add another teacher, class and subject."
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