package controller;

import dao.EmployeeDao;
import database.DbUtil;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Employee employee = new Employee();

            if (request.getParameter("name") != null) {
                employee.setName(request.getParameter("name"));
            } else {
                response.getWriter().append("Brak danych");
            }

            if (request.getParameter("surname") != null) {
                employee.setSurname(request.getParameter("surname"));
            } else {
                response.getWriter().append("Brak danych");
            }
            if (request.getParameter("address") != null) {
                employee.setAddress(request.getParameter("address"));
            } else {
                response.getWriter().append("Brak danych");
            }
            if (request.getParameter("phoneNumber") != null) {
                employee.setPhoneNumber(request.getParameter("phoneNumber"));
            } else {
                response.getWriter().append("Brak danych");
            }
            if (request.getParameter("note") != null) {
                employee.setNote(request.getParameter("note"));
            } else {
                response.getWriter().append("Brak danych");
            }
            if (request.getParameter("costOfWorkHour") != null) {
                employee.setCostOfWorkHour(Double.parseDouble(request.getParameter("costOfWorkHour")));
            } else {
                response.getWriter().append("Brak danych");
            }

            try {
                EmployeeDao.save(DbUtil.getConn(), employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.sendRedirect("/EmployeeList");
        }catch(NumberFormatException e){
            response.getWriter().append("Brak danych");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
