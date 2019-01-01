package controller;

import dao.CustomerDao;
import database.DbUtil;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CustomersList")
public class CustomersList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Customer> customers = CustomerDao.findAll();
        request.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/WEB-INF/view/customerslist.jsp").forward(request, response);

    }
}
