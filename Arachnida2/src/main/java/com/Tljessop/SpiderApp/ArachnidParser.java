package com.Tljessop.SpiderApp;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class ArachnidParser {

    public static void main(String[] args){

        List<Specie> specieListTotal = new ArrayList<>();
        List<String> genusList = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\tljes\\Downloads\\CS211S-master\\CS211S-master\\Arachnida2\\src\\main\\resouces\\Arachnid.csv"));
             PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("CleanedArachnid.csv"))))
        ){
            stream.forEach((line) -> {
                int cellCount = 0;
                char[] chars = line.toCharArray();


                for (int i = 0; i < chars.length ; i++) {
                    if (chars[i]=='|') cellCount++;
                }

                //Catching the line of full length
                if (cellCount >= 26) {

                    //Scanner for field separation

                    Scanner lineScaner = new Scanner(line.replace('|',','));
                    lineScaner.useDelimiter(",");
                    //Skipping over not needed values
                    for (int i = 0; i < 3; i++) {
                        lineScaner.next();
                    }

                    //Grabbing the genus name
                    String genus = lineScaner.next();
                    if (!genusList.contains(genus)) {
                        genusList.add(genus);
                    }

                    // Skipping another column
                    lineScaner.next();

                    // Grabbing the genus name
                    String species = lineScaner.next();


                    if (!genus.isEmpty() && !species.isEmpty()) {
                        //Writing the cleaned file
                        out.println(genus + "," + species);

                        Specie s = new Specie(species, genus);
                        specieListTotal.add(s);

                    }
                }
            });
        }catch (NoSuchElementException e){
            System.out.println("Missing field");
        } catch (IOException e){
            e.printStackTrace();
        }


        genusList.forEach((genus) -> {
            long specieCount = specieListTotal.stream().filter((specie) -> specie.getGenus().equals(genus)).count();
            if (specieCount > 0){
                String outString = "The genus " + genus + " has " + specieCount + " members "+
                        "\nThis genus accounts for " + ( ((double) specieCount / specieListTotal.size() )  * 100) + " Percent of the " + specieListTotal.size()
                        + " total number of arachnid species\n";

                System.out.println(outString);
            }
        });

    }//main


}//ArachnidParser