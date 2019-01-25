package com.Tljessop.Patients;

public class PatientTester {
    public static void main(String[] args){

        //Creating array of patients
        Patient[] patients = new Patient[5];

        //Populating patient array
        patients[0] = new ErPatient("John","Smith",23,156.3,348536,
                "Drove himself", true);
        patients[1] = new OutPatient("Sandy", "Mitcheal",30,120.4, 416497,
                "Dr. Jones", "OBGYN", 559734);
        patients[2] = new ErPatient(40,220.9,791463,"EMS Dropoff",false);
        patients[3] = new InPatient("Larry","Loser",80,140.6,982564,
                436,4,"Dr. Jones");
        patients[4] = new InPatient("Freeddy","Jameson",17,170.2,453619,
                297,2,"Dr. Smith");

        // Printing the new array to screen
        for (Patient p1: patients
             ) {
            System.out.println(p1);
            System.out.println();

        }

        // Demonstrating some of the ErPatients methods
        ((ErPatient) patients[2]).checkIn("Bleeding from eyes, nose and mouth");
        System.out.println(((ErPatient) patients[2]).getChiefComplaint());
        ((ErPatient) patients[2]).triagePatient("Dying from blood loss", "RN Anna Smith");
        System.out.println(((ErPatient) patients[2]).getChiefComplaint());
        ((ErPatient) patients[2]).setAttendingPhysician("Dr.Jackson");
        System.out.println();

        System.out.println(((ErPatient) patients[0]).isCheckedIn());
        ((ErPatient) patients[0]).checkIn("Broken toe");
        patients[0].discharge();

        //OutPatients can become InPatients and ER patients
        System.out.println(patients[1].getClass());
        patients[1] = Patient.retainPatient(patients[1] ,549,5,"Dr. Clifford");
        System.out.println(patients[1].getClass());
        System.out.println();

        System.out.println(patients[2].getClass());
        patients[2]= Patient.retainPatient(patients[2] ,126,1,
                "Dr. Cruz");
        System.out.println(patients[2].getClass());
        System.out.println();

        //Someone misspelled Freddy's name
        patients[4].setFirstName("Freddy");
        // Then he gets to go home
        patients[4].discharge();
    }//main
}//class
