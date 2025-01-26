package com.xworkz.paymentapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/payment")
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String cardNumber = req.getParameter("cardNumber");
        String expiryDate = req.getParameter("expiryDate");
        String amount = req.getParameter("amount");
        String cvv = req.getParameter("cvv");

        Double amt = Double.parseDouble(amount);
        PrintWriter writer = resp.getWriter();
        writer.write("Payment made through card holder " + name);
    }
}
