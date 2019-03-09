package SpiderApp;

public class Specie {

    private String name;
    private Genus genus;

    public Specie(String name , Genus genus){
        this.name = name;
        this.genus = genus;
    }

    public String getName(){
        return name;
    }

    public Genus getGenus() {
        return genus;
    }

    public void setGenus(Genus genus) {
        this.genus = genus;
    }
}//Specie
