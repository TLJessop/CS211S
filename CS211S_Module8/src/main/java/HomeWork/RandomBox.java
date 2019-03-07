package HomeWork;

import java.util.ArrayList;
import java.util.List;

/**
 * This class hold a list of the specifed type and can return a random item from that list
 * @param <T> The type of item that the RandomBox is instantiated with.
 * @author Thomas Jessop
 * @since 2019-03-07
 * @version 1.0
 */
public class RandomBox<T> {

    //Instance data
    private List<T> itemList;

    //Constructor

    /**
     * No argument constructor that instantiates the item list
     */
    public RandomBox(){
        itemList = new ArrayList<>();
    }

    /**
     * Adds a new item to the box
     * @param newItem the item to be added
     */
    public void addItem(T newItem){
        itemList.add(newItem);
    }

    /**
     * Returns an item from the box at the given index
     * @param index the give position of the desired item
     * @return the item that was at the give index
     * @throws IllegalArgumentException This exception is thrown if the given index is less than 0 or greater than the number of items in the box
     */
    private T getItem(int index){
        if(index > 0 && index < itemList.size()) {
            return itemList.get(index);
        } else {
            throw new IllegalArgumentException("Not a valid index");
        }
    }

    /**
     * Pick random box item
     * @return the winning item
     * @throws IllegalStateException This exception is thrown if this method is called on a empty box
     */
    public T drawWinner(){
        if(itemList.size() != 0) {
            return itemList.get((int) (Math.random() * itemList.size()));
        } else {
            throw new IllegalStateException("A winner can not be drawn from a empty box");
        }
    }

    /**
     * Prints the entries of the box to the console
     */
    public void displayEntries(){
        System.out.println("RandomBox Entries:");
        for (T item: itemList
             ) {
            System.out.println("\t"+item);
        }
    }

    //Overridden methods

    /**
     * Represents the box as a String
     * @return A String representing the contents of the box
     */
    @Override
    public String toString(){
        return "RandomBox holding :\t" + itemList.toString();
    }

    /**
     * Test to see if the argument is equal RandomBox.
     * @param obj the object to be tested against for equality
     * @return returns true if the in passed object is a RandomBox with the same contents, else returns false
     */
    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;

        if (obj instanceof RandomBox<?>){
            RandomBox<?> otherBox = (RandomBox<?>) obj;
            if (this.itemList.size() == otherBox.itemList.size()){
                return itemList.containsAll(otherBox.itemList) && otherBox.itemList.containsAll(this.itemList);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}//RandomBox