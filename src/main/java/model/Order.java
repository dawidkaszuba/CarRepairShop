package model;

import java.time.LocalDate;

public class Order {
    private Integer id;
    private LocalDate dateOfAcceptanceForRepair;
    private LocalDate plannedRepairDate;
    private LocalDate startedDateOfRepair;
    private int idOfEmployee;
    private String descriptionOfProblem;
    private String status;
    private int idOfVehicle;
    private double costOfWork;
    private double costOfAutoParts;
    private double costOfWorkHour;
    private double quantityOfWorkHour;
    private int idOfCustomer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateOfAcceptanceForRepair() {
        return dateOfAcceptanceForRepair;
    }

    public void setDateOfAcceptanceForRepair(LocalDate dateOfAcceptanceForRepair) {
        this.dateOfAcceptanceForRepair = dateOfAcceptanceForRepair;
    }

    public LocalDate getPlannedRepairDate() {
        return plannedRepairDate;
    }

    public void setPlannedRepairDate(LocalDate plannedRepairDate) {
        this.plannedRepairDate = plannedRepairDate;
    }

    public LocalDate getStartedDateOfRepair() {
        return startedDateOfRepair;
    }

    public void setStartedDateOfRepair(LocalDate startedDateOfRepair) {
        this.startedDateOfRepair = startedDateOfRepair;
    }

    public int getIdOfEmployee() {
        return idOfEmployee;
    }

    public void setIdOfEmployee(int idOfEmployee) {
        this.idOfEmployee = idOfEmployee;
    }

    public String getDescriptionOfProblem() {
        return descriptionOfProblem;
    }

    public void setDescriptionOfProblem(String descriptionOfProblem) {
        this.descriptionOfProblem = descriptionOfProblem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdOfVehicle() {
        return idOfVehicle;
    }

    public void setIdOfVehicle(int idOfVehicle) {
        this.idOfVehicle = idOfVehicle;
    }

    public double getCostOfWork() {
        return costOfWork;
    }

    public void setCostOfWork(double costOfWork) {
        this.costOfWork = costOfWork;
    }

    public double getCostOfAutoParts() {
        return costOfAutoParts;
    }

    public void setCostOfAutoParts(double costOfAutoParts) {
        this.costOfAutoParts = costOfAutoParts;
    }

    public double getCostOfWorkHour() {
        return costOfWorkHour;
    }

    public void setCostOfWorkHour(double costOfWorkHour) {
        this.costOfWorkHour = costOfWorkHour;
    }

    public double getQuantityOfWorkHour() {
        return quantityOfWorkHour;
    }

    public void setQuantityOfWorkHour(double quantityOfWorkHour) {
        this.quantityOfWorkHour = quantityOfWorkHour;
    }

    public int getIdOfCustomer() {
        return idOfCustomer;
    }

    public void setIdOfCustomer(int idOfCustomer) {
        this.idOfCustomer = idOfCustomer;
    }

    public Order(Integer id, LocalDate dateOfAcceptanceForRepair, LocalDate plannedRepairDate,
                 LocalDate startedDateOfRepair, int idOfEmployee, String descriptionOfProblem, String status,
                 int idOfVehicle, double costOfWork, double costOfAutoParts, double costOfWorkHour,
                 double quantityOfWorkHour, int idOfCustomer) {
        this.id = id;
        this.dateOfAcceptanceForRepair = dateOfAcceptanceForRepair;
        this.plannedRepairDate = plannedRepairDate;
        this.startedDateOfRepair = startedDateOfRepair;
        this.idOfEmployee = idOfEmployee;
        this.descriptionOfProblem = descriptionOfProblem;
        this.status = status;
        this.idOfVehicle = idOfVehicle;
        this.costOfWork = costOfWork;
        this.costOfAutoParts = costOfAutoParts;
        this.costOfWorkHour = costOfWorkHour;
        this.quantityOfWorkHour = quantityOfWorkHour;
        this.idOfCustomer = idOfCustomer;
    }

    public Order() {
    }
}
