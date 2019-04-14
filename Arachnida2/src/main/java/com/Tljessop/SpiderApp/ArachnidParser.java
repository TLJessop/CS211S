package com.Tljessop.SpiderApp;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class ArachnidParser {

    public static void main(String[] args){

        Map<String, List<Specie>> specieMap = new HashMap<>();
        List<Specie> specieListTotal = new ArrayList<>();
        List<String> genusList = new ArrayList<>();

        //Used in percentage calculations
        int totalSpeciesCount = 0;

//        try (FileReader fileReader = new FileReader(new File("/home/thomas/Codelanding/java/CS211S/Arachnida2/src/main/resouces/Arachnid.csv"))
//             ; PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("CleanedArachnid.csv"))))){
//
//
//            Scanner fileScanner = new Scanner(fileReader);
//
//
//
//            while (fileScanner.hasNext()){
//
//                //Used for token counting
//                int commaCount =0;
//
//                //Turning changing the field delimiter
//                //This is because the | that was used in the base file was causing weird parsing errors
//
//                String line = fileScanner.nextLine().replace('|',',');
//                char[] chars = line.toCharArray();
//
//                for (int i = 0; i < chars.length ; i++) {
//                    if (chars[i]==',') commaCount++;
//                }
//
//                //Catching the line of full length
//                if (commaCount >= 26) {
//
//                    //Scanner for field separation
//                    Scanner lineScaner = new Scanner(line);
//                    lineScaner.useDelimiter(",");
//
//                    //Skipping over not needed values
//                    for (int i = 0; i < 3 ; i++) {
//                        lineScaner.next();
//                    }
//
//                    //Grabbing the genus name
//                    String genus = lineScaner.next();
//                    if (!genusList.contains(genus)){
//                        genusList.add(genus);
//                    }
//
//                    //Skipping another column
//                    lineScaner.next();
//
//                    //Grabbing the genus name
//                    String species = lineScaner.next();
//
//
//                    if (!genus.isEmpty() && !species.isEmpty()){
//                        //Writing the cleaned file
//                        out.println(genus+","+species);
//
//                        totalSpeciesCount++;
//
//                        Specie s = new Specie(species,genus);
//                        specieListTotal.add(s);
//
//                        if (!specieMap.containsKey(genus)){
//                            ArrayList<Specie> specieList = new ArrayList<>();
//                            specieList.add(s);
//
//                            specieMap.put(genus, specieList);
//                        } else {
//                            List<Specie> entryList = specieMap.get(genus);
//
//                            entryList.add(s);
//                            specieMap.replace(genus,entryList);
//                        }
//
//                    }
//                }
//            }
//
//        } catch (NoSuchElementException e){
//            System.out.println("Missing field");
//        } catch (IOException e){
//            e.printStackTrace();
//        }

        Set<String> genusSet = specieMap.keySet();
        Iterator<String> genusIterator = genusSet.iterator();

//        while (genusIterator.hasNext()){
//            String genus = genusIterator.next();
//
//            String outString = "The genus " + genus + " has " + specieMap.get(genus).size() + " members "+
//                    "\nThis genus accounts for " + ( ((double) specieMap.get(genus).size() / totalSpeciesCount )  * 100) + " Percent of the " + totalSpeciesCount
//                    + " total number of arachnid species\n";
//
//            System.out.println(outString);
//        }



        try (Stream<String> stream = Files.lines(Paths.get("/home/thomas/Codelanding/java/CS211S/Arachnida2/src/main/resouces/Arachnid.csv"));
             PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("CleanedArachnid.csv"))))
        ){
            stream.forEach((line) -> {
                int cellCount = 0;
                char[] chars = line.toCharArray();

                System.out.println(line);

                for (int i = 0; i < chars.length ; i++) {
                    if (chars[i]=='|') cellCount++;
                }
                System.out.println(cellCount);

                //Catching the line of full length
                if (cellCount >= 26) {

                    //Scanner for field separation
                    Scanner lineScaner = new Scanner(line);
                    lineScaner.useDelimiter(",");

                    //Skipping over not needed values
                    for (int i = 0; i < 3; i++) {
                        lineScaner.next();
                    }

                    //Grabbing the genus name
                    String genus = lineScaner.next();
                    System.out.println(genus);
//                    if (!genusList.contains(genus)) {
//                        genusList.add(genus);
//                    }

                    //Skipping another column
                    //lineScaner.next();

                    //Grabbing the genus name
                    //String species = lineScaner.next();


//                    if (!genus.isEmpty() && !species.isEmpty()) {
//                        //Writing the cleaned file
//                        out.println(genus + "," + species);
//
//                        Specie s = new Specie(species, genus);
//                        specieListTotal.add(s);
//
//                    }
                }
            });
        }catch (NoSuchElementException e){
            System.out.println("Missing field");
        } catch (IOException e){
            e.printStackTrace();
        }


//        genusList.forEach((genus) -> {
//            long specieCount = specieListTotal.stream().filter((specie) -> specie.getGenus().equals(genus)).count();
//            if (specieCount > 0){
//                String outString = "The genus " + genus + " has " + specieCount + " members "+
//                        "\nThis genus accounts for " + ( ((double) specieCount / specieListTotal.size() )  * 100) + " Percent of the " + specieListTotal.size()
//                        + " total number of arachnid species\n";
//
//                System.out.println(outString);
//            }
//        });

//        System.out.println("Hickmanoxyomma count " + specieMap.get("Hickmanoxyomma").size() + " Streem count "
//                + specieListTotal.stream().filter( specie -> specie.getGenus().equals("Hickmanoxyomma")).count() );
//        System.out.println(totalSpeciesCount + " list " + specieListTotal.size() + " g " + specieMap.keySet().size() + " list" + genusList.size());
    }//main


}//ArachnidParser
