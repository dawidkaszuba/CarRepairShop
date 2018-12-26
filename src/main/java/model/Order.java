package model;

import java.util.Date;


public class Order {
    private Integer id;
    private Date dateOfAcceptanceForRepair;
    private Date plannedRepairDate;
    private Date startedDateOfRepair;
    private Employee employeeRepairing;
    private String descriptionOfproblem;
    private Status status;
    private Vehicle vehicle;
    private double costOfWork;
    private double costOfAutoParts;
    private double costOfWorkHour;
    private double quantityOfWorkHour;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfAcceptanceForRepair() {
        return dateOfAcceptanceForRepair;
    }

    public void setDateOfAcceptanceForRepair(Date dateOfAcceptanceForRepair) {
        this.dateOfAcceptanceForRepair = dateOfAcceptanceForRepair;
    }

    public Date getPlannedRepairDate() {
        return plannedRepairDate;
    }

    public void setPlannedRepairDate(Date plannedRepairDate) {
        this.plannedRepairDate = plannedRepairDate;
    }

    public Date getStartedDateOfRepair() {
        return startedDateOfRepair;
    }

    public void setStartedDateOfRepair(Date startedDateOfRepair) {
        this.startedDateOfRepair = startedDateOfRepair;
    }

    public Employee getEmployeeRepairing() {
        return employeeRepairing;
    }

    public void setEmployeeRepairing(Employee employeeRepairing) {
        this.employeeRepairing = employeeRepairing;
    }

    public String getDescriptionOfproblem() {
        return descriptionOfproblem;
    }

    public void setDescriptionOfproblem(String descriptionOfproblem) {
        this.descriptionOfproblem = descriptionOfproblem;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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

    public Order(Integer id, Date dateOfAcceptanceForRepair, Date plannedRepairDate, Date startedDateOfRepair,
                 Employee employeeRepairing, String descriptionOfproblem, Status status, Vehicle vehicle,
                 double costOfWork, double costOfAutoParts, double costOfWorkHour, double quantityOfWorkHour) {
        this.id = id;
        this.dateOfAcceptanceForRepair = dateOfAcceptanceForRepair;
        this.plannedRepairDate = plannedRepairDate;
        this.startedDateOfRepair = startedDateOfRepair;
        this.employeeRepairing = employeeRepairing;
        this.descriptionOfproblem = descriptionOfproblem;
        this.status = status;
        this.vehicle = vehicle;
        this.costOfWork = costOfWork;
        this.costOfAutoParts = costOfAutoParts;
        this.costOfWorkHour = costOfWorkHour;
        this.quantityOfWorkHour = quantityOfWorkHour;
    }
}
