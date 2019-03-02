package VideoCodeAlong;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class ListPractice {

    public static void main(String[] args){

        List<Business> businessList = new LinkedList<>();

        LocalDateTime start = LocalDateTime.now();
        fillList(businessList);
        LocalDateTime end = LocalDateTime.now();

        System.out.println("It took " + Duration.between(start,end).toMillis()+ " milliseconds to fill the list");

        System.out.println("There an " + businessList.size() + " enteries in the list");

        start = LocalDateTime.now();
        Business b = businessList.get(businessList.size()/2);
        end = LocalDateTime.now();
        System.out.println("Time to retrive " + Duration.between(start,end).toMillis() + " milliseconds to get the middle");

//        start = LocalDateTime.now();
//        Business b2 = businessList.get(0);
//        end = LocalDateTime.now();
//        System.out.println("Time to retrive " + Duration.between(start,end).toMillis() + " milliseconds to get the Beginning");
//
//        start = LocalDateTime.now();
//        Business b3 = businessList.get(businessList.size() -1);
//        end = LocalDateTime.now();
//        System.out.println("Time to retrive " + Duration.between(start,end).toMillis() + " milliseconds to get the end");
////
//        start = LocalDateTime.now();
//        getBiz("0458979-01-999", businessList);
//        end = LocalDateTime.now();
//        System.out.println("Time for loop to find " + Duration.between(start,end).toMillis() +" milliseconds");

        start = LocalDateTime.now();
        getBizIterator("0458979-01-999", businessList);
        end = LocalDateTime.now();
        System.out.println("Time for interator  loop to find " + Duration.between(start,end).toMillis() +" milliseconds");

        start = LocalDateTime.now();
        delBiz("0458979-01-999", businessList);
        end = LocalDateTime.now();
        System.out.println("Time for loop to del " + Duration.between(start,end).toMillis() +" milliseconds");

        start = LocalDateTime.now();
        delBizIterator("0458979-01-999", businessList);
        end = LocalDateTime.now();
        System.out.println("Time for interator  loop to del " + Duration.between(start,end).toMillis() +" milliseconds");


    }//main

    private static void delBiz(String id, List<Business> list){

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)){
                list.remove(i);
                return;
            }
        }
    }

    private static void delBizIterator (String id, List<Business> list){
        Iterator<Business> iterator = list.iterator();
        while (iterator.hasNext()){
            Business b  = iterator.next();

            if (b.getId().equals(id)) {
                iterator.remove();
            }
        }
    }

    private static void getBiz(String id, List<Business> list){

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)){
                return;
            }
        }
    }

    private static void getBizIterator(String id, List<Business> list){
        Iterator<Business> iterator = list.iterator();
        while (iterator.hasNext()){
            Business b  = iterator.next();

            if (b.getId().equals(id)) return;
        }
    }

    private static void fillList(List<Business> list){
        try (FileReader fileReader = new FileReader(new File("/home/thomas/Codelanding/java/CS211S/Module7/src/main/resources/SFBus.csv"))){

            Scanner fileScaner = new Scanner(fileReader);


            while (fileScaner.hasNext()) {

                Scanner lineScanner = new Scanner(fileScaner.nextLine());
                lineScanner.useDelimiter(",");

                while (lineScanner.hasNext()){


                    String id = lineScanner.next();
                    String owner = lineScanner.next();
                    String name = lineScanner.next();
                    String street = lineScanner.next();
                    String city = lineScanner.next();
                    String state = lineScanner.next();
                    String zip = lineScanner.next();

                    Business business = new Business(id,owner,name,street,city,state,zip);

                    list.add(business);

                }

            }

        } catch (FileNotFoundException e){
            System.out.println("file not found");
        } catch (NoSuchElementException e){
            System.out.println("missing field");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}//ListPractice
