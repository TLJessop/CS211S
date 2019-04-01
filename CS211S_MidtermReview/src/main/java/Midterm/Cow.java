package Midterm;

public class Cow extends Animal {

    public Cow( String name, int age){
        super(name,age, new RawFoodFeeder());
    }
}//Cow
