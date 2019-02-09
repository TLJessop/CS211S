package com.Tjessop.VideoCodeAlong;

public class Address {

    private String number;
    private String street1;
    private String street2;
    private String city;
    private String State;
    private int zipCode;
    private String country;

    private static final String DEFAULT_STREET2 = "";

    public Address(String number, String street1, String street2, String city, String state, int zipCode, String country) {
        this.number = number;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        State = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    public Address(String number, String street1, String city, String state, int zipCode, String country) {
        this(number,street1,DEFAULT_STREET2,city,state,zipCode,country);
    }

    //Getters and Setters

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    //End of getters and setters

}//Class Address
