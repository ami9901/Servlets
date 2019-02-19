

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ImageServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    public ImageServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.getWriter().println("<!DOCTYPE html>"
			+ "<html>"
			+ "<head>"
			+ "<meta charset=\"ISO-8859-1\">"
			+ "<title>Image Page</title>"
			+ "</head>"
			+ "<body>"
			+ "<form action=\"image\" method=\"get\">"
			+ "<input type=\"text\" name=\"imgname\">"
			+ "<input type=\"submit\" value=\"submit\">"
			+ "</form><br/>");
			
			
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ruchitesh_db","root","");
			System.out.println(con);
			PreparedStatement ps=con.prepareStatement("select image from images where name=?");
			ps.setString(1, request.getParameter("imgname"));
			ResultSet rs = ps.executeQuery();
			response.setContentType("text/html");
			Blob image=null;
			 byte[ ] imgData = null ; 
			while(rs.next()){
				image = rs.getBlob(1);
			    imgData = image.getBytes(1,(int)image.length());
			}
			String imgDataBase64=new String(Base64.getEncoder().encode(imgData));
			PrintWriter pw = response.getWriter();
			pw.println(
					"<img src=\"data:image/gif;base64,"+imgDataBase64 + "\"/>"
					+ "</body>"
					+ "</html>"				
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
