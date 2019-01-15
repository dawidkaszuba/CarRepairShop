package controller;

import dao.EmployeeDao;
import dao.OrderDao;
import dao.StateDao;
import dao.VehicleDao;
import model.Employee;
import model.Order;
import model.State;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/OrderList2")
public class OrderList2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<ArrayList<String>> list = OrderDao.findOrderWithVehicleEmployeeCustomer();
        List<Vehicle> vehicles = VehicleDao.findAll();
        List<Employee> employees = EmployeeDao.findAll();
        List<State> states = StateDao.findAll();
        request.setAttribute("vehicles",vehicles);
        request.setAttribute("employees",employees);
        request.setAttribute("states",states);
        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/WEB-INF/view/orderlist2.jsp").forward(request,response);

    }
}
