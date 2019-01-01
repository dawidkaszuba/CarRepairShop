package controller;


import dao.VehicleDao;
import database.DbUtil;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/AddVehicle")
public class AddVehicle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            Vehicle vehicle = new Vehicle();
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




    }
}
