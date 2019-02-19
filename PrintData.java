import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class PrintData extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        PrintWriter out=response.getWriter();

                        response.setContentType("text/html");

                        out.println("<table border=1>");

                        out.println("<tr><td>Client's IP Address</td>");

                        out.println("<td>"+request.getRemoteAddr()+"</td></tr>");

                        out.println("<tr><td>Server Port Number</td>");

                        out.println("<td>"+request.getServerPort()+"</td></tr>");

                        out.println("<tr><td>Method Used By Client</td>");

                        out.println("<td>"+request.getMethod()+"</td></tr>");

                        out.println("<tr><td>Client Port</td>");

                        out.println("<td>"+request.getRemotePort()+"</td></tr>");

                        out.println("<tr><td>QueryString</td>");

                        out.println("<td>"+request.getQueryString()+"</td></tr>");

                        out.println("<tr><td>Local Port</td>");

                        out.println("<td>"+request.getLocalPort()+"</td></tr>");

                        out.println("<tr><td>Client's Browser</td>");

                        out.println("<td>"+request.getHeader("user-agent")+"</td></tr>");

                        out.println("</table>");

            }


    }
