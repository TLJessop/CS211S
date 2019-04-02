package ModleViewerSimple;

import java.util.Objects;

public class Person {

    //Start of instance variables
    private String firstName;
    private String lastName;
    private Integer age;
    private Double weight;

    // End of instance variables


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
                ", age=" + age + ", weight=" + weight +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getLastName(), person.getLastName()) &&
                Objects.equals(getAge(), person.getAge());
                             }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAge(), getWeight());
    }

}//Class Person
