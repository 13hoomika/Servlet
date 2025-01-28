package com.xworkz.jobhuntapp.servlet;

import com.xworkz.jobhuntapp.dto.ApplicationDto;
import com.xworkz.jobhuntapp.service.ApplicationService;
import com.xworkz.jobhuntapp.service.ApplicationServiceImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/allApplication")
public class AllApplicationServlet extends HttpServlet {
    ApplicationService service;
    public AllApplicationServlet(){
        service = new ApplicationServiceImpl();
        System.out.println("AllApplicationServlet invoked");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost started");

        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String position = req.getParameter("position");
        String experience = req.getParameter("experience");

        ApplicationDto applicationDto = new ApplicationDto();
        applicationDto.setFullName(fullName);
        applicationDto.setEmail(email);
        applicationDto.setPhone(Long.parseLong(phone));
        applicationDto.setPosition(position);
        applicationDto.setExperience(Integer.parseInt(experience));

        service.ValidateAndStore(applicationDto);

//        PrintWriter writer = resp.getWriter();
//        writer.write("Thank you "+fullName + " for applying for "+position);
//        System.out.println("doPost ended");

        req.setAttribute("name",fullName);
        req.setAttribute("pos",position);
        RequestDispatcher dispatcher = req.getRequestDispatcher("response.jsp");
        dispatcher.forward(req,resp);
    }
}
