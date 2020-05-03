package com.mindex.challenge.data;

import java.util.*;

public class ReportingStruct {
    private Employee employee;
    private int numOfReports;

    public ReportingStruct(){
    }

    public ReportingStruct(Employee employee, int numOfReports){
        this.employee = employee;
        this.numOfReports = numOfReports;
    }

    // Get Methods
    public Employee getEmployee() {
        return employee;
    }

    public int getNumOfReports() {
        return numOfReports;
    }
}
