package com.mindex.challenge.data;

import java.util.*;

public class Compensation{
    private Employee employee;
    private Compensation compensation;
    private int salary;
    private Date effectiveDate;

    public Compensation(){
    }

    public Compensation(Employee employee, Compensation compensation){
        this.employee = employee;
        this.compensation = compensation;
    }

    //Get Employee
    public Employee getEmployee() {
        return employee;
    }

    //Set Employee
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    //Get Salary
    public int getSalary() {
        return salary;
    }

    //Set Salary
    public void setSalary(int salary) {
        this.salary = salary;
    }

    //Get Date
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    //Set Date
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}