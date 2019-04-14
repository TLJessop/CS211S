package com.Tljessop.SpiderApp;

/**
 * This class holds basic taxonomic name information for a give species
 */
public class Specie implements Comparable<Specie>{

    //Instance data
    private String name;
    private String genus;

    //Constructor

    /**
     * Constructs new specie objects by taking in the two parts of their qualified name
     * @param name the individual specie name
     * @param genus the name of the species its parent genus
     */
    public Specie(String name , String genus){
        this.name = name;
        this.genus = genus;
    }

    //Getters and Setters
    // genus has a setter, but name does not this is on purpose.
    // The reasoning is a genus classing of a species can shift, but its name is fairly locked down by the time it is widely circulated in the taxonomic community

    /**
     * Retrieves the individual specie name
     * @return the specie name
     */
    public String getName(){
        return name;
    }//getName

    /**
     * Retrieves the name of the species genus
     * @return the species its parent genus
     */
    public String getGenus() {
        return genus;
    }//getGenus

    /**
     * Gives the ablity to update the species genus classing
     * @param genus the new genus classing
     */
    public void setGenus(String genus) {
        this.genus = genus;
    }//setGenus

    //End of Getters and Setters

    //Overridden methods

    /**
     * Test for equality between this specie object and another object
     * @param obj the object to be compared against
     * @return true if the passed object is logically equal with this specie, else false
     */
    @Override
    public boolean equals (Object obj){
        if (obj == null) return false;
        if (obj == this) return true;

        if(obj.getClass() == Specie.class){
            Specie otherSpecie = (Specie) obj;
            if (this.name.equalsIgnoreCase(otherSpecie.name) &&
                this.genus.equalsIgnoreCase(otherSpecie.genus)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }//if class
    }//equals

    /**
     * Presents a string representation of this specie object
     * @return the genus and specie names
     */
    @Override
    public String toString(){
        return this.genus + " " + this.name;
    }//toString

    /**
     * Setts the natural ordering of specie object by setting base of comparison
     * This base of comparison is alphabetical and ranked by the specificity of name level
     * @param otherSpecie the other specie object to be compared against
     * @return 0 if the are to bet ordering equal, a positive number to indelicate ordering seniority, or a negative number to indelicate ordering inferiority
     */
    @Override
    public int compareTo(Specie otherSpecie){
        if (this.name.compareTo(otherSpecie.name) != 0){
            return this.name.compareTo(otherSpecie.name);
        } else {
            return this.genus.compareTo(otherSpecie.genus);
        }
    }//compareTo

    //End of Overridden methods
}//Specie
