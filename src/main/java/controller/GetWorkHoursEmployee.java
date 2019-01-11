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

@WebServlet("/GetWorkHoursEmployee")
public class GetWorkHoursEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("startedDateOfRepair")!=null && request.getParameter("date")!= null && request.getParameter("id")!=null){
            String startedDateOfRepair = request.getParameter("startedDateOfRepair");
            String date = request.getParameter("date");
            request.setAttribute("date",date);
            request.setAttribute("startedDateOfRepair",startedDateOfRepair);
            int id = Integer.parseInt(request.getParameter("id"));

            Employee employee = EmployeeDao.findById(id);
            request.setAttribute("employee",employee);

            int workHours = OrderDao.getWorkHoursByEmployeeAndDate(date,startedDateOfRepair,id);
            request.setAttribute("workHours",workHours);
            getServletContext().getRequestDispatcher("/WEB-INF/view/raport1.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            if(request.getParameter("id")!=null){
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("id",id);
                getServletContext().getRequestDispatcher("/WEB-INF/view/getWorkHoursEmployee.jsp").forward(request,response);
            }
    }
}
