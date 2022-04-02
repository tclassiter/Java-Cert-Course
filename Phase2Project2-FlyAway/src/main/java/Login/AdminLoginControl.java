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


public class AdminLoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
        
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String URL = "jdbc:mysql://localhost:3306/Phase2Project2";
	String DBUserName = "root";
	String DBPassWord = "123";
	String JSPUserName = request.getParameter("UserName");
	String JSPPassWord = request.getParameter("PassWord");
	
				
		//Trying to establish database connection and pass parameters from JSPs.
		try{
					
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(URL,DBUserName,DBPassWord);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from AdminLogin"); 
			
	  
	        while(rs.next() ) {
	        	
	        	String AdminUserName = rs.getString("UserName");  
	   	        String AdminPassWord = rs.getString("PassWord");
	   	        
	        
	            if ((JSPUserName.equalsIgnoreCase(AdminUserName)) && (JSPPassWord.equalsIgnoreCase(AdminPassWord))) {
	            	
	            	HttpSession session = request.getSession();
					session.setAttribute("UserName", AdminUserName);
					session.setAttribute("PassWord", AdminPassWord);
					response.sendRedirect("AdminPortal.jsp");
					}
	            
	            else{
				
					RequestDispatcher rd = request.getRequestDispatcher("InvalidAdminLogin.jsp");
					rd.include(request, response);
					}	
					}
					}
		
				catch(Exception e) {
				e.printStackTrace();
				} 
}
}











