package com.xworkz.xworkzapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/enrollments")
public class EnrollmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String courseName = req.getParameter("courseName");
        String startDate = req.getParameter("startDate");
        String comments = req.getParameter("comments");

        PrintWriter writer = resp.getWriter();
        writer.write("Course enrolled for "+ courseName);
    }
}
