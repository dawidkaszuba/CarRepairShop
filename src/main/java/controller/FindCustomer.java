package controller;

import dao.CustomerDao;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindCustomer")
public class FindCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("name")!=null){
            String name = request.getParameter("name");
            List<Customer> customers = CustomerDao.findCustomersByName(name);
            request.setAttribute("customers",customers);
            getServletContext().getRequestDispatcher("/WEB-INF/view/customersBySurname.jsp").forward(request,response);

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/view/findCustomer.jsp").forward(request,response);
    }
}


