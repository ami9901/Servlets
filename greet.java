import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class greet extends HttpServlet
{
	public void init() throws ServletException {
      // Do required initialization
      String message = "Hello World"; }
		
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        
        // Get last access time of this web page.
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        response.setContentType("text/html");
        String str1=request.getParameter("first_name");
        String str2=request.getParameter("last_name");
        GregorianCalendar time = new GregorianCalendar();
        int hour = time.get(Calendar.HOUR_OF_DAY);
        int min = time.get(Calendar.MINUTE);
        java.util.Date date = new java.util.Date();
        PrintWriter out = response.getWriter();
        out.println("Time of Last Access:"+ lastAccessTime);
        out.println("<h2>"+"Current Date & Time: " +date.toString()+"</h2>");
        if (hour < 12)
            out.println(str1+" "+ str2+" "+"Good Morning!");
        else if (hour < 17 && !(hour == 12))
            out.println(str1+" "+str2+" "+"Good Afternoon");
        else if (hour == 12)
            out.println(str1+" "+str2+" "+"Good Noon");
        else
            out.println(str1+" "+str2+" "+"Good Evening");
    }
}
