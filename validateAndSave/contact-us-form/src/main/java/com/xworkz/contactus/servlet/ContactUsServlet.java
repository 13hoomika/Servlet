package com.xworkz.contactus.servlet;

import com.xworkz.contactus.dto.ContactDto;
import com.xworkz.contactus.service.ContactService;
import com.xworkz.contactus.service.ContactServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/contact")
public class ContactUsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String category = req.getParameter("category");
        String phone = req.getParameter("phone");
        String message = req.getParameter("message");

        ContactDto dto = new ContactDto();
        dto.setName(name);
        dto.setEmail(email);
        dto.setCategory(category);
        dto.setPhone(Long.parseLong(phone));
        dto.setMessage(message);

        ContactService service = new ContactServiceImpl();
        service.processAndSave(dto);

//        PrintWriter writer = resp.getWriter();
//        writer.write("thank you for contacting "+ name);
        req.setAttribute("contactEmail",email);
        RequestDispatcher dispatcher = req.getRequestDispatcher("response.jsp");
        dispatcher.forward(req,resp);
    }
}
