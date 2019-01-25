package com.Tljessop.Patients;

import java.util.Objects;

public abstract class Patient {

    //Start of instance variables
    private  String firstName;
    private String lastName;
    private int age;
    private double weight;
    private String patientIdNumber;
    // End of instance variables

    //Class variable
    private static int nextPatientId = 0 ;


    // Class constants
    private static final char PATIENT_ID_START_CHAR = 'W';

    // In theory we might not sometimes be able to get a new patient's name right away
    private static final String DEFAULT_FIRST_NAME = "NFN"; // This is shorthand for no first name
    private static final String DEFAULT_LAST_NAME = "NLN"; // This is shorthand for no last name
    // End of class constants

    //Constructors
    public Patient(String newFirstName, String newLastName, int newAge,
                   double newWeight ){
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.age = newAge;
        this.weight = newWeight;
        this.patientIdNumber = PATIENT_ID_START_CHAR + Integer.toString(nextPatientId);
        nextPatientId ++;
    }

    public  Patient(int newAge, double newWeight){

        this(DEFAULT_FIRST_NAME,DEFAULT_LAST_NAME,newAge,newWeight);
    }
    // End of constructors

    //Getters and setters
    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) throws IllegalAccessException{
        if (newAge > 0){
            this.age = newAge;
        } else {
            throw new IllegalAccessException("Age can not be a negative number");
        }

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double newWeight) throws IllegalAccessException{
        if (newWeight > 0){
            this.weight = newWeight;
        } else {
            throw new IllegalAccessException("Weight can not be a negative number");
        }

    }

    public String getPatientIdNumber() {
        return patientIdNumber;
    }

    // End of Getters and Setters

    // Overwrote methods

    @Override
    public String toString(){
        return "Patient name : " + this.lastName + ", " + this.firstName + "\n"
                + "Patient ID : " + this.patientIdNumber + "\n"
                + "Patient age : " + this.age + "\n"
                + "Patient weight : " + this.weight ;
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
                    && this.firstName.equals( ((Patient) obj).getFirstName() )
                    && this.lastName.equals(((Patient) obj).getLastName())){
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
        return Objects.hash(this.age, this.firstName, this.lastName,
                this.patientIdNumber, this.weight);
    }
    //End of overwrote methods

    public void discharge(){
        System.out.println("Patient : " + this.getLastName() + ", " +
                this.getFirstName() + " has been release from active care" +
                "\n" + "There profile has been converted to an archive file");
    }

    public static InPatient retainPatient(Patient patient, int newRoomNumber, int newFloorNumber, String newAttendingPhysician){
        return new InPatient(patient.getFirstName(),patient.getLastName(),patient.getAge(),
                patient.getWeight(), newRoomNumber,newFloorNumber, newAttendingPhysician);
    }

}//class Patient
