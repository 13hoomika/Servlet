package com.xworkz.form;

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

        long ph = Long.parseLong(phone);
        int guest = Integer.parseInt(guestCount);
        PrintWriter writer = resp.getWriter();
        writer.write("Reservation Confirmed for "+ name);
    }
}
