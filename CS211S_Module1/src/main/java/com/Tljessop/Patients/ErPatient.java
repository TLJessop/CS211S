package com.Tljessop.Patients;

import java.util.Date;

public class ErPatient extends Patient {

    //Start of instance variables
    private String arrivalType;
    private Date arrivalTime;
    private String chiefComplaint;
    private String attendingTriage;
    private boolean checkedIn;
    private boolean conscious;
    private String attendingPhysician;
    // End of instance variables

    //Constructors
    public ErPatient(String newFirstName, String newLastName, int newAge,
                     double newWeight, int newPatientIdNumber, String newArrivalType,
                     boolean newConscious ){
        super(newFirstName, newLastName, newAge, newWeight, newPatientIdNumber);
        this.arrivalType = newArrivalType;
        this.arrivalTime = new Date();
        this.conscious = newConscious;

    }

    public ErPatient( int newAge, double newWeight, int newPatientIdNumber, String newArrivalType,
                     boolean newConscious ){
        super(newAge, newWeight, newPatientIdNumber);
        this.arrivalType = newArrivalType;
        this.arrivalTime = new Date();
        this.conscious = newConscious;

    }
    // End of constructors


    //Getters and setters
    public String getArrivalType() {
        return arrivalType;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public String getAttendingTriage() {
        return attendingTriage;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public boolean isConscious() {
        return conscious;
    }

    public String getAttendingPhysician() {
        return attendingPhysician;
    }

    // The attending physician can only be set after a patient has been triaged
    public boolean setAttendingPhysician(String attendingPhysician) {

        if(attendingTriage != null) {
            this.attendingPhysician = attendingPhysician;
            return true;
        } else {
            return false;
        }
    }

    public boolean setCheifComplaint(String chiefComplaint) {
        if(checkedIn == true) {
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
    public void triagePatient(String newChiefComplaint, String newAttendingTriage){
        if(this.checkedIn = true){
            this.attendingTriage = newAttendingTriage;
            this.chiefComplaint = newChiefComplaint;
        }
    }


}//class
