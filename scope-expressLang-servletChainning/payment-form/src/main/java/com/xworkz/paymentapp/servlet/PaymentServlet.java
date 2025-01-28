package com.xworkz.paymentapp.servlet;

import com.xworkz.paymentapp.dto.PaymentDto;
import com.xworkz.paymentapp.entity.PaymentEntity;
import com.xworkz.paymentapp.service.PaymentService;
import com.xworkz.paymentapp.service.PaymentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/payment")
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String cardNumber = req.getParameter("cardNumber");
        String expiryDate = req.getParameter("expiryDate");
        String amount = req.getParameter("amount");
        String cvv = req.getParameter("cvv");

        PaymentDto dto = new PaymentDto();
        dto.setName(name);
        dto.setCardNumber(cardNumber);
        dto.setExpiryDate(expiryDate);
        dto.setAmount(Double.valueOf(amount));
        dto.setCvv(cvv);

        PaymentService service = new PaymentServiceImpl();
        service.validateAndSave(dto);

//        Double amt = Double.parseDouble(amount);
//        PrintWriter writer = resp.getWriter();
//        writer.write("Payment made through card holder " + name);

        req.setAttribute("hodlerName",name);
        RequestDispatcher dispatcher = req.getRequestDispatcher("response.jsp");
        dispatcher.forward(req,resp);
    }
}
