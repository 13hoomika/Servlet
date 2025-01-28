package com.xworkz.donation.servlet;

import com.xworkz.donation.dto.DonationDto;
import com.xworkz.donation.service.DonationService;
import com.xworkz.donation.service.DonationServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/donate")
public class DonationServlet extends HttpServlet {
    DonationService service = new DonationServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String donationType = req.getParameter("donationType");
        String amount = req.getParameter("amount");
        String message = req.getParameter("message");

        DonationDto dto = new DonationDto();
        dto.setName(name);
        dto.setEmail(email);
        dto.setDonationType(donationType);
        dto.setMessage(message);
        dto.setAmount(Double.valueOf(amount));
        service.validateAndSave(dto);

        req.setAttribute("donnerName",name);
        RequestDispatcher dispatcher = req.getRequestDispatcher("response.jsp");
        dispatcher.forward(req,resp);
    }
}
