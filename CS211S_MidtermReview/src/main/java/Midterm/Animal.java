package Midterm;

import java.util.Comparator;

public abstract class Animal implements Comparable<Animal> {

    private String name;
    private int age;
    private Feeder feeder;
    private AnimalStatus status;

    public static final Comparator<Animal> ANIMAL_COMPARATOR = new AnimalNameComparator();

    public static class AnimalNameComparator implements Comparator<Animal> {
        @Override
        public int compare(Animal a, Animal b){
            return a.name.compareToIgnoreCase(b.name);
        }

    }

    public static enum AnimalStatus{

        NEW(false), SHORT_TERM(true), LONG_TERM(false), NO_LONGER_RESIDING(false);

        private boolean adoptable;

        private AnimalStatus(boolean adoptable){
            this.adoptable = adoptable;
        }

        public boolean getAdoptable(){
            return adoptable;
        }
    }


    public Animal(String name, int age, Feeder feeder) {
        this.name = name;
        this.feeder = feeder;
        this.age = age;
        this.status = AnimalStatus.NEW;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    public Feeder getFeeder() {
        return feeder;
    }

    public void setFeeder(Feeder feeder) {
        this.feeder = feeder;
    }

    public void feedAnimal(){
        this.feeder.feed();
    }

    public AnimalStatus getStatus() {
        return status;
    }

    public void setStatus(AnimalStatus status) {
        this.status = status;
    }

    public void adopt(){
        this.status = AnimalStatus.NO_LONGER_RESIDING;
    }
    @Override
    public String toString() {
        return name + " (Age: " + age + ")";
    }


    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;

        if (obj instanceof Animal){
            Animal otherAnimal = (Animal) obj;

            if (this.name.equalsIgnoreCase(otherAnimal.name) &&
                this.age == otherAnimal.age){
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Animal other){
        if (Integer.compare(this.age, other.age) != 0){
            return Integer.compare(this.age, other.age);
        } else {
            return this.name.compareToIgnoreCase(other.name);
        }
    }
}

