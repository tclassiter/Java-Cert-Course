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

public class ClassEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String URL = "jdbc:mysql://localhost:3306/Phase2Project1";
		String Username = "root";
		String Password = "123";
		
		//Response content type.
		response.setContentType("text/html");
	    PrintWriter pw1= response.getWriter();
				
			//Trying to establish database connection and pass parameters from JSPs.
			try{
					
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(URL,Username,Password);
				Statement stmt = con.createStatement();
					
				String Class_ID_Number = request.getParameter("ClassIDNumber");
				String Class_Level = request.getParameter("ClassLevel");
				
				String submit = "INSERT INTO Classes " + "VALUES ('"+Class_ID_Number+"','"+Class_Level+"')";
				stmt.executeUpdate(submit);
					
		 
				pw1.println("<html>"
							+   "<body>"
							+ 	"<br><br><br>"
							+   "<center>The Class level and ID number have been added to the database. <br><br>"
							+   "Please click <a href = 'Classes.jsp'> here </a> if you would like to add another Class."
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