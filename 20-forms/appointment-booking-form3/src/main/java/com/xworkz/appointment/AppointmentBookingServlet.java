package com.xworkz.appointment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/book")
public class AppointmentBookingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String appointmentDate = req.getParameter("appointmentDate");
        String message = req.getParameter("message");

        PrintWriter writer = resp.getWriter();
        writer.write(name+" Appointment booked on "+ appointmentDate);
    }
}
