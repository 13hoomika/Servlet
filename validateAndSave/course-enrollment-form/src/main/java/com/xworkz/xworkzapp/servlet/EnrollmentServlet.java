package com.xworkz.xworkzapp.servlet;

import com.xworkz.xworkzapp.dto.EnrollmentDto;
import com.xworkz.xworkzapp.service.EnrollmentService;
import com.xworkz.xworkzapp.service.EnrollmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/enrollments")
public class EnrollmentServlet extends HttpServlet {
    EnrollmentService service;
    public EnrollmentServlet() {
        service = new EnrollmentServiceImpl();
        System.out.println("EnrollmentServlet invoked");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost method called");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String courseName = req.getParameter("courseName");
        String startDate = req.getParameter("startDate");
        String comments = req.getParameter("comments");

        EnrollmentDto dto = new EnrollmentDto();
        dto.setName(name);
        dto.setEmail(email);
        dto.setCourseName(courseName);
        dto.setStartDate(startDate);
        dto.setComments(comments);

        service.validateAndPersist(dto);

        PrintWriter writer = resp.getWriter();
        writer.write("Course enrolled for "+ courseName);
    }
}
