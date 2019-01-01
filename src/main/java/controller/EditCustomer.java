package controller;

import dao.CustomerDao;
import dao.EmployeeDao;
import database.DbUtil;
import model.Customer;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/EditCustomer")
public class EditCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customer customer = new Customer();

        if(request.getParameter("id") != null){
            customer.setId(Integer.parseInt(request.getParameter("id")));
        }else{
            response.getWriter().append("Brak danych.Uzupełnij wszystkie pola");
        }
        if(request.getParameter("name") != null){
            customer.setName(request.getParameter("name"));
        }else{
            response.getWriter().append("Brak danych.Uzupełnij wszystkie pola");
        }
        if(request.getParameter("surname") != null){
            customer.setSurname(request.getParameter("surname"));
        }else{
            response.getWriter().append("Brak danych.Uzupełnij wszystkie pola");
        }

        if(request.getParameter("birthday") != null){
            customer.setBirthday(LocalDate.parse(request.getParameter("birthday")));
        }else{
            response.getWriter().append("Brak danych.Uzupełnij wszystkie pola");
        }
        if(request.getParameter("email") != null){
            customer.setEmail(request.getParameter("email"));
        }else{
            response.getWriter().append("Brak danych.Uzupełnij wszystkie pola");
        }

        try {
            CustomerDao.save(DbUtil.getConn(),customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/CustomersList");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("id") != null){

            try {
                Customer customer = CustomerDao.findById(DbUtil.getConn(), Integer.parseInt(request.getParameter("id")));
                request.setAttribute("customer", customer);
                getServletContext().getRequestDispatcher("/WEB-INF/view/editecustomer.jsp").forward(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else{
            response.getWriter().append("Brak danych");
        }


    }

    }

