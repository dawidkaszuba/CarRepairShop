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
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            Customer customer = new Customer();
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

            CustomerDao.save(DbUtil.getConn(),customer);

        }catch(NumberFormatException e){
            response.getWriter().append("Brak danych.Uzupełnij wszystkie pola");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/CustomersList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
