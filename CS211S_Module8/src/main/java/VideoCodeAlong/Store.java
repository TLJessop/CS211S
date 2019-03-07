package VideoCodeAlong;

import java.awt.*;

public class Store {

    public static void main(String[] args) {

        Book book1 = new Book("Puppy Love", "My dog");
        Clothing pawShirt = new Shirt("PawPrintT", Clothing.Size.LARGE, Color.BLUE);
        Clothing buttonUp = new Shirt("Dress Shirt", Clothing.Size.MEDIUM, Color.BLACK);

        FeaturedSpot<Item> featuredThing = new FeaturedSpot<>();
        featuredThing.featureItem(book1,15);

        System.out.println(featuredThing+"\n");

        featuredThing.featureItem(pawShirt,40);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(featuredThing);




    }//main

}//Store
