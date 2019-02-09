package com.Tljessop.Person.Patients;

import java.time.LocalDateTime;

public class InPatient extends Patient{

    //Start of instance variables
    private LocalDateTime beginningOfResidence;
    private int floorNumber;
    private int roomNumber;
    private String attendingPhysician;
    // End of instance variables

    //Constructors
    public InPatient(String newFirstName, String newLastName, int newAge,
                     double newWeight, int newRoomNumber,
                     int newFloorNumber, String newAttendingPhysician){
        super(newFirstName,newLastName,newAge,newWeight);
        this.attendingPhysician = newAttendingPhysician;
        this.beginningOfResidence = LocalDateTime.now();
        this.floorNumber = newFloorNumber;
        this.roomNumber = newRoomNumber;
    }

    public InPatient( int newAge, double newWeight, int newRoomNumber,
                     int newFloorNumber, String newAttendingPhysician){
        super(newAge,newWeight);
        this.attendingPhysician = newAttendingPhysician;
        this.beginningOfResidence = LocalDateTime.now();
        this.floorNumber = newFloorNumber;
        this.roomNumber = newRoomNumber;
    }
    // End of constructors

    //Getters and setters

    public LocalDateTime getBeginningOfResidence() {
        return beginningOfResidence;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int newFloorNumber) throws IllegalArgumentException {
        if (newFloorNumber > 0){
            this.floorNumber = newFloorNumber;
        } else {
            throw new IllegalArgumentException("Floor Number can not be a negative number");
        }

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int newRoomNumber) throws IllegalArgumentException{
        if (newRoomNumber > 0 ){
            this.roomNumber = newRoomNumber;
        } else {
            throw new IllegalArgumentException(" Room number can not be a negative number");
        }

    }

    public String getAttendingPhysician() {
        return attendingPhysician;
    }

    public void setAttendingPhysician(String newAttendingPhysician) {
        this.attendingPhysician = newAttendingPhysician;
    }

    // End of Getters and Setters


}//class
