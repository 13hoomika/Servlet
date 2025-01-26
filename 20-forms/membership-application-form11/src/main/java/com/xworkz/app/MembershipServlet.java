package com.xworkz.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/applyMembership")
public class MembershipServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String membershipType = req.getParameter("membershipType");
        String startDate = req.getParameter("startDate");
        String referral = req.getParameter("referral");

        PrintWriter writer = resp.getWriter();
        writer.write(name + "Your membership is activated.");
    }
}
