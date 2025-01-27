package com.xworkz.newsapp.servlet;

import com.xworkz.newsapp.dto.SubscriberDto;
import com.xworkz.newsapp.service.SubscribersService;
import com.xworkz.newsapp.service.SubscribersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/subscribe")
public class SubscriptionServlet extends HttpServlet {
    SubscribersService subscribersService;
    public SubscriptionServlet() {
        subscribersService = new SubscribersServiceImpl();
        System.out.println("SubscriptionServlet invoked");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost method started");
        String fullName = req.getParameter("fullName");
        String emailId = req.getParameter("emailId");
        String interests = req.getParameter("interests");
        String country = req.getParameter("country");
        String frequency = req.getParameter("frequency");

        SubscriberDto subscriberDto = new SubscriberDto();
        subscriberDto.setFullName(fullName);
        subscriberDto.setEmailId(emailId);
        subscriberDto.setInterests(interests);
        subscriberDto.setFrequency(frequency);
        subscriberDto.setCountry(country);


        subscribersService.ValidateAndSave(subscriberDto);

        PrintWriter writer = resp.getWriter();
        writer.write("Subscribed to "+ fullName + "'s news letter");
        System.out.println("doPost method started");

    }
}
