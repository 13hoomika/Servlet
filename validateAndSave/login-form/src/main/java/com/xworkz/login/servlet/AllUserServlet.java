package com.xworkz.login.servlet;

import com.xworkz.login.dto.UserDto;
import com.xworkz.login.service.UserService;
import com.xworkz.login.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class AllUserServlet extends HttpServlet {
    UserService service ;
    public AllUserServlet() {
        service = new UserServiceImpl();
        System.out.println("AllUserServlet constructor started");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String securityCode = req.getParameter("securityCode");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        UserDto dto = new UserDto();
        dto.setUserName(username);
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setPhone(Long.parseLong(phone));
        dto.setSecurityCode(Integer.parseInt(securityCode));

        service.validateAndSave(dto);
//        PrintWriter writer = resp.getWriter();
//        writer.write(username + " LogIn Successful");

        req.setAttribute("uName",username);
        RequestDispatcher dispatcher = req.getRequestDispatcher("response.jsp");
        dispatcher.forward(req,resp);
    }
}
