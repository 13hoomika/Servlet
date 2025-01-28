package com.xworkz.feedbackapplication.servlet;

import com.xworkz.feedbackapplication.dto.FeedbackDto;
import com.xworkz.feedbackapplication.service.FeedbackService;
import com.xworkz.feedbackapplication.service.FeedbackServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/feedbackResponse")
public class FeedbackResponseServlet extends HttpServlet {
    FeedbackService service;
    public FeedbackResponseServlet() {
        service = new FeedbackServiceImpl();
        System.out.println("FeedbackResponseServlet invoked");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String feedback = req.getParameter("feedback");

        FeedbackDto dto = new FeedbackDto();
        dto.setName(name);
        dto.setEmail(email);
        dto.setFeedback(feedback);

        service.validateAndSave(dto);

//        PrintWriter writer = resp.getWriter();
//        writer.write("Thank you for your feedback " + name);

        req.setAttribute("fullName",name);
        RequestDispatcher dispatcher = req.getRequestDispatcher("response.jsp");
        dispatcher.forward(req,resp);
    }
}
