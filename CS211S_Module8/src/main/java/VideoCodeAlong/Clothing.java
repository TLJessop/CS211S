package VideoCodeAlong;

public abstract class Clothing extends Item implements Comparable<Item> {

    public enum Size {SMALL, MEDIUM, LARGE};

    private Size size;

    public Clothing(String name, Size size){
        super(name);
        this.size = size;
    }


    @Override
    public String toString() {
        return super.toString() +
                " size " + size ;
    }

    @Override
    public int compareTo(Item other){
        return 0;
    }
}//Clothing
