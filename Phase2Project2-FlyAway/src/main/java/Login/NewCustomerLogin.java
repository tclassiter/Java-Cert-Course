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

public class NewCustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

        
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//JDBC Driver, URL and Credentials
		String URL = "jdbc:mysql://localhost:3306/Phase2Project2";
		String DBUserName = "root";
		String DBPassWord = "123";
		String JSPCustomerUserName = request.getParameter("NewUserName");
		String JSPCustomerPassWord = request.getParameter("NewPassWord");
		
		//Response content type
		response.setContentType("text/html");
	    PrintWriter pw1= response.getWriter();
				

		//Trying to establish database connection and pass parameters from JSPs.
		try{
					
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,DBUserName,DBPassWord);
			Statement stmt = con.createStatement();
		
			String submit = "INSERT INTO CustomerLogin " + "VALUES ('"+JSPCustomerUserName+"','"+JSPCustomerPassWord+"')";
			stmt.executeUpdate(submit);
					
		 
			pw1.println("<html>"
					+   "<body>"
					+   "<style>"
					+   "body {"
					+   "background-image: URL('Portal.jpg');"
					+   "background-repeat: no-repeat;"
					+   "background-size: cover; }"
					+   "</style>"
					+   "<br><br><br><br>"
					+	"<font color = 'white'><center>Your login has been updated.</font><br><br>"
					+	"<font color = 'white'>Please click <a href = 'CustomerLogin.jsp'> here </a> to return to the customer login page</font>."
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