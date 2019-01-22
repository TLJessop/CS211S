package com.Tljessop.Patients;

public abstract class Patient {

    //Start of instance variables
    private  String firstName;
    private String lastName;
    private int age;
    private double weight;
    private String patientIdNumber;
    // End of instance variables

    // Class constants
    public static final char PATIENT_ID_START_CHAR = 'W';
    public static final int DEFAULT_PATIENT_ID_NUM = 000000;

    // In theory we might not sometimes be able to get a new patient's name right away
    public static final String DEFAULT_FIRST_NAME = "NFN"; // This is shorthand for no first name
    public static final String DEFUALT_LAST_NAME = "NLN"; // This is shorthand for no last name
    // End of class constants

    //Constructors
    public Patient(String newFirstName, String newLastName, int newAge,
                   double newWeight, int newPatientIdNumber){
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.age = newAge;
        this.weight = newWeight;
        this.patientIdNumber = PATIENT_ID_START_CHAR + Integer.toString(newPatientIdNumber);

    }

    public Patient( String newFirstName, String newLastName, int newAge,
                    double newWeight ){
        this(newFirstName,newLastName,newAge,newWeight,DEFAULT_PATIENT_ID_NUM);
    }


    public  Patient(int newAge, double newWeight, int newPatientIdNumber){

        this(DEFAULT_FIRST_NAME,DEFUALT_LAST_NAME,newAge,newWeight,newPatientIdNumber);
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

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double newWeight) {
        this.weight = weight;
    }

    public String getPatientIdNumber() {
        return patientIdNumber;
    }

    // This setter takes the number part of the patient id, but will not allow for that number to match the DEFAULT_PATIENT_ID_NUM
    // This is to enforce the preface char of the patient id
    public void setPatientIdNumber(int newPatientIdNumber) throws IllegalAccessException{
        if (newPatientIdNumber!= DEFAULT_PATIENT_ID_NUM){
            this.patientIdNumber = PATIENT_ID_START_CHAR + Integer.toString(newPatientIdNumber);
        } else {
            throw new IllegalAccessException("New patient id must not match the default id");
        }
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

        if (obj instanceof Patient){
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
    //End of overwrote methods

    public void discharge(){
        System.out.println("Patient : " + this.getLastName() + ", " +
                this.getFirstName() + " has been release from active care" +
                "\n" + "There profile has been converted to an archive file");
    }

    public InPatient retainPatient(int newRoomNumber, int newFloorNumber, String newAttendingPhysician){
        return new InPatient(this.getFirstName(),this.getLastName(),this.getAge(),
                this.getWeight(), Integer.parseInt(this.getPatientIdNumber().substring(1)),
                newRoomNumber,newFloorNumber, newAttendingPhysician);
    }

}//class Patient
