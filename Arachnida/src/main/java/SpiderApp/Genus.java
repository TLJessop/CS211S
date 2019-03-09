package SpiderApp;

import java.util.ArrayList;
import java.util.List;

public class Genus {

    private String name;
    private List<Specice> speciceList;

    public Genus(String name){
        this.name = name;
        speciceList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSpecices(){
        return speciceList.size();
    }

    public boolean addSpecies(Specice specice){
        return speciceList.add(specice);
    }
}//Genus
