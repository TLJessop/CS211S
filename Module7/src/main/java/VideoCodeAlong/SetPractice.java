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

        Set<Business> businessSet = new HashSet<>();
        String id = "0000024-02-999";

        LocalDateTime start  = LocalDateTime.now();
        fillSet(businessSet);
        LocalDateTime end = LocalDateTime.now();

        System.out.println("Time to fill " + Duration.between(start,end).toMillis() + " milliseconds");


        start = LocalDateTime.now();
        findBizIterator(id,businessSet);
        end = LocalDateTime.now();

        System.out.println("Time to find " + Duration.between(start,end).toMillis() + " milliseconds");

        start = LocalDateTime.now();
        delBizInterator(id,businessSet);
        end = LocalDateTime.now();

        System.out.println("Time to del " + Duration.between(start,end).toMillis() + " milliseonds");

    }//main


    private static void findBizIterator(String id, Set<Business> set){
        Iterator<Business> iterator = set.iterator();

        while (iterator.hasNext()){
            if (iterator.next().getId().equals(id)){
                return;
            }
        }
    }

    private static void delBizInterator (String id, Set<Business> set){
        Iterator<Business> iterator = set.iterator();

        while (iterator.hasNext()){

            if (iterator.next().getId().equals(id)){
                iterator.remove();
                return;
            }
        }
    }





    private static void fillSet(Set set){

        try (FileReader fileReader = new FileReader(new File("/home/thomas/Codelanding/java/CS211S/Module7/src/main/resources/SFBus.csv")))
        {
            Scanner fileScanner = new Scanner(fileReader);

            while (fileScanner.hasNext()){
                Scanner lineScanner = new Scanner(fileScanner.nextLine());
                lineScanner.useDelimiter(",");

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
