package com.Tljessop.Person.Patients;

import java.util.Scanner;

public class PatientFactory {
    static Scanner userInput = new Scanner(System.in);

    public  static Patient newPatient(String type, String firstName, String lastName,
                                      int age, double weight){
        Patient patient;

        if (type.equalsIgnoreCase("in")){
            System.out.print("Please give room number : ");
            int roomNumber = Integer.parseInt(userInput.nextLine());

            System.out.print("Please give floor number : ");
            int floorNumber = Integer.parseInt(userInput.nextLine());

            System.out.print("Please give attending physician : ");
            String physician = userInput.nextLine();
            patient = new InPatient(firstName,lastName,age,weight, roomNumber,floorNumber, physician);

        } else if(type.equalsIgnoreCase("out")){
            System.out.print("Please give name of referring physician : ");
            String physician = userInput.nextLine();

            patient = new OutPatient(firstName,lastName,age,weight,physician);

        } else if (type.equalsIgnoreCase("ER")){
            System.out.print("Please mode of arrival : ");
            String arrival = userInput.nextLine();
            System.out.print("Is the patient conscious? \nPlease answer true or false : ");
            boolean concious = Boolean.parseBoolean(userInput.nextLine()) ;
            patient = new ErPatient(firstName,lastName,age,weight,arrival, concious);
        }else {
            throw  new IllegalArgumentException("Not a valid type");
        }

        return patient;
    }

}//Class PatientFactory
