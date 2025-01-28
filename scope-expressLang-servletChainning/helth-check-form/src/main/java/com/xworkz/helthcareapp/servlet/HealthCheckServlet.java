package com.xworkz.helthcareapp.servlet;

import com.xworkz.helthcareapp.dto.PatientDto;
import com.xworkz.helthcareapp.service.PatientService;
import com.xworkz.helthcareapp.service.PatientserviceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(urlPatterns = "/healthCheck")
public class HealthCheckServlet extends HttpServlet {
    PatientService service ;
    public HealthCheckServlet() {
        service = new PatientserviceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fullName = req.getParameter("fullName");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String[] symptoms = req.getParameterValues("symptoms"); // Retrieve multiple checkboxes
        String existingConditions = req.getParameter("existingConditions");
        String travel = req.getParameter("travel");

        PatientDto dto = new PatientDto();
        dto.setFullName(fullName);
        dto.setAge(age);
        dto.setGender(gender);
        dto.setSymptoms(Arrays.toString(symptoms));
        dto.setTravel(travel);
        dto.setExistingConditions(existingConditions);

        service.validateAndSave(dto);

        req.setAttribute("name",fullName);
        RequestDispatcher dispatcher = req.getRequestDispatcher("response.jsp");
        dispatcher.forward(req,resp);

//        service.validateAndSave(dto);
//        PrintWriter writer = resp.getWriter();
//        writer.write("Your response has been received by our Hospital. Thank you!");
    }
}
