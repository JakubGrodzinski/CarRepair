package pl.coderslab.model;

import java.util.Date;

public class Order
{
    private long id;
    private Date reception;
    private Date plannedStart;
    private Date actualStart;
    private Employee assignedEmployee;
    private String descriptionProblem;
    private String descriptionSolution;
    private Status status;
    private Vehicle vehicle;
    private Double totalCost;
    private Double partsCosts;
    private Double empHourCost;
    private Double empHoursQuantity;
}
