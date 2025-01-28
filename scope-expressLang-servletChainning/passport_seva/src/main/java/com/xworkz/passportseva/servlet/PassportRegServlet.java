package com.xworkz.passportseva.servlet;

import com.xworkz.passportseva.dto.PassportRegDto;
import com.xworkz.passportseva.service.PassportRegService;
import com.xworkz.passportseva.service.PassportRegServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/applyPassport")
public class PassportRegServlet extends HttpServlet {
    public PassportRegServlet(){
        System.out.println("PassportRegServlet cons is invoked");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String applicantName = req.getParameter("applicantName");
        String dob = req.getParameter("dob");
        String emailId = req.getParameter("emailId");
        String mobileNumber = req.getParameter("mobileNumber");
        String address = req.getParameter("address");
        String pinCode = req.getParameter("pinCode");

        PassportRegDto dto=new PassportRegDto();
        dto.setApplicantName(applicantName);
        dto.setDob(dob);
        dto.setEmailId(emailId);
        dto.setMobileNumber(Long.parseLong(mobileNumber));
        dto.setAddress(address);
        dto.setPinCode(Integer.parseInt(pinCode));

        PassportRegService passportRegService=new PassportRegServiceImpl();
        passportRegService.validateAndSave(dto);


        PrintWriter writer = resp.getWriter();
        writer.write("ThankYou "+applicantName+" for Applying");
    }
}
