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

public class StudentEntry extends HttpServlet {
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
					
			String Fname = request.getParameter("First_Name");
			String Lname = request.getParameter("Last_Name");
			String Number = request.getParameter("ID_Number");
			String Class1 = request.getParameter("Class_ID_Number1");
			String Class2 = request.getParameter("Class_ID_Number2");
					
			String submit = "INSERT INTO Students " + "VALUES ('"+Fname+"','"+Lname+"','"+Number+"','"+Class1+"','"+Class2+"')";
			stmt.executeUpdate(submit);
					
		 
			pw1.println("<html>"
					+   "<body>"
					+   "<br><br><br>"
					+	"<center>The Teacher's first and last name and ID number have been successfully saved in the database. <br><br>"
					+	"Please click <a href = 'Teachers.jsp'> here </a> if you would like to add another Teacher."
					+	"</body>"
					+	"</html>");
					    
			stmt.close();
			con.close();
			}
			   
			catch(Exception e) {
			e.printStackTrace();
			
}
}
}