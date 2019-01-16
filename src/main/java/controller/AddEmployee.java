package controller;

import dao.EmployeeDao;
import database.DbUtil;
import model.Employee;

import javax.naming.CompositeName;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String name;
        String surname;
        String address;
        String phoneNumber;
        String note;
        double costOfWorkHour;

       try {
           name = request.getParameter("name");
           surname = request.getParameter("surname");
           address = request.getParameter("address");
           phoneNumber = request.getParameter("phoneNumber");
           note = request.getParameter("note");
           costOfWorkHour = Double.parseDouble(request.getParameter("costOfWorkHour"));

           try{
               if(name!="" && surname!="" && address != "" && phoneNumber != "" && note != ""){
                   Employee employee = new Employee();
                   employee.setName(name);
                   employee.setSurname(surname);
                   employee.setAddress(address);
                   employee.setPhoneNumber(phoneNumber);
                   employee.setNote(note);
                   employee.setCostOfWorkHour(costOfWorkHour);

                   EmployeeDao.save(DbUtil.getConn(),employee);
                   response.sendRedirect("/EmployeeList");
               }
               else{
                   response.sendRedirect("/Error1");
               }

           }catch(SQLException e){
               e.printStackTrace();
           }

       }catch(NumberFormatException e) {
           response.sendRedirect("/Error1");
       }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
