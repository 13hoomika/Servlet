package com.xworkz.app.servlet;

import com.xworkz.app.dto.MembersDto;
import com.xworkz.app.service.MembersService;
import com.xworkz.app.service.MembersServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/applyMembership")
public class MembershipServlet extends HttpServlet {
    MembersService membersService;

    public MembershipServlet() {
        membersService = new MembersServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String membershipType = req.getParameter("membershipType");
        String startDate = req.getParameter("startDate");
        String referral = req.getParameter("referral");

        MembersDto dto = new MembersDto();
        dto.setName(name);
        dto.setEmail(email);
        dto.setMembershipType(membershipType);
        dto.setStartDate(startDate);
        dto.setReferral(referral);

        membersService.ValidateAndSave(dto);

//        PrintWriter writer = resp.getWriter();
//        writer.write(name + "Your membership is activated.");

        req.setAttribute("memberName",name);
        RequestDispatcher dispatcher = req.getRequestDispatcher("response.jsp");
        dispatcher.forward(req,resp);
    }
}
