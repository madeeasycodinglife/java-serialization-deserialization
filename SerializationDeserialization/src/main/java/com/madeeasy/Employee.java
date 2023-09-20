package com.madeeasy;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private int employeeId;

    public Employee() {
        // Default constructor required for JSON/Jackson
    }

    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    // Getter and setter methods...


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", employeeId=" + employeeId + "]";
    }
}
