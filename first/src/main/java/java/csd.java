package java;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/csd")
urlPatterns = { "/csd" }, 
initParams = { 
		@WebInitParam(name = "username", value = "root"), 
		@WebInitParam(name = "password", value = "suhi@555")
})

public class csd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public csd() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig sc = getServletConfig();
		String user = (String) sc.getInitParameter("username");
		String pass = (String) sc.getInitParameter("password");
		
		String path = request.getServletPath();
		
		if(path.equals("/regs")) {
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/New");
				
				int id = Integer.parseInt(request.getParameter("ids"));
				
				String name = request.getParameter("names");
				
				String query = "insert into s values(?,?)";
				
				PreparedStatement pst = con.prepareStatement(query);
				
				pst.setInt(1,  id);
				
				pst.setString(2, name);
				
				int row = pst.executeUpdate();
				
				if(row>=1) {
					 
					RequestDispatcher rd = request.getRequestDispatcher("New.html");
				}
			}
			catch(Exception e) {
		          e.printStackTrace();
			}

	}
    
		else if(path.equals("/New"))
	}
