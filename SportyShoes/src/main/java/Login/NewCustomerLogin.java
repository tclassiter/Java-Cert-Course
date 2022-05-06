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
		String URL = "jdbc:mysql://localhost:3306/SportyShoes";
		String DBUserName = "root";
		String DBPassWord = "123";
		
		//Response content type
		response.setContentType("text/html");
	    PrintWriter pw1= response.getWriter();
				
		//Trying to establish database connection and retrieve JSP parameter values
		try{
					
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,DBUserName,DBPassWord);
			Statement stmt = con.createStatement();
			
			//Retrieving JSP parameter values
			String JSPCustomerFirstName = request.getParameter("CustomerFirstName");
			String JSPCustomerLastName = request.getParameter("CustomerLastName");
			String JSPCustomerUserName = request.getParameter("NewUserName");
			String JSPCustomerPassWord = request.getParameter("NewPassWord");
			
			//Inserting JSP parameter values into database
			String submit = "INSERT INTO CustomerInformation (CustomerFirstName,CustomerLastName,CustomerUserName,CustomerPassWord) "
							+ "VALUES ('"+JSPCustomerFirstName+"','"+JSPCustomerLastName+"','"+JSPCustomerUserName+"','"+JSPCustomerPassWord+"')";
			stmt.executeUpdate(submit);
					
			//PrintWriter method to print HTML
			pw1.println("<html>"
					+   "<body>"
					+   "<style>"
					+   "body {"
					+   "background-image: URL('Customer.jpg');"
					+   "background-repeat: no-repeat;"
					+   "input[type=submit], select {"
					+	"width: 15%;"
					+	"padding: 12px 20px;"
					+	"margin: 50px 725px;"
					+	"border: 1px solid #ccc;"
					+	"cursor: pointer;}"
					+   "</style>"
					
					+   "<br><br><br><br><br><br><br><br><br><br><br><br><br>"
					+	"<h1><center><font color = 'white'>Your login has been updated.</font></h1>"
					+	"<h1><center><font color = 'white'>Please select the button below to return to the login page.</font></h1><br>"			
					+   "<form action = CustomerLogin.jsp align = center>"
					+   "<input type = submit value = 'Return to Login Page!' style = 'background-color: #00cc99';>"
					+	"</body>"
					+	"</html>");
					    
			stmt.close();
			con.close();
}			   
//Exception if database connection fails
catch(Exception e) {
e.printStackTrace();
}
}
}