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
        double profit =0;
        try {
            Order order = new Order();
            if(request.getParameter("profit")!=null){
                profit = Double.parseDouble(request.getParameter("profit"));
            }
            if (request.getParameter("dateOfAcceptanceForRepair") != null) {
                order.setDateOfAcceptanceForRepair(LocalDate.parse(request.getParameter("dateOfAcceptanceForRepair")));
            }else{
                response.getWriter().append("Brak dateOfAcceptanceForRepair");
            }
            if (request.getParameter("plannedRepairDate") != null) {
                order.setPlannedRepairDate(LocalDate.parse(request.getParameter("plannedRepairDate")));
            }else{
                response.getWriter().append("Brak plannedRepairDate");
            }
            if (request.getParameter("startedDateOfRepair") != null) {
                order.setStartedDateOfRepair(LocalDate.parse(request.getParameter("startedDateOfRepair")));
            }else{
                response.getWriter().append("Brak startedDateOfRepair");
            }
            if (request.getParameter("idOfEmployee") != null) {
                order.setIdOfEmployee(Integer.parseInt(request.getParameter("idOfEmployee")));
            }else{
                response.getWriter().append("Brak idOfEmployee");
            }
            if (request.getParameter("descriptionOfProblem") != null) {
                order.setDescriptionOfProblem(request.getParameter("descriptionOfProblem"));
            }else{
                response.getWriter().append("Brak descriptionOfProblem");
            }
            if (request.getParameter("status") != null) {
                order.setStatus(request.getParameter("status"));
            }else{
                response.getWriter().append("Brak status");
            }
            if (request.getParameter("idOfVehicle") != null) {
                order.setIdOfVehicle(Integer.parseInt(request.getParameter("idOfVehicle")));
            }else{
                response.getWriter().append("Brak idOfVehicle");
            }

            if (request.getParameter("costOfAutoParts") != null) {
                order.setCostOfAutoParts(Double.parseDouble(request.getParameter("costOfAutoParts")));
            }else{
                response.getWriter().append("Brak costOfAutoParts");
            }

            if (request.getParameter("quantityOfWorkHour") != null) {
                order.setQuantityOfWorkHour(Double.parseDouble(request.getParameter("quantityOfWorkHour")));
            }else{
                response.getWriter().append("Brak quantityOfWorkHour");
            }

            if (request.getParameter("idOfVehicle") != null) {
                order.setIdOfCustomer(CustomerDao.findCustomerByIdOfVehicle(Integer.parseInt(request.getParameter("idOfVehicle"))));
            }else{
                response.getWriter().append("Brak idOfVehicle");
            }
            setCostOfWorkHour(request, order);
            setCostOfOrder(request, order,profit);

            OrderDao.save(order);

        }catch(NumberFormatException e){
            response.getWriter().append("Brak danych");
        }catch(NullPointerException e){
            response.getWriter().append("Brak dancyh");
        }catch(DateTimeException e) {
            response.getWriter().append("Brak daty");
        }

        response.sendRedirect("/OrdersList");

    }

    private void setCostOfOrder(HttpServletRequest request, Order order,double profit) {
        double costOfWork = (((Integer.parseInt(request.getParameter("quantityOfWorkHour")))
                * (EmployeeDao.findById(Integer.parseInt(request.getParameter("idOfEmployee"))).getCostOfWorkHour()))
                +(Double.parseDouble(request.getParameter("costOfAutoParts"))))/profit;
        order.setCostOfWork(costOfWork);
    }

    private void setCostOfWorkHour(HttpServletRequest request, Order order) {
        double costOfWorkHour = EmployeeDao.findById(Integer.parseInt(request.getParameter("idOfEmployee"))).getCostOfWorkHour();
        System.out.println(costOfWorkHour);
        order.setCostOfWorkHour(costOfWorkHour);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
