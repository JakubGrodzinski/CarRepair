package pl.coderslab.model;

public class Employee
{
    private long id;
    private String name;
    private String surname;
    private String street;
    private String nOfHouse;
    private String city;
    private String phoneNum;
    private String note;
    private Double cost;


    public Employee(long id, String name, String surname, String street, String nOfHouse, String city, String phoneNum, String note, Double cost)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.street = street;
        this.nOfHouse = nOfHouse;
        this.city = city;
        this.phoneNum = phoneNum;
        this.note = note;
        this.cost = cost;
    }

    public Employee () {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getnOfHouse() {
        return nOfHouse;
    }

    public void setnOfHouse(String nOfHouse) {
        this.nOfHouse = nOfHouse;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
