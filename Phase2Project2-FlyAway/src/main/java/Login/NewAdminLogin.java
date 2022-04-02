package Login;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NewAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

        
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//JDBC Driver, URL and Credentials
		String URL = "jdbc:mysql://localhost:3306/Phase2Project2";
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
					
			String NewUserName = request.getParameter("NewUserName");
			String NewPassWord = request.getParameter("NewPassWord");
		 
					
			String submit = "INSERT INTO AdminLogin " + "VALUES ('"+NewUserName+"','"+NewPassWord+"')";
			stmt.executeUpdate(submit);
					
		 
			pw1.println("<html>"
					+ 	"<style>"
					+ 	"body {"
					+ 	"background-image: URL('AdminLogin.jpg');" 
					+ 	"background-repeat: no-repeat;"
					+ 	"background-size: cover;}"
					+ 	"</style>"
					+   "<body>"
					+   "<br><br><br>"
					+	"<center>Your account has been created or updated. <br><br>"
					+	"Please click <a href = 'AdminLogin.jsp'> here </a> to return to the administrator login page."
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