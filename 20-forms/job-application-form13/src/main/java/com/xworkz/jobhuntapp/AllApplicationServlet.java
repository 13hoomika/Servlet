package com.xworkz.jobhuntapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/allApplication")
public class AllApplicationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String position = req.getParameter("position");
        String experience = req.getParameter("experience");

        Long phoneNumber = Long.parseLong(phone);
        PrintWriter writer = resp.getWriter();
        writer.write("Thank you "+name + " for applying for "+position);

    }
}
