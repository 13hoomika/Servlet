package com.xworkz.helthcareapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/healthCheck")
public class HealthCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fullName = req.getParameter("fullName");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String[] symptoms = req.getParameterValues("symptoms"); // Retrieve multiple checkboxes
        String existingConditions = req.getParameter("existingConditions");
        String travel = req.getParameter("travel");

        PrintWriter writer = resp.getWriter();
        writer.write("Your response has been received by our Hospital. Thank you!");
    }
}
