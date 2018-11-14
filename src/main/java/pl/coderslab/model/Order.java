package pl.coderslab.model;

import java.util.Date;

public class Order
{
    private Long id;
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

    public Order(Long id, Date reception, Date plannedStart, Date actualStart, Employee assignedEmployee, String descriptionProblem, String descriptionSolution, Status status, Vehicle vehicle, Double totalCost, Double partsCosts, Double empHourCost, Double empHoursQuantity)
    {
        this.id = id;
        this.reception = reception;
        this.plannedStart = plannedStart;
        this.actualStart = actualStart;
        this.assignedEmployee = assignedEmployee;
        this.descriptionProblem = descriptionProblem;
        this.descriptionSolution = descriptionSolution;
        this.status = status;
        this.vehicle = vehicle;
        this.totalCost = totalCost;
        this.partsCosts = partsCosts;
        this.empHourCost = empHourCost;
        this.empHoursQuantity = empHoursQuantity;
    }

    public Order () {}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReception() {
        return reception;
    }

    public void setReception(Date reception) {
        this.reception = reception;
    }

    public Date getPlannedStart() {
        return plannedStart;
    }

    public void setPlannedStart(Date plannedStart) {
        this.plannedStart = plannedStart;
    }

    public Date getActualStart() {
        return actualStart;
    }

    public void setActualStart(Date actualStart) {
        this.actualStart = actualStart;
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(Employee assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    public String getDescriptionProblem() {
        return descriptionProblem;
    }

    public void setDescriptionProblem(String descriptionProblem) {
        this.descriptionProblem = descriptionProblem;
    }

    public String getDescriptionSolution() {
        return descriptionSolution;
    }

    public void setDescriptionSolution(String descriptionSolution) {
        this.descriptionSolution = descriptionSolution;
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

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public void setTotalCost()
    {
        this.totalCost = this.empHourCost * this.empHoursQuantity + this.partsCosts;
    }

    public Double getPartsCosts() {
        return partsCosts;
    }

    public void setPartsCosts(Double partsCosts) {
        this.partsCosts = partsCosts;
    }


    public Double getEmpHourCost() {
        return empHourCost;
    }

    public void setEmpHourCost(Double empHourCost) {
        this.empHourCost = empHourCost;
    }

    public void setEmpHourCost()
    {
        this.empHourCost = this.assignedEmployee.getCost();
    }

    public Double getEmpHoursQuantity() {
        return empHoursQuantity;
    }

    public void setEmpHoursQuantity(Double empHoursQuantity) {
        this.empHoursQuantity = empHoursQuantity;
    }
}
