package controller;

import dao.OrderDao;
import dao.StateDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteOrder")
public class DeleteOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id") !=null){

            OrderDao.delete(Integer.parseInt(request.getParameter("id")));

        }else{
            response.getWriter().append("brak parametru");
        }

        response.sendRedirect("/OrderList2");
    }
}
