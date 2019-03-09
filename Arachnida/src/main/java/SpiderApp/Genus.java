package SpiderApp;

import java.util.ArrayList;
import java.util.List;

public class Genus implements Comparable<Genus>{

    //Instance data
    private String name;

    //Constructor
    public Genus(String name){
        this.name = name;
    }

    // The lack of a name setter is because I don't think that should be changeable
    //Getter method
    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return this.name ;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;

        if (obj.getClass() == Genus.class){
            Genus otherGenus = (Genus) obj;
            return this.name == otherGenus.name;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Genus otherGenus){
            return this.name.compareTo(otherGenus.name);
    }
}//Genus
