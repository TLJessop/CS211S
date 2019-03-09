package SpiderApp;

import java.util.ArrayList;
import java.util.List;

public class Genus implements Comparable<Genus>{

    /*
        instance data variables
constructor
getters/setters
toString
equals method
compareTo method (the class should implement Comparable<MyClass>)
     */

    private String name;
    private List<Specie> speciesList;

    public Genus(String name){
        this.name = name;
        speciesList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSpecices(){
        return speciesList.size();
    }

    public boolean addSpecies(Specie specie){
        return speciesList.add(specie);
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;

        if (obj.getClass() == Genus.class){
            Genus otherGenus = (Genus) obj;

            if(this.name == otherGenus.name){
                return true;
            } else {
                if (this.getNumberOfSpecices() == otherGenus.getNumberOfSpecices()) {
                    if (this.speciesList.containsAll(otherGenus.speciesList) && otherGenus.speciesList.containsAll(this.speciesList)) {
                        return true;
                    } else {
                        return false;
                    }
                } else return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public int compareTo(Genus otherGenus){
        if (this.name.compareTo(otherGenus.name) != 0){
            return this.name.compareTo(otherGenus.name);
        } else {
            return Integer.compare(this.getNumberOfSpecices(), otherGenus.getNumberOfSpecices());
        }
    }
}//Genus
