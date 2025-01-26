package com.xworkz.amazon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/checkout")
public class CheckOutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String paymentMethod = req.getParameter("paymentMethod");
        String orderNotes = req.getParameter("orderNotes");

        PrintWriter writer = resp.getWriter();
        writer.write("Thank you for Ordering "+ name);
    }
}
