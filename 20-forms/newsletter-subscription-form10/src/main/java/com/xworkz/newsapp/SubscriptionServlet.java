package com.xworkz.newsapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/subscribe")
public class SubscriptionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String interests = req.getParameter("interests");
        String country = req.getParameter("country");
        String frequency = req.getParameter("frequency");

        PrintWriter writer = resp.getWriter();
        writer.write("Subscribed to "+ name + "'s news letter");
    }
}
