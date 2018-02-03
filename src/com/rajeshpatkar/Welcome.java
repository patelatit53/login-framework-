package com.rajeshpatkar;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Welcome", urlPatterns = {"/Welcome"})
public class Welcome extends HttpServlet {

    @Override
    public void service(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Welcome</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Welcome to RPISE " 
                        +session.getAttribute("username")+
                        "</h2>");
            out.println("<ol>");
            for(int i=1; i<=5; i++){
                out.println("<li>"+ "<a href='Service"+ i + "'>" + 
                                            ("Service" + i) + 
                                     "</a>"+ "</li>");
            }
            out.println("</ol>");
            out.println("<a href='Logout'>Logout</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
