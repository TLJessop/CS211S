package SpiderApp;

import java.util.ArrayList;
import java.util.List;

public class Genus {

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
}//Genus
