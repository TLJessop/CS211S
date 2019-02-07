package com.Tljessop.Person;

import java.util.Objects;

public class Person {

    //Start of instance variables
    private String firstName;
    private String lastName;
    private Integer age;
    private String address;
    private String phoneNumber;
    private String socialSecurityNumber;
    private Double weight;
    private String phoneNumer;
    private String socialSecuityNumber;
    private String streetAddress;

    // End of instance variables

    public Person(String firstName, String lastName, int age, String streetAddress, String phoneNumber,
                  String socialSecurityNumber)  throws IllegalArgumentException{
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.streetAddress = streetAddress;

        if (phoneNumber.matches("^\\([0-9]{3}\\)?[-.\\s]?[0-9]{3}[-.\\s]?[0-9]{4}")){
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Please give a valid phone number");
        }

        if (socialSecurityNumber.matches("^[0-9]{3}-[0-9]{2}-[0-9]{4}")){
            this.socialSecuityNumber = socialSecurityNumber;
        } else {
            throw new IllegalArgumentException("Please give a valid social secuity number");
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

    public void setAge(int newAge) throws IllegalArgumentException{
        if (newAge > 0){
            this.age = newAge;
        } else {
            throw new IllegalArgumentException("Age can not be a negative number");
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

    public void setWeight(double newWeight) throws IllegalArgumentException {
        if (newWeight > 0){
            this.weight = newWeight;
        } else {
            throw new IllegalArgumentException("Weight can not be a negative number");
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", weight=" + weight +
                ", phoneNumer='" + phoneNumer + '\'' +
                ", socialSecuityNumber='" + socialSecuityNumber + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getLastName(), person.getLastName()) &&
                Objects.equals(getAge(), person.getAge()) &&
                Objects.equals(getAddress(), person.getAddress()) &&
                Objects.equals(getPhoneNumber(), person.getPhoneNumber()) &&
                Objects.equals(getSocialSecurityNumber(), person.getSocialSecurityNumber()) &&
                Objects.equals(getWeight(), person.getWeight()) &&
                Objects.equals(phoneNumer, person.phoneNumer) &&
                Objects.equals(socialSecuityNumber, person.socialSecuityNumber) &&
                Objects.equals(streetAddress, person.streetAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAge(), getAddress(), getPhoneNumber(), getSocialSecurityNumber(), getWeight(), phoneNumer, socialSecuityNumber, streetAddress);
    }

}//Class Person
