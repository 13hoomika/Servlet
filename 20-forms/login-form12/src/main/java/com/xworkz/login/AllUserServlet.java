package com.xworkz.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class AllUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String securityCode = req.getParameter("securityCode");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        Long phno = Long.parseLong(phone);
        PrintWriter writer = resp.getWriter();
        writer.write(username + " LogIn Successful");
    }
}
