package com.xworkz.foodapp.servlet;

import com.xworkz.foodapp.service.UserProfileService;
import com.xworkz.foodapp.service.UserProfileServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteUserProfileByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        UserProfileService userProfileService = new UserProfileServiceImpl();
        userProfileService.deleteUserById(Integer.parseInt(userId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("getAllProfiles");
        dispatcher.forward(req, resp);
    }
}
