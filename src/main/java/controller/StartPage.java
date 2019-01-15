package controller;

import dao.OrderDao;
import model.Order;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.*;

@WebServlet("/StartPage")
public class StartPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int numberOrders = Integer.parseInt(getServletContext().getInitParameter("number-orders"));

//        List<Order> orders = OrderDao.findAll(numberOrders);
//        request.setAttribute("orders", orders);
         List<ArrayList<String>> OrderWithVehicle = OrderDao.findOrderWithVehicle();
        request.setAttribute("OrderWithVehicle",OrderWithVehicle);

        getServletContext().getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);


    }
}
