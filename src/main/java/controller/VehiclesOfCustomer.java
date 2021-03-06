package controller;

import dao.VehicleDao;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/VehiclesOfCustomer")
public class VehiclesOfCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(Integer.parseInt(request.getParameter("id"))>=0){
            int id = Integer.parseInt(request.getParameter("id"));
            List<Vehicle> vehicles = VehicleDao.findVehiclesByCustomerId(id);
            request.setAttribute("vehicles",vehicles);
            getServletContext().getRequestDispatcher("/WEB-INF/view/vehiclesOfCustomer.jsp").forward(request,response);
        }
    }
}
