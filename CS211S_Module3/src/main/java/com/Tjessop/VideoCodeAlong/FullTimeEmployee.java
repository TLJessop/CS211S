package com.Tjessop.VideoCodeAlong;

public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, int employeeId) {
        super(name, employeeId, new SalaryPayer());
    }

    @Override
    public void benefits() {
        System.out.println("Issuing benefits");
    }

    @Override
    public void timeOff() {
        System.out.println("Giving time off");
    }

    @Override
    public void process() {
        System.out.println("processing");
    }

}//Class FullTimeEmployee
