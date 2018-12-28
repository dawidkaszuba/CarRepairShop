package model;

public class Employee {
    private Integer id;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String note;
    private double costOfWorkHour;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getCostOfWorkHour() {
        return costOfWorkHour;
    }

    public void setCostOfWorkHour(double costOfWorkHour) {
        this.costOfWorkHour = costOfWorkHour;
    }

    public Employee() {
    }

    public Employee(Integer id, String name, String surname, String address, String phoneNumber, String note, double costOfWorkHour) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.note = note;
        this.costOfWorkHour = costOfWorkHour;

    }
}
