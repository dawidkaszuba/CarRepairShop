package controller;

import dao.OrderDao;
import model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CurrentOrders")
public class CurrentOrders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id")!=null){
            int id = Integer.parseInt(request.getParameter("id"));
            String state = "w naprawie";
            List<ArrayList<String>> list = OrderDao.findOrderWithVehicleCustomerByEmployeeIdCurrentInRepair(id,state);
            request.setAttribute("list", list);
            getServletContext().getRequestDispatcher("/WEB-INF/view/currentRepairByEmployee.jsp").forward(request,response);

        }

    }
}
