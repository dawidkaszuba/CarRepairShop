package controller;

import dao.*;
import model.Employee;
import model.Order;
import model.State;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/EditOrder")
public class EditOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        int id;
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
            id = Integer.parseInt(request.getParameter("id"));
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
                order.setId(id);
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



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null) {

            Order order = OrderDao.findById(Integer.parseInt(request.getParameter("id")));
            List<Employee> employees = EmployeeDao.findAll();
            List<State> states = StateDao.findAll();
            List<Vehicle> vehicles = VehicleDao.findAll();
            request.setAttribute("order", order);
            request.setAttribute("employees", employees);
            request.setAttribute("states", states);
            request.setAttribute("vehicles", vehicles);

            getServletContext().getRequestDispatcher("/WEB-INF/view/editorder.jsp").forward(request, response);


        } else {
            response.getWriter().append("Brak danych");
        }

    }
}
