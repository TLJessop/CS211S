package com.Tljessop.Person.Patients;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PatientTester {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        List<Patient> patients = new ArrayList<>();

        // M3 USING FACTORY

        System.out.print("How many patients would you like to make : ");
        int loopControl = Integer.parseInt(userInput.nextLine());

        for (int i = 0; i < loopControl; i++) {

            System.out.print("Please give type patient to be made \n\tValid options are IN, Out and ER \n\t:");
            String type = userInput.nextLine();

            System.out.print("Please give the patient's first name : ");
            String firstName = userInput.nextLine();

            System.out.print("Please give the patient's last name : ");
            String lastName = userInput.nextLine();

            System.out.print("Please give the patient's age :");
            int age = Integer.parseInt(userInput.nextLine());

            System.out.print("Please give the patient's weight : ");
            double weight = Double.parseDouble(userInput.nextLine());

           patients.add( PatientFactory.newPatient(type,firstName,lastName,age,weight));
        }

        System.out.println();
        for (Patient patient:patients
             ) {
            System.out.println(patient);
        }

        String yesOrNo;

        do {
            System.out.println();
            System.out.println("-------------------------------------------------------------------------");
            System.out.println();

            System.out.println("How would you like to short your new patients?" +
                    "\n\tValid options are ByFirstName, ByAge, ById and NaturalOrder \n\t:");
            String orderType = userInput.nextLine();

            if (orderType.equalsIgnoreCase("ByFirstName")) {
                Collections.sort(patients, Patient.FIRST_NAME_COMPARE);
            } else if (orderType.equalsIgnoreCase("ByAge")) {
                Collections.sort(patients, Patient.AGE_COMPARE);
            } else if (orderType.equalsIgnoreCase("ById")) {
                Collections.sort(patients, Patient.ID_COMPARE);
            } else if (orderType.equalsIgnoreCase("NaturalOrder")) {
                Collections.sort(patients);
            }

            for (Patient patient:patients
            ) {
                System.out.println(patient);
            }

            System.out.println("Would ypu like to resort? \n\t Valid options are yes and no\n\t:");
            yesOrNo = userInput.nextLine();
        } while (yesOrNo.equalsIgnoreCase("yes"));
    }//main

}//Class PatientTester