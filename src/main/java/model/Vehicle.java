package model;

import java.time.LocalDate;

public class Vehicle {
    private Integer id;
    private String model;
    private String brand;
    private int yearOfProduction;
    private String registrationNumber;
    private LocalDate nextTechnicalReview;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public LocalDate getNextTechnicalReview() {
        return nextTechnicalReview;
    }

    public void setNextTechnicalReview(LocalDate nextTechnicalReview) {
        this.nextTechnicalReview = nextTechnicalReview;
    }

    public Vehicle(Integer id, String model, String brand, int yearOfProduction,
                   String registrationNumber, LocalDate nextTechnicalReview) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.yearOfProduction = yearOfProduction;
        this.registrationNumber = registrationNumber;
        this.nextTechnicalReview = nextTechnicalReview;
    }
}
