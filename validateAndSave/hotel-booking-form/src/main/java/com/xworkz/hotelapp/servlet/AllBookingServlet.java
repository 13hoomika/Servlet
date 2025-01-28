package com.xworkz.hotelapp.servlet;

import com.xworkz.hotelapp.dto.BookingDto;
import com.xworkz.hotelapp.service.BookingService;
import com.xworkz.hotelapp.service.BookingServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/allBookings")
public class AllBookingServlet extends HttpServlet {
    BookingService service;
    public AllBookingServlet() {
        service = new BookingServiceImpl();
        System.out.println("AllBookingServlet invoked");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost started");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String checkInDate = req.getParameter("checkInDate");
        String checkOutDate = req.getParameter("checkOutDate");
        String roomCount = req.getParameter("roomCount");

        BookingDto dto = new BookingDto();
        dto.setName(name);
        dto.setEmail(email);
        dto.setCheckInDate(checkInDate);
        dto.setCheckOutDate(checkOutDate);
        dto.setRoomCount(Integer.parseInt(roomCount));

        service.ValidateAndSave(dto);

//        PrintWriter writer = resp.getWriter();
//        writer.write("We have sent Room details to " + email);
//        System.out.println("doPost ended");

        req.setAttribute("emailId",email);
        RequestDispatcher dispatcher = req.getRequestDispatcher("response.jsp");
        dispatcher.forward(req,resp);
    }
}
