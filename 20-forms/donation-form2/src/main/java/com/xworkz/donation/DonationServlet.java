package com.xworkz.donation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/donate")
public class DonationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String donationType = req.getParameter("donationType");
        String amount = req.getParameter("amount");
        String message = req.getParameter("message");

        Double amt = Double.parseDouble(amount);
        PrintWriter writer = resp.getWriter();
        writer.write("thank you for your donation D"+ name);
    }
}
