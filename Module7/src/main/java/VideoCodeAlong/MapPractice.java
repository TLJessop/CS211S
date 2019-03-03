package VideoCodeAlong;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class MapPractice {

    public static void main(String[] args) {

        String key = "0412762-01-001";

        Map<String,Business> businessMap = new HashMap<>();
        LocalDateTime start = LocalDateTime.now();
        fillMap(businessMap);
        LocalDateTime end = LocalDateTime.now();

        System.out.println("Time to fill " + Duration.between(start,end).toMillis() + " milliseconds");

        start = LocalDateTime.now();
        businessMap.get(key);
        end = LocalDateTime.now();

        System.out.println("Time to find " + Duration.between(start, end).toMillis() + " milliseconds");

        start = LocalDateTime.now();
        businessMap.remove(key);
        end = LocalDateTime.now();

        System.out.println("Time to del " + Duration.between(start,end).toMillis() + " milliseconds\n");

        Map<String, List<Business>> ownerBizMap = new HashMap<>();
        start = LocalDateTime.now();
        fillOwnerMap(ownerBizMap);
        end = LocalDateTime.now();

        System.out.println("OwnerMap has " + ownerBizMap.size() + " enerties");
        System.out.println("Time to fill OwnerMap " + Duration.between(start,end).toMillis() + " milliseconds");

    }//main

    public static void fillOwnerMap(Map<String, List<Business>> map){
        try (FileReader fileReader = new FileReader(new File("/home/thomas/Codelanding/java/CS211S/Module7/src/main/resources/SFBus.csv"))){

            Scanner fileScammer = new Scanner(fileReader);

            while (fileScammer.hasNext()) {
                Scanner lineScanner = new Scanner(fileScammer.nextLine());
                lineScanner.useDelimiter(",");

                String id = lineScanner.next();
                String owner = lineScanner.next();
                String name = lineScanner.next();
                String street = lineScanner.next();
                String city = lineScanner.next();
                String state = lineScanner.next();
                String zip = lineScanner.next();

                Business b = new Business(id, owner, name, street, city, state, zip);


                if(map.containsKey(owner)){
                    List<Business> bizList = map.get(owner);
                    if (bizList == null ){
                        bizList = new ArrayList<Business>();
                    }

                    bizList.add(b);

                    map.replace(owner,bizList);

                } else {
                    List<Business> bizList = new ArrayList<>();
                    bizList.add(b);
                    map.put(owner,bizList);
                }





            }



        } catch (NoSuchElementException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void fillMap(Map<String,Business> map){

        try (FileReader fileReader = new FileReader(new File("/home/thomas/Codelanding/java/CS211S/Module7/src/main/resources/SFBus.csv")))
        {
            Scanner fileScammer = new Scanner(fileReader);

            while (fileScammer.hasNext()){
                Scanner lineScanner = new Scanner(fileScammer.nextLine());
                lineScanner.useDelimiter(",");

                String id = lineScanner.next();
                String owner = lineScanner.next();
                String name = lineScanner.next();
                String street = lineScanner.next();
                String city = lineScanner.next();
                String state = lineScanner.next();
                String zip = lineScanner.next();

                Business b = new Business(id,owner,name,street,city,state,zip);

                if(map.put(id,b) != null){
                    System.out.println("Replacement made at id " + id);
                }
            }
        } catch (NoSuchElementException e){
            System.out.println("Missing Field");
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}//MapPractice
