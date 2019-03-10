package SpiderApp;

public class Specie implements Comparable<Specie>{

    private String name;
    private String genus;

    public Specie(String name , String genus){
        this.name = name;
        this.genus = genus;
    }

    public String getName(){
        return name;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    @Override
    public boolean equals (Object obj){
        if (obj == null) return false;
        if (obj == this) return true;

        if(obj.getClass() == Specie.class){
            Specie otherSpecie = (Specie) obj;
            if (this.name.equalsIgnoreCase(otherSpecie.name) &&
                this.genus.equals(otherSpecie.genus)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public int compareTo(Specie otherSpecie){
        if (this.name.compareTo(otherSpecie.name) != 0){
            return this.name.compareTo(otherSpecie.name);
        } else {
            return this.genus.compareTo(otherSpecie.genus);
        }
    }
}//Specie
