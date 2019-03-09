package SpiderApp;

import java.util.ArrayList;
import java.util.List;

public class Genus {

    private String name;
    private List<Specice> speciesList;

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

    public boolean addSpecies(Specice specice){
        return speciesList.add(specice);
    }
}//Genus
