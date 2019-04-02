package com.Tjessop.VideoCodeAlong;

import java.util.Scanner;

public class EmployeeFactory {
    static Scanner userInput = new Scanner(System.in);

    public static Employee newEmployee(String type, String name, int id) throws IllegalArgumentException {
        Employee employee;

        if (type.equalsIgnoreCase("Full")){
            employee = new FullTimeEmployee(name, id);
        }else if(type.equalsIgnoreCase("Part")){

            System.out.println("How are they paid?");
            String payString = userInput.nextLine();
            if (payString.equalsIgnoreCase("Hourly")) {
                employee = new PartTimeEmployee(name, id, new HourlyPayer());
            }else if (payString.equalsIgnoreCase("Salary")){
                employee = new PartTimeEmployee(name,id, new SalaryPayer());
            } else {
                throw  new IllegalArgumentException("Not a pay type valid type");
            }
        } else if (type.equalsIgnoreCase("Intern")){
            employee = new Intern(name, id);
        }
        else{
            throw  new IllegalArgumentException("Not a valid type");
        }

        return employee;
    }
}//Class EmployeeFactory
