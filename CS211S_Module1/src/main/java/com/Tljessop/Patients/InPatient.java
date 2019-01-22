package com.Tljessop.Patients;

public class InPatient extends Patient{

    //Start of instance variables
    private int daysInResidence;
    private int floorNumber;
    private int roomNumber;
    private String attendingPhysician;
    // End of instance variables

    //Constructors
    public InPatient(String newFirstName, String newLastName, int newAge,
                     double newWeight, int newPatientIdNumber, int newRoomNumber,
                     int newFloorNumber, String newAttendingPhysician){
        super(newFirstName,newLastName,newAge,newWeight,newPatientIdNumber);
        this.attendingPhysician = newAttendingPhysician;
        this.daysInResidence = 0;
        this.floorNumber = newFloorNumber;
        this.roomNumber = newRoomNumber;
    }

    public InPatient( int newAge, double newWeight, int newPatientIdNumber, int newRoomNumber,
                     int newFloorNumber, String newAttendingPhysician){
        super(newAge,newWeight,newPatientIdNumber);
        this.attendingPhysician = newAttendingPhysician;
        this.daysInResidence = 0;
        this.floorNumber = newFloorNumber;
        this.roomNumber = newRoomNumber;
    }
    // End of constructors

    //Getters and setters

    public int getDaysInResidence() {
        return daysInResidence;
    }

    public void setDaysInResidence(int newDaysInResidence) {
        this.daysInResidence = newDaysInResidence;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int newFloorNumber) {
        this.floorNumber = newFloorNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int newRoomNumber) {
        this.roomNumber = newRoomNumber;
    }

    public String getAttendingPhysician() {
        return attendingPhysician;
    }

    public void setAttendingPhysician(String newAttendingPhysician) {
        this.attendingPhysician = newAttendingPhysician;
    }


    // This method is meant to turn a patient into a inpatient, so for inpatient objects it is overridden to return itself
    @Override
    public InPatient retainPatient(int newRoomNumber, int newFloorNumber, String newAttendingPhysician){
        return this;
    }

    // End of Getters and Setters


}//class
