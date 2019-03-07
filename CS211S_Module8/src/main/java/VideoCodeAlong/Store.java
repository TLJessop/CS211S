package VideoCodeAlong;

import java.awt.*;

public class Store {

    public static void main(String[] args) {

        Book book1 = new Book("Puppy Love", "My dog");
        Clothing pawShirt = new Shirt("PawPrintT", Clothing.Size.LARGE, Color.BLUE);
        Clothing buttonUp = new Shirt("Dress Shirt", Clothing.Size.MEDIUM, Color.BLACK);

        FeaturedSpot<Item> featuredThing = new FeaturedSpot<>();
        featuredThing.featureItem(book1,15);

        FeaturedSpot<Clothing> featuredClothing = new FeaturedSpot<>();
        featuredClothing.featureItem(buttonUp,60);

        System.out.println(featuredThing+"\n");

        featuredThing.featureItem(pawShirt,40);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(featuredThing);

        System.out.println();

        printItem(featuredThing);

        System.out.println();

        printItem(featuredClothing);

        System.out.println();
        featureNewItem(featuredThing);
    }//main

    //Upper bounded example
    public static void printItem(FeaturedSpot<? extends Item> spot){
        Item item = spot.getItem();
        System.out.println(item);
    }

    //Lower bounded example
    public static void featureNewItem(FeaturedSpot<? super Item> spot){
        Book book = new Book("Java for Puppies", "My dog");
        spot.featureItem(book,50);
        System.out.println(spot.getItem()+"\n");

        Shirt tShirt = new Shirt("A realy cool shirt", Clothing.Size.MEDIUM,Color.GREEN);
        spot.featureItem(tShirt,40);
        System.out.println(spot.getItem());

    }

}//Store
