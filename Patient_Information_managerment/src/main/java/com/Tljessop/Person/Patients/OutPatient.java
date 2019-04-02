package com.Tljessop.Person.Patients;

public class OutPatient extends Patient {

    //Start of instance variables
    private String reveringPhysician;
    private String departmentRefereedTo;
    private int referralIdNumber;
    // End of instance variables

    // Class constants
    public static final String DEFUALT_DEPARTMENT_REFERIAL = "General Care";
    public static final int DEFAULT_REFERIAL_ID = 000000;

    public OutPatient(String newFirstName, String newLastName, int newAge,
                      double newWeight, String newReferingPhysican,
                      String newDepartmentRefereedTo, int newReferralIdNumber){
        super(newFirstName,newLastName,newAge,newWeight);
        this.reveringPhysician = newReferingPhysican;
        this.departmentRefereedTo = newDepartmentRefereedTo;
        this.referralIdNumber = newReferralIdNumber;
    }

    //Constructors
    public OutPatient(String newFirstName, String newLastName, int newAge,
                      double newWeight, String newReferingPhysican,String newDepartmentReferedTo){
        this(newFirstName,newLastName, newAge, newWeight,
                newReferingPhysican,newDepartmentReferedTo, DEFAULT_REFERIAL_ID);
    }

    public OutPatient(String newFirstName, String newLastName, int newAge,
                      double newWeight, String newReferingPhysican, int newReferalIdNumber){
        this(newFirstName,newLastName, newAge, newWeight,
                newReferingPhysican,DEFUALT_DEPARTMENT_REFERIAL, newReferalIdNumber);
    }

    public OutPatient(String newFirstName, String newLastName, int newAge,
                      double newWeight, String newReferingPhysican){
        this(newFirstName,newLastName, newAge, newWeight,
                newReferingPhysican,DEFUALT_DEPARTMENT_REFERIAL, DEFAULT_REFERIAL_ID);
    }
    // End of constructors

    //Getters and setters
    public String getDepartmentRefereedTo() {
        return departmentRefereedTo;
    }

    public void setDepartmentRefereedTo(String newDepartmentReferedTo) {
        this.departmentRefereedTo = newDepartmentReferedTo;
    }

    public int getReferralIdNumber() {
        return referralIdNumber;
    }

    public void setReferralIdNumber(int newReferalIdNumber) {
        this.referralIdNumber = newReferalIdNumber;
    }

    public String getReveringPhysician() {
        return reveringPhysician;
    }
    // End of Getters and Setters

    public void revisitNeeded(String newReveringPhysician, String newDepartmentRefereedTo, int newReferralIdNumber){
       this.reveringPhysician  = newReveringPhysician;
       this.departmentRefereedTo = newDepartmentRefereedTo;
       this.referralIdNumber = newReferralIdNumber;
    }

}//class