package com.xworkz.foodapp.servlet;

import com.xworkz.foodapp.dto.UserProfileDto;
import com.xworkz.foodapp.service.UserProfileService;
import com.xworkz.foodapp.service.UserProfileServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/addProfile")
public class AddProfileServlet extends HttpServlet {
    UserProfileService userProfileService;
    public AddProfileServlet() {
        userProfileService = new UserProfileServiceImpl();
        System.out.println("AddProfileServlet invoked");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost method invoked");

        //process data from req to store data
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("emailId");
        String phNumber = req.getParameter("phNumber");

        UserProfileDto dto = new UserProfileDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setEmail(email);
        dto.setPhNumber(Long.parseLong(phNumber));

        userProfileService.validateAndSave(dto);

//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("Thank you "+firstName +" for registering!!");

        //scope this key is used in Expression language in jsp
        req.setAttribute("fName", firstName);

        // to achieve servlet chaining
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);


    }
}
