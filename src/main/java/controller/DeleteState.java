package controller;

import dao.CustomerDao;
import dao.StateDao;
import database.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteState")
public class DeleteState extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("id") !=null){

                StateDao.delete(Integer.parseInt(request.getParameter("id")));

        }else{
            response.getWriter().append("brak parametru");
        }

        response.sendRedirect("/StatesList");
    }
    }

