package com.tljessop.VideoCodeAlong;

import java.util.Objects;

enum EmployeePayType{
    HOURLY, SALARY
}

enum Status{
    ACTIVE, TEMPE_INACTIVE, PREM_INACTIVE
}

public class Employee implements Comparable<Employee> {

    //Instance variables
    private int age;
    private String firstName;
    private String lastName;
    private String address;
    private int employeeId;
    private EmployeePayType payType;
    private Status empStatus;
    //End of instance variables

    private static int nextEmployeeId = 0;

    //Constructor
    public Employee(int age, String firstName, String lastName, String address, EmployeePayType payType) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.employeeId = nextEmployeeId;
        this.payType = payType;
        this.empStatus = Status.ACTIVE;
        nextEmployeeId++;
    }

    //Getters and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmployeeId() {
        return employeeId;
    }
    // End of Getters and Setters

    @Override
    public String toString() {
        return  this.getClass().getName() + " {" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return getAge() == employee.getAge() &&
                getEmployeeId() == employee.getEmployeeId() &&
                getFirstName().equals(employee.getFirstName()) &&
                getLastName().equals(employee.getLastName()) &&
                Objects.equals(getAddress(), employee.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getFirstName(), getLastName(), getAddress(), getEmployeeId());
    }

    @Override
    public int compareTo(Employee otherEmployee){
        if (this.lastName.compareTo(otherEmployee.lastName) != 0){
            return this.lastName.compareTo(otherEmployee.lastName);
        } else if (this.firstName.compareTo(otherEmployee.firstName) != 0){
            return this.firstName.compareTo(otherEmployee.firstName);
        } else {
            return Integer.compare(this.employeeId, otherEmployee.employeeId);
        }
    }
}// class