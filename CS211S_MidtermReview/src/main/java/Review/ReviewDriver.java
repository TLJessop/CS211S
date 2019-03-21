package Review;

import java.io.*;
import java.util.*;

public class ReviewDriver {

    public static void main(String[] args){

        Map<String, Integer> nameAndPhone = new HashMap<String, Integer>();

        boolean keepAdding = true;

        Scanner userInput = new Scanner(System.in);

        System.out.println("Please give names and phone numbers to add to the map\n\tPlease give phone numbers as integers");
        while (keepAdding){
            String name = null;
            Integer phone = null;

            System.out.print("Please give a name : ");
            name = userInput.nextLine();

            System.out.println();

            System.out.print("Please give a phone number :");
            try {
                phone = Integer.parseInt(userInput.nextLine());

            } catch (NumberFormatException e){
                System.out.println("That phone number was not in integer form\nMalformed entry will not be added to the map");
            }

            if (name != null && phone != null){
                if (  nameAndPhone.put(name,phone) != null){
                    System.out.println("Repeat name was given, thus old number was replaced");
                }
            }

            System.out.println();

            System.out.print("Would you like to add more ? \n\ttype y for yes or n for no  ");
            if (userInput.nextLine().equalsIgnoreCase("n")){
                keepAdding = false;
            }
        }

        Set<String> names = nameAndPhone.keySet();
        Iterator<String> nameIterator = names.iterator();

        System.out.println("\nPrinting given values");



        try (PrintWriter outPut = new PrintWriter( new BufferedWriter( new FileWriter(new File("nameAndPhone.txt"))))){

            while (nameIterator.hasNext()){
                String curName = nameIterator.next();
                String outstring = "Name: " + curName + " Phone: " + nameAndPhone.get(curName);
                System.out.println(outstring);
                outPut.println(outstring);
            }



        } catch (IOException e){
            e.printStackTrace();
        }
    }

}//ReviewDriver
