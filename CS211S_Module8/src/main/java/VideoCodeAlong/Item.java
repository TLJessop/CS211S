package VideoCodeAlong;

public abstract class Item implements Comparable<Item> {

    //Instance data
    private String name;

    //Constructor
    public Item(String name) {
        this.name = name;
    }


    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    //End of Getters and Setters

    @Override
    public int compareTo(Item otherItem) {
            return this.name.compareTo(otherItem.name);
    }

    @Override
    public String toString() {
        return  name ;
    }
}//Item
