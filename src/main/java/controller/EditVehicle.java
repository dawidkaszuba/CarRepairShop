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
        int id;
        String brand;
        String model;
        String nextTechnicalReview;
        String registrationNumber;
        int yearOfProduction;
        int idOfOwner;

        try{
            id = Integer.parseInt(request.getParameter("id"));
            brand = request.getParameter("brand");
            model = request.getParameter("model");
            nextTechnicalReview = request.getParameter("nextTechnicalReview");
            registrationNumber = request.getParameter("registrationNumber");
            yearOfProduction = Integer.parseInt(request.getParameter("yearOfProduction"));
            idOfOwner = Integer.parseInt(request.getParameter("idOfOwner"));

            if(brand != "" && model != "" && nextTechnicalReview != "" && registrationNumber != "") {

                Vehicle vehicle = new Vehicle();
                vehicle.setId(id);
                vehicle.setBrand(brand);
                vehicle.setModel(model);
                vehicle.setNextTechnicalReview(LocalDate.parse(nextTechnicalReview));
                vehicle.setRegistrationNumber(registrationNumber);
                vehicle.setYearOfProduction(yearOfProduction);
                vehicle.setIdOfOwner(idOfOwner);

                VehicleDao.save(DbUtil.getConn(), vehicle);
                response.sendRedirect("/VehiclesList");
            }else{
                response.sendRedirect("/Error1");
            }

        }catch(NumberFormatException e){
            response.sendRedirect("/Error1");
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
