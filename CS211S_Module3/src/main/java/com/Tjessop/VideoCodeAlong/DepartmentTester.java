package com.Tjessop.VideoCodeAlong;

import java.util.Scanner;

public class DepartmentTester {


    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        //This department is staffed by puppies
        Department puppyDepartment = new Department();

        System.out.print("Please give the number of new employees : ");
        int empNum = Integer.parseInt(userInput.nextLine());


        for (int i = 0; i < empNum ; i++) {

            System.out.print("Please give a name : ");
            String name = userInput.nextLine();
            System.out.print("Please give employee id : ");
            int id = Integer.parseInt(userInput.nextLine());
            System.out.print("Please give employee type : ");
            String type = userInput.nextLine();

            try{
                puppyDepartment.addEmployee(type,name ,id);
            } catch (IllegalArgumentException e){
                e.printStackTrace();
            }

        }



    }//main

}//Class DepartmentTester