package controller;

import dao.EmployeeDao;
import dao.OrderDao;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Report2")
public class Report2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("date1")!=null && request.getParameter("date2")!= null ){
            String date1 = request.getParameter("date1");
            String date2 = request.getParameter("date2");
            request.setAttribute("date1",date1);
            request.setAttribute("date1",date2);

            double sumOfCostOfWork = OrderDao.findSumOfCostOfWork(date1,date2);
            double sumOfCostOfAutoParts = OrderDao.findSumOfCostOfAutoParts(date1,date2);
            double sumOfCostOfWorkHours = OrderDao.findSumOfCostOfWorkHours(date1,date2);

            double profit = Math.round((sumOfCostOfWork - sumOfCostOfAutoParts - sumOfCostOfWorkHours));
            request.setAttribute("sumOfCostOfWork", sumOfCostOfWork);
            request.setAttribute("sumOfCostOfAutoParts", sumOfCostOfAutoParts);
            request.setAttribute("sumOfCostOfWorkHours", sumOfCostOfWorkHours);
            request.setAttribute("profit", profit);

            getServletContext().getRequestDispatcher("/WEB-INF/view/report2.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/view/getProfit.jsp").forward(request,response);
    }
}
