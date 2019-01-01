package controller;

import dao.CustomerDao;
import dao.VehicleDao;
import database.DbUtil;
import model.Customer;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/EditVehicle")
public class EditVehicle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            Vehicle vehicle = new Vehicle();
            if(request.getParameter("id") != null) {
                vehicle.setId(Integer.parseInt(request.getParameter("id")));
            }else{
                response.getWriter().append("Brak marki");
            }
            if(request.getParameter("brand") != null) {
                vehicle.setBrand(request.getParameter("brand"));
            }else{
                response.getWriter().append("Brak marki");
            }
            if(request.getParameter("model") != null) {
                vehicle.setModel(request.getParameter("model"));
            }else{
                response.getWriter().append("Brak modelu");
            }
            if(request.getParameter("nextTechnicalReview") != null) {
                vehicle.setNextTechnicalReview(LocalDate.parse(request.getParameter("nextTechnicalReview")));
            }else{
                response.getWriter().append("Brak nextTechnicalRewwiev");
            }
            if(request.getParameter("registrationNumber") != null) {
                vehicle.setRegistrationNumber(request.getParameter("registrationNumber"));
            }else{
                response.getWriter().append("Brak registrationNumber");
            }
            if(request.getParameter("yearOfProduction") != null) {
                vehicle.setYearOfProduction(Integer.parseInt(request.getParameter("yearOfProduction")));
            }else{
                response.getWriter().append("Brak yearOfProduction");
            }
            if(request.getParameter("idOfOwner") != null) {
                vehicle.setIdOfOwner(Integer.parseInt(request.getParameter("idOfOwner")));
            }else{
                response.getWriter().append("Brak idOfOwner");
            }

            try {
                VehicleDao.save(DbUtil.getConn(), vehicle);
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }catch(NumberFormatException e) {
            response.getWriter().append("Brak dancyh");
        }

        response.sendRedirect("/VehiclesList");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("id") != null){


                Vehicle vehicle = VehicleDao.findById(Integer.parseInt(request.getParameter("id")));
            try {
                Customer customer = CustomerDao.findById(DbUtil.getConn(),vehicle.getIdOfOwner());
                request.setAttribute("customer",customer);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("vehicle", vehicle);

                getServletContext().getRequestDispatcher("/WEB-INF/view/editvehicle.jsp").forward(request,response);


        }else{
            response.getWriter().append("Brak danych");
        }


    }
}
