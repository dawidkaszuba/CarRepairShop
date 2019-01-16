package controller;

import dao.CustomerDao;
import dao.EmployeeDao;
import dao.OrderDao;
import model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;

@WebServlet("/AddOrder")
public class AddOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");


        String dateOfAcceptanceForRepair;
        String plannedRepairDate;
        String startedDateOfRepair;
        int idOfEmployee;
        String descriptionOfProblem;
        String status;
        int idOfVehicle;
        double costOfWork;
        double costOfAutoParts;
        double costOfWorkHour;
        int quantityOfWorkHour;
        int idOfCustomer;
        double profit = 0;

        try {
            dateOfAcceptanceForRepair = request.getParameter("dateOfAcceptanceForRepair");
            plannedRepairDate = request.getParameter("plannedRepairDate");
            startedDateOfRepair = request.getParameter("startedDateOfRepair");
            idOfEmployee = Integer.parseInt(request.getParameter("idOfEmployee"));
            descriptionOfProblem = request.getParameter("descriptionOfProblem");
            status = request.getParameter("status");
            idOfVehicle = Integer.parseInt(request.getParameter("idOfVehicle"));
            costOfAutoParts = Double.parseDouble(request.getParameter("costOfAutoParts"));
            quantityOfWorkHour = Integer.parseInt(request.getParameter("quantityOfWorkHour"));
            profit = Double.parseDouble(request.getParameter("profit"));

            if (dateOfAcceptanceForRepair != "" && plannedRepairDate != "" && startedDateOfRepair != "" &&
                    descriptionOfProblem != "" && status != "") {
                Order order = new Order();
                order.setDateOfAcceptanceForRepair(LocalDate.parse(dateOfAcceptanceForRepair));
                order.setPlannedRepairDate(LocalDate.parse(plannedRepairDate));
                order.setStartedDateOfRepair(LocalDate.parse(startedDateOfRepair));
                order.setIdOfEmployee(idOfEmployee);
                order.setDescriptionOfProblem(descriptionOfProblem);
                order.setStatus(status);
                order.setIdOfVehicle(idOfVehicle);
                order.setCostOfAutoParts(costOfAutoParts);
                order.setQuantityOfWorkHour(quantityOfWorkHour);
                order.setIdOfCustomer(CustomerDao.findCustomerByIdOfVehicle(Integer.parseInt(request.getParameter("idOfVehicle"))));
                order.setCostOfWorkHour(EmployeeDao.findById(Integer.parseInt(request.getParameter("idOfEmployee")))
                        .getCostOfWorkHour());
                order.setCostOfWork((((Integer.parseInt(request.getParameter("quantityOfWorkHour")))
                        * (EmployeeDao.findById(Integer.parseInt(request.getParameter("idOfEmployee"))).getCostOfWorkHour()))
                        + (Double.parseDouble(request.getParameter("costOfAutoParts")))) / profit);

                OrderDao.save(order);
                response.sendRedirect("/OrderList2");

            }

        } catch (NumberFormatException e) {
            response.sendRedirect("/Error1");
        }
    }
}





