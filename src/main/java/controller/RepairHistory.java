package controller;

import dao.OrderDao;
import model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/RepairHistory")
public class RepairHistory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id")!=null){
            int id = Integer.parseInt(request.getParameter("id"));
            List<Order> orders = OrderDao.findOrderByVehicleId(id);
            request.setAttribute("orders", orders);
            if(orders.size()==0){

               response.sendRedirect("/Error1");
            }else {

                getServletContext().getRequestDispatcher("/WEB-INF/view/repairHistory.jsp").forward(request,response);
            }
        }
    }
}
