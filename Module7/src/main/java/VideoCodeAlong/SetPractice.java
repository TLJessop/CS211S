package VideoCodeAlong;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class SetPractice {

    public static void main(String[] args) {

        Set<Business> businessSet = new TreeSet<Business>(Business.OWNER_ID_COMPARATOR);

        LocalDateTime start  = LocalDateTime.now();
        fillSet(businessSet);
        LocalDateTime end = LocalDateTime.now();

        System.out.println("Time to fill " + Duration.between(start,end).toMillis() + " milliseconds");

    }//main

    private static void fillSet(Set set){

        try (FileReader fileReader = new FileReader(new File("/home/thomas/Codelanding/java/CS211S/Module7/src/main/resources/SFBus.csv")))
        {
            Scanner fileScanner = new Scanner(fileReader);

            while (fileScanner.hasNext()){
                Scanner lineScanner = new Scanner(fileScanner.nextLine());
                lineScanner.useDelimiter(",");

                /*
                    public Business(String id, String ownerName, String name, String street, String city, String state, String zip)
                    ID,Ownership_Name,DBA Name,Street_Address,City,State,Zip_Code
                 */
                String id = lineScanner.next();
                String owner = lineScanner.next();
                String name = lineScanner.next();
                String street = lineScanner.next();
                String city = lineScanner.next();
                String state = lineScanner.next();
                String zip = lineScanner.next();

                Business b = new Business(id,owner,name,street,city,state,zip);

               boolean success = set.add(b);

               if (!success) System.out.println("Failed to add Business " + b.getId());
            }



        } catch (NoSuchElementException e){
            System.out.println("Missing field");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e){
            e.printStackTrace();;
        }
    }

}//SetPractice
