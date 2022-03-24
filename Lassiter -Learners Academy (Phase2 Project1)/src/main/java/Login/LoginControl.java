package Login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

 
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		String user = request.getParameter("Username");
		String password = request.getParameter("Password");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		if (user.equalsIgnoreCase("admin") && password.equalsIgnoreCase("pass")) {
			HttpSession hs = request.getSession();
			hs.setAttribute("uname", user);
			response.sendRedirect("AdminTasks.jsp");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("InvalidLogin.jsp");
			rd.include(request, response);
		}
		out.close();		
}
}
