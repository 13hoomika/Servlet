package com.xworkz.survey.servlet;

import com.xworkz.survey.dto.SurveyDto;
import com.xworkz.survey.service.SurveyService;
import com.xworkz.survey.service.SurveyServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/survey")
public class SurveyServlet extends HttpServlet {
    SurveyService service;
    public SurveyServlet() {
        service = new SurveyServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String feedback = req.getParameter("feedback");

        SurveyDto dto = new SurveyDto();
        dto.setName(name);
        dto.setAge(Integer.parseInt(age));
        dto.setGender(gender);
        dto.setFeedback(feedback);
        dto.setEmail(email);

        service.validateAnsSave(dto);

//        PrintWriter writer = resp.getWriter();
//        writer.write("Thank you for your response "+ name);

        req.setAttribute("name",name);
        RequestDispatcher dispatcher = req.getRequestDispatcher("response.jsp");
        dispatcher.forward(req,resp);
    }
}
