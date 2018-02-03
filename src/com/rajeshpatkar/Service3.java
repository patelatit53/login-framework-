package com.rajeshpatkar;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Service3", urlPatterns = {"/Service3"})
public class Service3 extends HttpServlet {

    @Override
    public void service(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null)
        {
            request.setAttribute("redirect", "Service3");
            request.getRequestDispatcher("Login")
                    .forward(request, response);
        }
        else
        {
            if(session.getAttribute("username") == null)
            {
                request.setAttribute("redirect", "Service3");
                request.getRequestDispatcher("Login")
                        .forward(request, response);
            }
        }
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
            out.println("<li> This is Service3 </li>");
            out.println("</ol>");
            out.println("<a href='Welcome' style='padding:20px'> Back </a>");
            out.println("<a href='Logout' style='padding:20px'> Logout </a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}