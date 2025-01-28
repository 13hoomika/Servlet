package com.xworkz.thonosevents.servlet;

import com.xworkz.thonosevents.dto.EventDto;
import com.xworkz.thonosevents.service.EventService;
import com.xworkz.thonosevents.service.EventServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/allEvents")
public class AllEventsServlet extends HttpServlet {
    EventService service;
    public AllEventsServlet() {
        service = new EventServiceImpl();
        System.out.println("AllEventsServlet invoked");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String eventName = req.getParameter("eventName");
        String ticketType = req.getParameter("ticketType");
        String attendees = req.getParameter("attendees");

        EventDto dto = new EventDto();
        dto.setFullName(fullName);
        dto.setEmail(email);
        dto.setTicketType(ticketType);
        dto.setEventName(eventName);
        dto.setAttendees(Integer.parseInt(attendees));

        service.validateAndSave(dto);

//        PrintWriter writer = resp.getWriter();
//        writer.write("Check "+ email + " for details");

        req.setAttribute("emailId",email);
        RequestDispatcher dispatcher = req.getRequestDispatcher("response.jsp");
        dispatcher.forward(req,resp);
    }
}
