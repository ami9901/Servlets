import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class Uppercase extends HttpServlet {

public void init() throws ServletException {
      // Do required initialization
      String message = "Hello World"; }
    // Method to handle GET method request.
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String s=request.getParameter("uppercase");
        String result=s.toUpperCase();
        out.println(result);


    }
}

