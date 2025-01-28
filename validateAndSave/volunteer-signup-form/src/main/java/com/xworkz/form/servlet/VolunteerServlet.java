package com.xworkz.form.servlet;

import com.xworkz.form.dto.VolunteerDto;
import com.xworkz.form.service.VolunteerService;
import com.xworkz.form.service.VolunteerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/volunteer")
public class VolunteerServlet extends HttpServlet {
    VolunteerService service;

    public VolunteerServlet() {
        service = new VolunteerServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String volunteerName = req.getParameter("volunteerName");
        String email = req.getParameter("email");
        String skills = req.getParameter("skills");
        String availability = req.getParameter("availability");
        String location = req.getParameter("location");

        VolunteerDto dto = new VolunteerDto();
        dto.setVolunteerName(volunteerName);
        dto.setEmail(email);
        dto.setSkills(skills);
        dto.setAvailability(availability);
        dto.setLocation(location);

        service.validateAndSave(dto);

        req.setAttribute("vName",volunteerName);
        RequestDispatcher dispatcher = req.getRequestDispatcher("response.jsp");
        dispatcher.forward(req,resp);

    }
}
