package com.Tljessop.Person.Staff;

import com.Tljessop.Person.Person;

import java.util.Objects;

// M3 USING STRATEGY
public abstract class StaffMember extends Person {

    //Start of instance variables
    private String staffId;
    private int vacationDays;
    private Payer payer;
    // End of instance variables

    //Class variable
    public static int nextStaffId = 0;

    // Class constants
    public static final int DEFAULT_VACATION_DAYS = 10;
    public  static final String DEFAULT_PHONE_NUM = "(000) 000-0000";
    public static final char STAFF_ID_START_CHAR = 'E';
    // End of class constants

    //Constructors
    public StaffMember(String firstName, String lastName, Integer age,String streetAddress,
                       String phoneNumber,String socialSecurityNumber,
                       Payer payer, Integer vacationDays) throws IllegalArgumentException{
        super(firstName,lastName, age, streetAddress,phoneNumber, socialSecurityNumber);

        this.payer = payer;

        this.staffId = STAFF_ID_START_CHAR + Integer.toString(nextStaffId);
        nextStaffId++;

        //setVacationDays(vacationDays);

    }

    public StaffMember(String firstName, String lastName, int age,String streetAddress,
                       String phoneNumber,String socialSecurityNumber,
                       Payer payer) throws IllegalArgumentException {
        this(firstName,lastName,age,streetAddress,phoneNumber,socialSecurityNumber,
                payer,DEFAULT_VACATION_DAYS);
    }
    //End of Constructors

    //Getters and setters

    public int getVacationDays() {
        return vacationDays;
    }

    public int setVacationDays(int vacationDays) throws IllegalArgumentException {
        if (vacationDays < 0 ){
            this.vacationDays = vacationDays;
        } else {
            throw new IllegalArgumentException("Vacation Days must be greater than 0");
        }
        return vacationDays;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public String getStaffId() {
        return staffId;
    }

    // End of Getters and Setters

    public void pay(){
        payer.pay();
    }
    //End of getters and setters


    @Override
    public String toString() {
        return super.toString()+ " staffId='" + staffId + '\n' +
                ", vacationDays=" + vacationDays +
                "} " ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StaffMember that = (StaffMember) o;
        return getVacationDays() == that.getVacationDays() &&
                getStaffId().equals(that.getStaffId()) &&
                Objects.equals(getPayer(), that.getPayer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStaffId(), getVacationDays(), getPayer());
    }
}//Class StaffMember

