package com.Tljessop.Person;

public class Person {

    //Start of instance variables
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String phoneNumber;
    private String socialSecurityNumber;
    private double weight;
    private String phoneNumer;
    private String socialSecuityNumber;
    private String streetAddress;

    // End of instance variables

    public Person(String firstName, String lastName, int age, String streetAddress, String phoneNumber,
                  String socialSecurityNumber)  throws IllegalAccessException{
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.streetAddress = streetAddress;

        if (phoneNumber.matches("^\\([0-9]\\)?[-.\\s]?[0-9]{3}[-.\\s]?[0-9]{4}")){
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalAccessException("Please give a valid phone number");
        }

        if (socialSecurityNumber.matches("^[0-9]{3}-[0-9]{2}-[0-9]{4}")){
            this.socialSecuityNumber = socialSecurityNumber;
        } else {
            throw new IllegalAccessException("Please give a valid social secuity number");
        }

    }

    public Person(String firstName, String lastName, int age, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) throws IllegalAccessException{
        if (newAge > 0){
            this.age = newAge;
        } else {
            throw new IllegalAccessException("Age can not be a negative number");
        }

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

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double newWeight) throws IllegalAccessException{
        if (newWeight > 0){
            this.weight = newWeight;
        } else {
            throw new IllegalAccessException("Weight can not be a negative number");
        }

    }



}//Class Person
