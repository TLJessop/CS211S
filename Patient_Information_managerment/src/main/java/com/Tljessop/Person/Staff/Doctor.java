package com.Tljessop.Person.Staff;


import com.Tljessop.Person.Patients.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Doctor extends StaffMember{

    //Instance variables
    private String medicalLicenseNumber;
    private String speciality;
    private List<Patient> curentPatients;
    //End of instance variables

    //Constructor
    private Doctor(DoctorBuilder builder){

        super(builder.firstName, builder.lastName, builder.age,builder.streetAddress,
               builder.phoneNumber,builder.socialSecurityNumber, new SalaryPayer(builder.payRate));

        this.medicalLicenseNumber = builder.medicalLicenseNumber;
        this.speciality = builder.speicallty;
        curentPatients = new ArrayList<>();
    }

    public static class DoctorBuilder{

        //innerclass instance variables
       private String firstName;
        private String lastName;
        private Integer age;
        private String streetAddress;
        private String phoneNumber;
        private  String socialSecurityNumber;
        private  Double payRate;
        private  String medicalLicenseNumber;
        private String speicallty;
        //end of innerclass instance variables

        //innerclass default constructor
        public DoctorBuilder(){}

        //field methods
        public DoctorBuilder fistName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public DoctorBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public DoctorBuilder speicallty(String speicallty){
            this.speicallty = speicallty;
            return this;
        }

        public DoctorBuilder streetAddress(String streetAddress){
            this.streetAddress = streetAddress;
            return this;
        }

        public DoctorBuilder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public DoctorBuilder socialSecurityNumber(String socialSecurityNumber){
            this.socialSecurityNumber = socialSecurityNumber;
            return this;
        }

        public DoctorBuilder medicalLicenseNumber(String medicalLicenseNumber){
            this.medicalLicenseNumber = medicalLicenseNumber;
            return this;
        }

        public DoctorBuilder age(int age){
            this.age = age;
            return this;
        }

        public DoctorBuilder payRate(double payRate){
            this.payRate = payRate;
            return this;
        }
        //End of field methods

        //Build method
        public Doctor build(){
            Doctor doctor = new Doctor(this);

            if(this.firstName==null || this.age == null || this.lastName ==null ||
            this.payRate == null ||this.streetAddress == null  ||
            this.socialSecurityNumber == null || this.phoneNumber == null || payRate == null
            ) {
                throw new IllegalStateException();
            } else {
                return new Doctor(this);
            }
        }
    }//DoctorBuilder

    //Getters and Setters
    public String getMedicalLicenseNumber() {
        return medicalLicenseNumber;
    }

    public void setMedicalLicenseNumber(String medicalLicenseNumber) {
        this.medicalLicenseNumber = medicalLicenseNumber;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<Patient> getCurentPatients() {
        return curentPatients;
    }

    // End of Getters and Setters

    public boolean addPatient(Patient patient){
        return curentPatients.add(patient);
    }


    public void listPatients(){
        for (Patient patient : curentPatients
                ) { System.out.println("Patient Id:" + patient.getPatientIdNumber() + "  Name: " + patient.getLastName()
                +", " + patient.getFirstName()  );

        }
    }

    public void prescibe(String medication, int listPositon){
        System.out.println("Prescibing " + medication + " to " + curentPatients.get(listPositon).getLastName() +
                ", " + curentPatients.get(listPositon).getFirstName());
    }

    public Patient relaseFromCare(Patient patient){
        if (curentPatients.contains(patient)){
            curentPatients.remove(patient);
            return patient;
        } else {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return getMedicalLicenseNumber().equals(doctor.getMedicalLicenseNumber()) &&
                getSpeciality().equals(doctor.getSpeciality());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMedicalLicenseNumber(), getSpeciality());
    }

    @Override
    public String toString() {
        return  "Doctor{" + "Name= "+ super.getLastName() + ", " + super.getFirstName() +
                "medicalLicenseNumber='" + medicalLicenseNumber + '\'' +
                ", speciality='" + speciality + '\'' +
                ", curentPatients=" + Arrays.toString(curentPatients.toArray())  +
                '}';
    }
}//Class Doctor
