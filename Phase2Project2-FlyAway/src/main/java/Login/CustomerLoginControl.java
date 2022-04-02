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
	String DBURL = "jdbc:mysql://localhost:3306/Phase2Project2";
	String DBUserName = "root";
	String DBPassWord = "123";
	String JSPUserName = request.getParameter("UserName");
	String JSPPassWord = request.getParameter("PassWord");

				
		//Establishing database connection, passing query statement, and creating while iterative loop.
		try{
	
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(DBURL,DBUserName,DBPassWord);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CustomerLogin");
			

			while(rs.next() ) {
				
				String DBCustomerUserName = rs.getString("UserName");
				String DBCustomerPassWord = rs.getString("PassWord");
			

				if((JSPUserName.equalsIgnoreCase(DBCustomerUserName)) && (JSPPassWord.equalsIgnoreCase(DBCustomerPassWord))) {
	            	        	
					HttpSession session = request.getSession();
					session.setAttribute("DBCustomerUserName", DBCustomerUserName);
					session.setAttribute("DBCustomerPassWord", DBCustomerPassWord);
					response.sendRedirect("CustomerPortal.jsp");
			    	}
				
				else {
					RequestDispatcher rd = request.getRequestDispatcher("InvalidLogin.jsp");
					rd.include(request, response);
					}	
					}
					}
		
				catch(Exception e) {
				e.printStackTrace();
				} 
}
}












