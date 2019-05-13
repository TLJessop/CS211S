package Homework;

import java.time.LocalDate;

@Documentation( nameOfDocFile = "Dog Spec",
        locationOfDocFile = "github.com/dogrepo")
public class Dog {
    //Instance data
    private String name;
    private String ownerName;
    private String breed;
    private LocalDate birthDate;

    //Constructor
    public Dog(String name, String ownerName, String breed, LocalDate brithDate) {
        this.name = name;
        this.ownerName = ownerName;
        this.breed = breed;
        this.birthDate = brithDate;
    }

    //Getter and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    @Documentation( nameOfDocFile = "Dog Spec",
                    locationOfDocFile = "github.com/dogrepo",
                    documentationStatus = Documentation.Status.FULLLY_DOCUMENTED)
    public int getAge(){
        return LocalDate.now().getYear() - birthDate.getYear();
    }

}//Dog
