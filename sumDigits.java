
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class sumDigits extends HttpServlet {
	int sum = 0; 
	
	public void init() throws ServletException {
      // Do required initialization
      String message = "Hello World"; }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
        try {

            /* TODO output your page here. You may use following sample code.*/

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Sum of Digits</title>");            
            out.println("<form name=frm2 method=post >");
            out.println("");
            out.println("Enter a number:" + "<input type=text name=n1txt /> <br/>");
            out.println("<input type=submit name=submit value=sum />");
            out.println("");
            out.println("</form>");
            out.println("</html>");

            if(request.getParameter("submit")!=null)
            {
                int d1 = Integer.parseInt(request.getParameter("n1txt"));
				
				while (d1 != 0) 
				{ 
				 sum = sum + d1 % 10; 
				 d1 = d1/10; 
				} 
				out.println("Sum of digits: "+ sum);
			}  
		}
        catch(Exception e1)
        {
			out.println("Exception Caught!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
 
}
 