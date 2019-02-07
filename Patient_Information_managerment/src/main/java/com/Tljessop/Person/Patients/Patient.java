package com.Tljessop.Person.Patients;


import com.Tljessop.Person.Person;

import java.util.Comparator;
import java.util.Objects;

enum PatientStatus {
    ACTIVE("A"),INACTIVE("IA");
    private String statusCode;
    private PatientStatus(String statusCode){
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "PatientStatus{" +
                "statusCode='" + statusCode + '\'' +
                '}';
    }
}

public abstract class Patient extends Person  implements Comparable<Patient> {

    //Start of instance variables
    private String patientIdNumber;
    private PatientStatus patientStatus;
    // End of instance variables

    // M2 HOMEWORK STATIC
    //Class variable
    private static int nextPatientId = 0 ;


    // Class constants
    private static final char PATIENT_ID_START_CHAR = 'W';

    public static FirstNameComparator FIRST_NAME_COMPARE = new FirstNameComparator();
    public static AgeComparator AGE_COMPARE = new AgeComparator();
    public static PatientIdComparator ID_COMPARE = new PatientIdComparator();

    // In theory we might not sometimes be able to get a new patient's name right away
    private static final String DEFAULT_FIRST_NAME = "NFN"; // This is shorthand for no first name
    private static final String DEFAULT_LAST_NAME = "NLN"; // This is shorthand for no last name
    // End of class constants

    //Constructors
    public Patient(String newFirstName, String newLastName, int newAge,
                   double newWeight ){
      super(newFirstName,newLastName,newAge,newWeight);
        // M2 HOMEWORK ENUM USE
        this.patientStatus = PatientStatus.ACTIVE;
        this.patientIdNumber = PATIENT_ID_START_CHAR + Integer.toString(nextPatientId);
        nextPatientId ++;
    }

    public  Patient(int newAge, double newWeight){

        this(DEFAULT_FIRST_NAME,DEFAULT_LAST_NAME,newAge,newWeight);
    }
    // End of constructors

    //Getters and setters

    public String getPatientIdNumber() {
        return patientIdNumber;
    }

    public PatientStatus getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(PatientStatus patientStatus) {
        this.patientStatus = patientStatus;
    }

    // End of Getters and Setters

    // Overwrote methods

    @Override
    public String toString(){
        return "Patient name : " + super.getLastName() + ", " + super.getFirstName() + "\n"
                + "Patient ID : " + this.patientIdNumber + "\n"
                + "Patient age : " + super.getAge() + "\n"
                + "Patient weight : " + super.getWeight() ;
    }

    /*
        There is probably a cleaner way to write this with less casting.
        Without the ability to instantiate my patient class this is the best I could come up with for now
     */
    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }

        if (obj == this){
            return true;
        }

        if (obj.getClass() == this.getClass()){
            if (this.patientIdNumber.equals( ( (Patient) obj).getPatientIdNumber() )
                    && super.getFirstName().equals( ((Patient) obj).getFirstName() )
                    && super.getLastName().equals(((Patient) obj).getLastName())){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.getAge(), super.getAge(), super.getLastName(),
                this.patientIdNumber, super.getWeight());
    }

    @Override
    public int compareTo(Patient otherPatient){
        if (super.getLastName().compareToIgnoreCase(otherPatient.getLastName()) !=0){
            return super.getLastName().compareToIgnoreCase(otherPatient.getLastName());
        } else if(super.getFirstName().compareToIgnoreCase(otherPatient.getFirstName()) !=0){
            return super.getFirstName().compareToIgnoreCase(otherPatient.getFirstName());
        }else {
            return this.patientIdNumber.compareToIgnoreCase(otherPatient.patientIdNumber);
        }
    }
    //End of overwrote methods

    private static class FirstNameComparator implements Comparator<Patient>{
        @Override
        public int compare(Patient p1, Patient p2){
            return p1.getFirstName().compareToIgnoreCase(p2.getFirstName());
        }
    }

    private static class AgeComparator implements Comparator<Patient>{
        @Override
        public int compare(Patient p1, Patient p2){
            return Integer.compare(p1.getAge(), p2.getAge());
        }
    }

    private static class PatientIdComparator implements Comparator<Patient>{
        @Override
        public int compare(Patient p1, Patient p2){
            return p1.patientIdNumber.compareTo(p2.patientIdNumber);
        }
    }

    // M2 HOMEWORK ENUM USE
    public void discharge(){
        this.patientStatus = PatientStatus.INACTIVE;
        System.out.println("Patient : " + this.getLastName() + ", " +
                this.getFirstName() + " has been release from active care" +
                "\n" + "There profile has been converted to an archive file");
    }

    public static InPatient retainPatient(Patient patient, int newRoomNumber, int newFloorNumber, String newAttendingPhysician){
        return new InPatient(patient.getFirstName(),patient.getLastName(),patient.getAge(),
                patient.getWeight(), newRoomNumber,newFloorNumber, newAttendingPhysician);
    }


}//class Patient
