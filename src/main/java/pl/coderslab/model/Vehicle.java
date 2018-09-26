package pl.coderslab.model;

import java.util.Date;

public class Vehicle
{
    private Long id;
    private String model;
    private String make;
    private int year;
    private String regNumber;
    private Date next;
    private Customer customer;

    public Vehicle(Long id, String model, String make, int year, String regNumber, Date next, Customer customer) {
        this.id = id;
        this.model = model;
        this.make = make;
        this.year = year;
        this.regNumber = regNumber;
        this.next = next;
        this.customer = customer;
    }

    public Vehicle () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Date getNext() {
        return next;
    }

    public void setNext(Date next) {
        this.next = next;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
