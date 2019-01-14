package controller;

import dao.OrderDao;

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
        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/WEB-INF/view/orderlist2.jsp").forward(request,response);

    }
}
