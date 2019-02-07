package com.Tljessop.Person.Staff;


import com.Tljessop.Person.Patients.Patient;


public class ErTechnican extends StaffMember{



    public ErTechnican(String firstName, String lastName, int age, String streetAddress, String phoneNumber, String socialSecurityNumber, double payRate) {
        super(firstName, lastName, age, streetAddress, phoneNumber, socialSecurityNumber, new HourlyPayer(0,payRate), 0);

    }
    //Getters and Setters

    public double getHoursWorked() {
        HourlyPayer payer = (HourlyPayer) super.getPayer();
        return payer.getHoursWorked();
    }

    public void setHoursWorked(double hoursWorked) {
        HourlyPayer payer = (HourlyPayer) super.getPayer();
        payer.setHoursWorked(hoursWorked);
    }

    //End of Getters and Setters
    public void checkVitals(Patient patient){
            System.out.println("Checking vitals for " + patient.getPatientIdNumber() + ": " +
                    patient.getLastName() +  ", " + patient.getFirstName());
    }






}//Class ErTechnican
