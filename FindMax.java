
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FindMax extends HttpServlet {
	
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
            out.println("<title>Servlet FindMax</title>");            
            out.println("<form name=frm1 method=post >");
            out.println("");
            out.println("Enter no. 1:" + "<input type=text name=n1txt /> <br/>");
            out.println("Enter no. 2:" + "<input type=text name=n2txt /><br/>");
            out.println("<input type=submit name=submit value=Find Maximum />");
            out.println("");
            out.println("</form>");
            out.println("</html>");

            if(request.getParameter("submit")!=null)
            {
                double d1 = Double.parseDouble(request.getParameter("n1txt"));
                double d2 = Double.parseDouble(request.getParameter("n2txt"));

                if(d1>d2)
                {
                    out.println("The maximum number is :"+d1);
                }
                else
                {
                    out.println("The maximum number is :"+d2);

                }
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
 