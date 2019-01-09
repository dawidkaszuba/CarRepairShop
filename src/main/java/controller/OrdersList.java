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
import java.util.List;

@WebServlet("/OrdersList")
public class OrdersList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Order> orders = OrderDao.findAll(50000000);
        List<Employee> employees = EmployeeDao.findAll();
        List<State> states = StateDao.findAll();
        List<Vehicle> vehicles = VehicleDao.findAll();
        request.setAttribute("employees", employees);
        request.setAttribute("orders", orders);
        request.setAttribute("states",states);
        request.setAttribute("vehicles",vehicles);
        getServletContext().getRequestDispatcher("/WEB-INF/view/orderslist.jsp").forward(request,response);

    }
}
