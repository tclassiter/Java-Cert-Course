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


public class ClassList extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
					
				ResultSet rs = stmt.executeQuery("select * from Classes"); 
				
	            pw.println("<table border=1 width=100% height=15%>");  
	            pw.println("<tr><th>Class ID Number</th><th>Class List</th></tr>");  
	            
	            while (rs.next()) 
	            {  
	                String Level = rs.getString("CLass_Level");  
	                int Number = rs.getInt("Class_ID_Number");   
	                pw.println("<tr><td>" + Level + "</td><td>" + Number + "</td></tr>");   
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












