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
  
public class ClassReportEntry extends HttpServlet {
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
			
			String ClassID = request.getParameter("Class_ID_Number");
			
			String StudentFname = request.getParameter("Student_First_Name");
			String StudentLname = request.getParameter("Student_Last_Name");
			String StudentID = request.getParameter("Student_ID_Number");
			
			String Subject1 = request.getParameter("Subject_ID_Number1");
			String Subject2 = request.getParameter("Subject_ID_Number2");
			String Subject3 = request.getParameter("Subject_ID_Number3");
			String Subject4 = request.getParameter("Subject_ID_Number4");
			String Subject5 = request.getParameter("Subject_ID_Number5");
			
			String TeacherFname = request.getParameter("Teacher_First_Name");
			String TeacherLname = request.getParameter("Teacher_Last_Name");
			String TeacherID = request.getParameter("Teacher_ID_Number");
			
			
			String submit = "INSERT INTO ClassReport " + "VALUES ('"+ClassID+"','"+StudentFname+"','"+StudentLname+"','"+StudentID+"','"
					+Subject1+"','"+Subject2+"','"+Subject3+"','"+Subject4+"','"+Subject5+"','"
					+TeacherFname+"','"+TeacherLname+"','"+TeacherID+"')";
			        
			
			stmt.executeUpdate(submit);
			
			pw1.println("<html>"
					+   "<body>"
					+ 	"<br><br><br>"
					+   "<center>The class and subject have been added to the database. <br><br>"
					+   "Please click <a href = 'ClassSubjects.jsp'> here </a> if you would like to add another Class and its Subjects."
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
