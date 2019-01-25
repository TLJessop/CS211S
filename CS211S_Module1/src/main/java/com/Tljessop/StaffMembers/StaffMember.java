package com.Tljessop.StaffMembers;

enum PayType{ hourly, sallery}

public abstract class StaffMember {

    //Start of instance variables
    private String firstName;
    private String lastName;
    private String staffId;
    private String address;
    private String phoneNumber;
    private String socialSecuityNumber;
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
    public StaffMember(String newFirstName, String newLastName, String newAddress,
                       String newPhoneNumber,String newSocialSecurityNumber,
                       double newPayRate, PayType newPayType, int newVacationDays) throws IllegalAccessException{
         this.firstName = newFirstName;
         this.lastName = newLastName;
         this.staffId = STAFF_ID_START_CHAR + Integer.toString(nextStaffId);
         this.address = newAddress;

         if (newPhoneNumber.matches("^\\([0-9]\\)?[-.\\s]?[0-9]{3}[-.\\s]?[0-9]{4}")){
            this.phoneNumber = newPhoneNumber;
         } else {
             throw new IllegalAccessException("Please give a valid phone number");
         }

         if (newSocialSecurityNumber.matches("^[0-9]{3}-[0-9]{2}-[0-9]{4}")){
             this.socialSecuityNumber = newSocialSecurityNumber;
         } else {
             throw new IllegalAccessException("Please give a valid social secuity number");
         }

         if (newPayRate > 0){
             this.payRate = newPayRate;
         } else {
             throw new IllegalAccessException("Payrate must be a positive number");
         }

         this.payType = newPayType;

         if (newVacationDays > 0){
             this.vacationDays = newVacationDays;
         } else {
             throw new IllegalAccessException("Vacation days must be a positive number");
         }

    }

    public StaffMember(String newFirstName, String newLastName, String newAddress,
                        String newSocialSecurityNumber,
                       double newPayRate, PayType newPayType, int newVacationDays) throws IllegalAccessException{
        this(newFirstName,newLastName,newAddress,DEFAULT_PHONE_NUM,
                newSocialSecurityNumber,newPayRate,newPayType,newVacationDays);
    }

    public StaffMember(String newFirstName, String newLastName, String newAddress,
                       int newStaffIdNum, String newPhoneNumber,String newSocialSecurityNumber,
                       double newPayRate, PayType newPayType) throws IllegalAccessException{
        this(newFirstName,newLastName,newAddress,newPhoneNumber,
                newSocialSecurityNumber,newPayRate,newPayType,DEFAULT_VACATION_DAYS);
    }

    public StaffMember(String newFirstName, String newLastName, String newAddress,
                       String newPhoneNumber,String newSocialSecurityNumber,
                       double newPayRate, PayType newPayType) throws IllegalAccessException{
        this(newFirstName,newLastName,newAddress,newPhoneNumber,
                newSocialSecurityNumber,newPayRate,newPayType,DEFAULT_VACATION_DAYS);
    }

    public abstract double pay();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSocialSecuityNumber() {
        return socialSecuityNumber;
    }

    public void setSocialSecuityNumber(String socialSecuityNumber) {
        this.socialSecuityNumber = socialSecuityNumber;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }
}//class
