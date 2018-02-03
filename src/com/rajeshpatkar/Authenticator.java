package com.rajeshpatkar;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Authenticator", urlPatterns = {"/Authenticator"})
public class Authenticator extends HttpServlet {

    @Override
    public void service(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        if (session == null) {
            request.getRequestDispatcher("Login").
                    forward(request, response);
        } else {
            if (session.getAttribute("username") != null) {
                request.getRequestDispatcher("Welcome").
                        forward(request, response);
            } else {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                if ( username != null && password !=null  && 
                     username.equals("tom") && password.equals("cat")) {
                    session.setAttribute("username", username);
                    String redirect =(String) session.
                    getAttribute("redirect");
                    if(redirect != null )
                    {
                        session.removeAttribute("redirect");
                        request.getRequestDispatcher(redirect).
                                forward(request,response);
                    }
                    else
                    {
                     request.getRequestDispatcher("Welcome").
                            forward(request, response);
                    }
                } else {
                    request.getRequestDispatcher("Login").
                            forward(request, response);
                }
            }
        }
    }
}
