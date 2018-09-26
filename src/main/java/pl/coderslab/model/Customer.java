package pl.coderslab.model;

import java.util.Date;

public class Customer
{
    private long id;
    private String name;
    private String surname;
    private java.sql.Date dateOfBirth;

    public Customer(long id, String name, String surname, java.sql.Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Customer () {}

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

    public java.sql.Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(java.sql.Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }
}
