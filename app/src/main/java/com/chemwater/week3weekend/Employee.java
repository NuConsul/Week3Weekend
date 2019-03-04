package com.chemwater.week3weekend;

public class Employee {
    private String employeeName ;
    private String employeeBirthDate ;
    private String employeeWage ;
    private String employeeHireDate ;
    private int employeeImage ;
    private String employeeImageString ;
    private int id ;

    public Employee() {}

    public Employee(String employeeName, String employeeBirthDate, String employeeWage, String employeeHireDate, int employeeImage, int id) {
        this.employeeName = employeeName;
        this.employeeBirthDate = employeeBirthDate;
        this.employeeWage = employeeWage;
        this.employeeHireDate = employeeHireDate;
        this.employeeImage = employeeImage;
        this.id = id;
    }

    public Employee(String employeeName, String employeeBirthDate, String employeeWage, String employeeHireDate, String employeeImageString, int id) {
        this.employeeName = employeeName ;
        this.employeeBirthDate = employeeBirthDate ;
        this.employeeWage = employeeWage ;
        this.employeeHireDate = employeeHireDate ;
        this.employeeImageString = employeeImageString ;
        this.id = id ;
    }

    /*
    ANOTHER CONSTRUCTOR CREATED WITHOUT THE ID
     */

    public Employee(String employeeName, String employeeBirthDate, String employeeWage, String employeeHireDate, int employeeImage) {
        this.employeeName = employeeName;
        this.employeeBirthDate = employeeBirthDate;
        this.employeeWage = employeeWage;
        this.employeeHireDate = employeeHireDate;
        this.employeeImage = employeeImage;
    }

    public Employee(String employeeName, String employeeBirthDate, String employeeWage, String employeeHireDate, String employeeImageString) {
        this.employeeName = employeeName;
        this.employeeBirthDate = employeeBirthDate;
        this.employeeWage = employeeWage;
        this.employeeHireDate = employeeHireDate;
        this.employeeImageString = employeeImageString;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthDate() {
        return employeeBirthDate;
    }

    public void setEmployeeBirthDate(String employeeBirthDate) {
        this.employeeBirthDate = employeeBirthDate;
    }

    public String getEmployeeWage() {
        return employeeWage;
    }

    public void setEmployeeWage(String employeeWage) {
        this.employeeWage = employeeWage;
    }

    public String getEmployeeHireDate() {
        return employeeHireDate;
    }

    public void setEmployeeHireDate(String employeeHireDate) {
        this.employeeHireDate = employeeHireDate;
    }

    public int getEmployeeImage() {
        return employeeImage ;
    }

    public void setEmployeeImage(int employeeImage) {
        this.employeeImage = employeeImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeImageString() {
        return employeeImageString;
    }

    public void setEmployeeImageString(String employeeImageString) {
        this.employeeImageString = employeeImageString;
    }
}