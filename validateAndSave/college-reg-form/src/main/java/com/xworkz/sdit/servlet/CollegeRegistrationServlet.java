package com.xworkz.sdit.servlet;

import com.xworkz.sdit.dto.RegisterDto;
import com.xworkz.sdit.service.RegisterService;
import com.xworkz.sdit.service.RegisterServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/CollegeRegistration")
public class CollegeRegistrationServlet extends HttpServlet {

    public CollegeRegistrationServlet(){
        System.out.println("RegisterServlet constructor is invoked");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost method invoked");
        String fullName=req.getParameter("fullName");
        String emailId=req.getParameter("emailId");
        String usn=req.getParameter("usn");
        String contactNumber=req.getParameter("contactNumber");
        String qualification=req.getParameter("qualification");
        String yearOfpass=req.getParameter("yearOfpass");

        RegisterDto dto=new RegisterDto();
        dto.setFullName(fullName);
        dto.setEmailId(emailId);
        dto.setUsn(usn);
        dto.setQualification(qualification);
        dto.setContactNumber(Long.parseLong(contactNumber));
        dto.setYearOfpass(Integer.parseInt(yearOfpass));

        RegisterService registerService =new RegisterServiceImpl();
        registerService.validateAndSave(dto);

//        PrintWriter writer = resp.getWriter();
//        writer.write("Thank You "+fullName+ " for Registering to SDIT");
//        System.out.println("doPost method ended");

        req.setAttribute("fName",fullName);
        RequestDispatcher dispatcher = req.getRequestDispatcher("response.jsp");
        dispatcher.forward(req,resp);
    }




}
