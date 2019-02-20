package ModleViewerSimple;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ErPatient extends Patient {

    //Start of instance variables
    private LocalDateTime arrivalTime;
    private String chiefComplaint;
    private boolean conscious;
    // End of instance variables

    //Static patient holder
    private static List<ErPatient> patients = new ArrayList<>();

    //Static methods for the patient list
    public static int getNumberOfPatients(){
        return patients.size();
    }

    public static void addPatient( ErPatient patient ){
        patients.add(patient);
    }

    public static void removePatient(ErPatient patient){
        patients.remove(patient);
    }

    public static List<ErPatient> getList(){
        return patients;
    }

    //Constructor
    public ErPatient(String newFirstName, String newLastName, int newAge,double newWeight,
                     boolean newConscious ){
        super(newFirstName, newLastName, newAge, newWeight);
        this.arrivalTime = LocalDateTime.now();
        this.conscious = newConscious;

    }

    // End of constructor


    //Getters and setters

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }



    public boolean isConscious() {
        return conscious;
    }


    public void setCheifComplaint(String chiefComplaint) {

        this.chiefComplaint = chiefComplaint;

        }

    // End of Getters and Setters


    @Override
    public String toString() {
        return super.toString() + "\nCheif Complaint :" + chiefComplaint;
    }
}//class
