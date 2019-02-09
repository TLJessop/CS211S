package com.Tljessop.Person.Staff;


import com.Tljessop.Person.Patients.ErPatient;
import com.Tljessop.Person.Patients.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Nurse extends StaffMember{

    private String registeredNurseLicense;
    private List<Patient> currentPatients;


    public Nurse(String firstName, String lastName, int age, String streetAddress, String phoneNumber, String socialSecurityNumber,
                  Payer payer, int vacationDays, String registeredNurseLicense) {
        super(firstName, lastName, age, streetAddress, phoneNumber, socialSecurityNumber, payer, vacationDays);
        this.registeredNurseLicense = registeredNurseLicense;
        currentPatients = new ArrayList<>();
    }



    //Getter and Setters
    public void addPatients(Patient patient){
        currentPatients.add(patient);
    }

    public List<Patient> getCurrentPatients() {
        return currentPatients;
    }

    public String getRegisteredNurseLicense() {
        return registeredNurseLicense;
    }

    public void setRegisteredNurseLicense(String registeredNurseLicense) {
        this.registeredNurseLicense = registeredNurseLicense;
    }

    //End of getters and setters

    public boolean removePatient(Patient patient){
           return currentPatients.remove(patient);
    }

    public void triagePatient(ErPatient newPatient, String cheifComplant){
        newPatient.triagePatient(cheifComplant, this);
        currentPatients.add(newPatient);
    }

    public boolean inCare(Patient patient){
        return currentPatients.contains(patient);
    }

    public void administierPerscription(String prescription, Patient patient) {
        System.out.println("Giving  " + prescription + " to " + patient.getLastName() +", " + patient.getFirstName() );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Nurse otherNurse = (Nurse) obj;
        return getRegisteredNurseLicense().equals(otherNurse.getRegisteredNurseLicense()) &&
                Objects.equals(getCurrentPatients(), otherNurse.getCurrentPatients())
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegisteredNurseLicense(), getCurrentPatients());
    }

    @Override
    public String toString() {
        return super.toString() +
                " registeredNurseLicense='" + registeredNurseLicense + '\'' +
                 +
                '}';
    }
}//Class Nurse
