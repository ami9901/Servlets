

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ResultServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.getWriter().println("<html>"
				+ "<head><title>Result Page</title></head>"
				+ "<body>"
				+ "<form>"
				+ "<input type=\"text\" name=\"en\">"
				+ "<input type=\"submit\" value=\"submit\">"
				+ "</form>"
				);
		String enostr=request.getParameter("en");
		if(enostr!=null){
		Connection con;
		try {
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ruchitesh_db","root","");
			PreparedStatement ps = con.prepareStatement("select * from results where Eno=?");
			ps.setString(1, enostr);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				response.getWriter().println("<table border=\"1\">"
						+ "<caption>BE SEMESTER 6 RESULT</caption>"
						+ "<tr>"
						+ "<td><strong>Enrollment no</strong></td>"
						+ "<td>:"+rs.getString(1)+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><strong>Name</strong></td>"
						+ "<td>:"+rs.getString(2)+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><strong>SPI</strong></td>"
						+ "<td>:"+rs.getFloat(3)+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><strong>CPI</strong></td>"
						+ "<td>:"+rs.getFloat(4)+"</td>"
						+ "</tr>"
						+ "</table>"
						
						);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
