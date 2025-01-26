package com.xworkz.form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/volunteer")
public class VolunteerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String skills = req.getParameter("skills");
        String availability = req.getParameter("availability");
        String location = req.getParameter("location");

        PrintWriter writer = resp.getWriter();
        writer.write("Thank you for your volunteer "+ name);
    }
}
