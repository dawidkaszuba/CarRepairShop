package controller;

import dao.CustomerDao;
import database.DbUtil;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name=null;
        String surname=null;
        String birthday=null;
        String email=null;

        try{
            name =request.getParameter("name");
            surname = request.getParameter("surname");
            birthday = request.getParameter("birthday");
            email = request.getParameter("email");


        }catch(NullPointerException e) {
            response.sendRedirect("/Error1");
        }

            try {

                if (name != "" && surname != "" && birthday != "" && email != "") {
                    Customer customer = new Customer();
                    customer.setName(name);
                    customer.setSurname(surname);
                    customer.setBirthday(LocalDate.parse(birthday));
                    customer.setEmail(email);
                    CustomerDao.save(DbUtil.getConn(), customer);
                    response.sendRedirect("/CustomersList");
                }
                else{
                    response.sendRedirect("/Error1");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
