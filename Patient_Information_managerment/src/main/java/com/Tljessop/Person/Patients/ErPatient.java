package com.Tljessop.Person.Patients;

import com.Tljessop.Person.Staff.Doctor;
import com.Tljessop.Person.Staff.Nurse;

import java.time.LocalDateTime;

public class ErPatient extends Patient {

    //Start of instance variables
    private String arrivalType;
    private LocalDateTime arrivalTime;
    private String chiefComplaint;
    private Nurse attendingTriage;
    private boolean checkedIn;
    private boolean conscious;
    private Doctor attendingPhysician;
    // End of instance variables

    //Constructors
    public ErPatient(String newFirstName, String newLastName, int newAge,
                     double newWeight,  String newArrivalType,
                     boolean newConscious ){
        super(newFirstName, newLastName, newAge, newWeight);
        this.arrivalType = newArrivalType;
        this.arrivalTime = LocalDateTime.now();
        this.conscious = newConscious;

    }

    public ErPatient( int newAge, double newWeight, String newArrivalType,
                     boolean newConscious ){
        super(newAge, newWeight);
        this.arrivalType = newArrivalType;
        this.arrivalTime = LocalDateTime.now();
        this.conscious = newConscious;

    }
    // End of constructors


    //Getters and setters
    public String getArrivalType() {
        return arrivalType;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public Nurse getAttendingTriage() {
        return attendingTriage;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public boolean isConscious() {
        return conscious;
    }

    public Doctor getAttendingPhysician() {
        return attendingPhysician;
    }

    // The attending physician can only be set after a patient has been triaged
    public boolean setAttendingPhysician(Doctor attendingPhysician) {

        if(attendingTriage != null) {
            this.attendingPhysician = attendingPhysician;
            return true;
        } else {
            return false;
        }
    }

    public boolean setCheifComplaint(String chiefComplaint) {
        if(checkedIn) {
            this.chiefComplaint = chiefComplaint;
            return true;
        } else {
            return false;
        }
    }

    // End of Getters and Setters

    // Upon checking in the chief complaint will be assessed
    public void checkIn(String newChefComplaint){
        this.chiefComplaint = newChefComplaint;
        this.checkedIn = true;
    }

    // Triage can only happen after checking in
    // During triage the chief complaint will be reassessed
    public void triagePatient(String newChiefComplaint, Nurse newAttendingTriage){
        if(this.checkedIn){
            this.attendingTriage = newAttendingTriage;
            this.chiefComplaint = newChiefComplaint;
        }
    }


}//class
