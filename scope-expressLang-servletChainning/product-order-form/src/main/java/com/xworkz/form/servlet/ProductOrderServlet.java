package com.xworkz.form.servlet;

import com.xworkz.form.dto.OrderDto;
import com.xworkz.form.entity.OrderEntity;
import com.xworkz.form.service.OrderService;
import com.xworkz.form.service.OrderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/order")
public class ProductOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("productName");
        String quantity = req.getParameter("quantity");
        String customerName = req.getParameter("customerName");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");

        OrderDto dto = new OrderDto();
        dto.setProductName(productName);
        dto.setQuantity(Integer.parseInt(quantity));
        dto.setCustomerName(customerName);
        dto.setAddress(address);
        dto.setPhone(Long.parseLong(phone));

        OrderService service =new OrderServiceImpl();
        service.validateAndSave(dto);

        req.setAttribute("cName",customerName);
        req.setAttribute("pName",productName);
        RequestDispatcher dispatcher = req.getRequestDispatcher("response.jsp");
        dispatcher.forward(req,resp);
    }
}
