package com.Tljessop.Person.Staff;

import com.Tljessop.Person.Patients.ErPatient;
import com.Tljessop.Person.Patients.OutPatient;

import java.util.ArrayList;
import java.util.List;

public class StaffTester {

    public static void main(String[] args) {

        List<StaffMember> staff = new ArrayList<>();
    // M3 USING BUILDER
        Doctor doctor = new Doctor.DoctorBuilder().fistName("Jack").lastName("Jones").age(5)
                .medicalLicenseNumber("LN:5454f").payRate(54000).phoneNumber("(415)-444-9999").streetAddress("123 Puppy st.")
                .socialSecurityNumber("464-44-4466").build();
        System.out.println(doctor.addPatient(new OutPatient("john","Doe",20,156,doctor.getLastName())));
        doctor.prescibe("Aecetminophen",0);
        doctor.listPatients();
        System.out.println(doctor.relaseFromCare(doctor.getCurentPatients().get(0)));
        System.out.println();

        Nurse nurse = new Nurse("Jim","James", 24,"123 Cat st.", "(415)-789-4455",
                "549-22-4444",new SalaryPayer(30000.56),7, "LN: 569707");
        ErPatient erPatient = new ErPatient("Walley", "West",20,145.5,"Ambulance",true);
        nurse.triagePatient(erPatient, "Broken Leg");
        System.out.println(nurse.getCurrentPatients());
        nurse.removePatient(erPatient);
        System.out.println(nurse.getCurrentPatients());
        System.out.println();


        ErTechnican ertech = new ErTechnican("Tom","Tanker", 22, "456 Monkery st",
                "(415)-333-4445", "244-48-8057", 17.5);
        ertech.checkVitals(erPatient);
        ertech.setHoursWorked(25);
        System.out.println();

        staff.add(doctor);
        staff.add(nurse);
        staff.add(ertech);

        for (StaffMember employee: staff
             ) {
            employee.pay();

        }




    }//main

}//Class StaffTester