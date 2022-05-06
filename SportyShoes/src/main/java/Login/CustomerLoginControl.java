package Login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class CustomerLoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
        
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//Database access information and CustomerLogin.jsp parameter requests	
	String DBURL = "jdbc:mysql://localhost:3306/SportyShoes";
	String DBUserName = "root";
	String DBPassWord = "123";
	String JSPUserName = request.getParameter("UserName");
	String JSPPassWord = request.getParameter("PassWord");
			
		//Establishing database connection, passing database statement.
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBURL,DBUserName,DBPassWord);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT CustomerUserName,CustomerPassWord FROM CustomerInformation");
			
			//Iterative while loop that retrieves data from SQL database and tests it against JSP and ResultSet values
			while(rs.next() ) {
				
				String DBCustomerUserName = rs.getString("CustomerUserName");
				String DBCustomerPassWord = rs.getString("CustomerPassWord");

				//Start of if/else if algorithm that tests user input against database information
				if((JSPUserName.equalsIgnoreCase(DBCustomerUserName)) && (JSPPassWord.equalsIgnoreCase(DBCustomerPassWord))) {
	            	        	
					HttpSession session = request.getSession();
					session.setAttribute("DBCustomerUserName", DBCustomerUserName);
					session.setAttribute("DBCustomerPassWord", DBCustomerPassWord);
					response.sendRedirect("CustomerPortal.jsp");
			    	}
				
				//Second part of If/Else If algorithm
				else if ((!JSPUserName.equalsIgnoreCase(DBCustomerUserName)) && (!JSPPassWord.equals(DBCustomerPassWord))){
					
					RequestDispatcher rd = request.getRequestDispatcher("InvalidCustomerLogin.jsp");
					rd.include(request, response);				
					}	
				
				//Terminal part of If/Else If algorithm
				else if (rs.wasNull()) {
					
					RequestDispatcher rd = request.getRequestDispatcher("InvalidCustomerLogin.jsp");
					rd.include(request, response);
					}
					}
					}
		
//Exception if database connection fails
catch(Exception e) {
e.printStackTrace();
} 
}
}











