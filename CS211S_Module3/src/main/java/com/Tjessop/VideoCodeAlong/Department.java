package com.Tjessop.VideoCodeAlong;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private List<Employee> employeeList;

    public Department() {
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee newEmployee){
        this.employeeList.add(newEmployee);
        newEmployee.process();
    }

    public void addEmployee(String type,String name , int id) throws  IllegalArgumentException{
        this.addEmployee(EmployeeFactory.newEmployee(type,name ,id));
    }

    public void payRoll(){
        for (Employee emp: employeeList
             ) {
            emp.pay();
        }
    }

}//Class Department
