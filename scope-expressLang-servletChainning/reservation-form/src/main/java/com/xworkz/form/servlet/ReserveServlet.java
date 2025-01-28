package com.xworkz.form.servlet;

import com.xworkz.form.dto.ReservationDto;
import com.xworkz.form.service.ReservationService;
import com.xworkz.form.service.ReservationServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/reserve")
public class ReserveServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String reservationDate = req.getParameter("reservationDate");
        String guestCount = req.getParameter("guestCount");

        ReservationDto dto = new ReservationDto();
        dto.setName(name);
        dto.setEmail(email);
        dto.setPhone(Long.parseLong(phone));
        dto.setReservationDate(reservationDate);
        dto.setGuestCount(Integer.parseInt(guestCount));

        ReservationService service = new ReservationServiceImpl();
        service.validateAndSave(dto);

        req.setAttribute("name",name);
        RequestDispatcher dispatcher = req.getRequestDispatcher("response.jsp");
        dispatcher.forward(req,resp);
    }
}
