package com.xworkz.thonosevents;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/allEvents")
public class AllEventsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String eventName = req.getParameter("eventName");
        String ticketType = req.getParameter("ticketType");
        String attendees = req.getParameter("attendees");

        Integer attendeesCount = Integer.parseInt(attendees);
        PrintWriter writer = resp.getWriter();
        writer.write("Check "+ email + " for details");
    }
}
