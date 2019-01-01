package controller;

import dao.CustomerDao;
import dao.VehicleDao;
import model.Customer;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@WebServlet("/VehiclesList")
public class VehiclesList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Vehicle> vehicles = VehicleDao.findAll();
        List<Customer> customers = CustomerDao.findAll();
        request.setAttribute("vehicles", vehicles);
        request.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/WEB-INF/view/vehicleslist.jsp").forward(request,response);

    }
}
