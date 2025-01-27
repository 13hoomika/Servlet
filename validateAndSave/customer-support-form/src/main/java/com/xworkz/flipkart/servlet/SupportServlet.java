package com.xworkz.flipkart.servlet;

import com.xworkz.flipkart.dto.SupportDto;
import com.xworkz.flipkart.service.SupportService;
import com.xworkz.flipkart.service.SupportServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/support")
public class SupportServlet extends HttpServlet {
    SupportService service;
    public SupportServlet() {
        service = new SupportServiceImpl();
        System.out.println("SupportServlet invoked");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String orderId = req.getParameter("orderId");
        String issueType = req.getParameter("issueType");
        String description = req.getParameter("description");

        SupportDto dto = new SupportDto();
        dto.setName(name);
        dto.setEmail(email);
        dto.setOrderId(Integer.parseInt(orderId));
        dto.setIssueType(issueType);
        dto.setDescription(description);

        service.validateAndSave(dto);

        PrintWriter writer = resp.getWriter();
        writer.write( "Issue for order id "+ orderId +" is received we will get back to you soon");
    }
}
