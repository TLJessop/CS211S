package com.Tljessop.Person.Staff;

import com.Tljessop.Person.Person;

enum PayType{
    HORULY("H"), SALLERY("S");

    private String payCode;

    private PayType(String payCode){
        this.payCode = payCode;
    }

    public String getPayCode() {
        return payCode;
    }
}

public abstract class StaffMember extends Person {

    //Start of instance variables
    private String staffId;
    private double payRate;
    private int vacationDays;
    private PayType payType;
    // End of instance variables

    //Class variable
    public static int nextStaffId = 0;

    // Class constants
    public static final int DEFAULT_VACATION_DAYS = 10;
    public  static final String DEFAULT_PHONE_NUM = "(000) 000-0000";
    public static final char STAFF_ID_START_CHAR = 'E';
    // End of class constants

    //Constructors
    public StaffMember(String firstName, String lastName, int age,String streetAddress,
                       String phoneNumber,String socialSecurityNumber,double payRate,
                       PayType payType, int vacationDays) throws IllegalAccessException{
        super(firstName,lastName, age, streetAddress,phoneNumber, socialSecurityNumber);

        setPayRate(payRate);

        this.payType = payType;

        this.staffId = STAFF_ID_START_CHAR + Integer.toString(nextStaffId);
        nextStaffId++;

        setVacationDays(vacationDays);

    }

    public StaffMember(String firstName, String lastName, int age,String streetAddress,
                       String phoneNumber,String socialSecurityNumber,double payRate,
                       PayType payType) throws IllegalAccessException {
        this(firstName,lastName,age,streetAddress,phoneNumber,socialSecurityNumber,payRate,
                payType,DEFAULT_VACATION_DAYS);
    }
    //End of Constructors

    //Getters and setters
    public double getPayRate() {
        return payRate;
    }

    public double setPayRate(double payRate) throws IllegalAccessException {
        if (payRate > 0){
            this.payRate = payRate;
        } else {
            throw new IllegalAccessException("Payrate must be a positive number");
        }
        return payRate;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public int setVacationDays(int vacationDays) throws IllegalAccessException {
        if (vacationDays > 0 ){
            this.vacationDays = vacationDays;
        } else {
            throw new IllegalAccessException("Vacation Days must be greater than 0");
        }
        return vacationDays;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public String getStaffId() {
        return staffId;
    }

    // End of Getters and Setters

    public abstract double pay();


}//Class StaffMember

