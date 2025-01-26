package com.xworkz.form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/order")
public class ProductOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("productName");
        String quantity = req.getParameter("quantity");
        String customerName = req.getParameter("customerName");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");

        int qnty = Integer.parseInt(quantity);
        long phno = Long.parseLong(phone);
        PrintWriter writer = resp.getWriter();
        writer.write("Order for "+productName + " is placed, "+ "Thank you for ordering " + customerName);
    }
}
