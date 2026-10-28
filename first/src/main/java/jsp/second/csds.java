package second;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;




@WebServlet({"/c","/csds"})
public class csds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().println("Welcome");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String path = request.getServletPath();	
	
	if(path.equals("/csd"));
	
	
	try { 
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csd","root","root");
	
		int id = Integer.parseInt(request.getParameter("id"));
		  
		String name = request.getParameter("name");
		
		String query = "insert into s values(?,?)";
		      
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setInt(1, id);
		
		pst.setString(2,  name);
		
		pst.execute();
		
		response.getWriter().println("Row added");
	
	}
  } 
}