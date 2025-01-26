package com.xworkz.contactus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/contact")
public class ContactUsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String category = req.getParameter("category");
        String phone = req.getParameter("phone");
        String message = req.getParameter("message");

        Long ph = Long.parseLong(phone);
        PrintWriter writer = resp.getWriter();
        writer.write("thank you for contacting "+ name);
    }
}
