package com.xworkz.amazon.servlet;

import com.xworkz.amazon.dto.CheckoutDto;
import com.xworkz.amazon.service.CheckoutService;
import com.xworkz.amazon.service.CheckoutServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/checkout")
public class CheckOutServlet extends HttpServlet {
    CheckoutService checkoutService;
    public CheckOutServlet() {
        checkoutService = new CheckoutServiceImpl();
        System.out.println("CheckOutServlet invoked");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String paymentMethod = req.getParameter("paymentMethod");
        String orderNotes = req.getParameter("orderNotes");

        CheckoutDto checkoutDto = new CheckoutDto();
        checkoutDto.setFullName(fullName);
        checkoutDto.setEmail(email);
        checkoutDto.setAddress(address);
        checkoutDto.setPaymentMethod(paymentMethod);
        checkoutDto.setOrderNotes(orderNotes);

        checkoutService.validateAndStore(checkoutDto);
        PrintWriter writer = resp.getWriter();
        writer.write(fullName + ", your order has been confirmed.");
    }
}
