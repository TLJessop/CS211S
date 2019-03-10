package SpiderApp;

import java.io.*;
import java.util.*;

public class CleanFile {

    public static void main(String[] args){

        try (FileReader fileReader = new FileReader(new File("/home/thomas/Codelanding/java/CS211S/Arachnida/src/main/resources/521.csv"))
             ; PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("cleaned521.csv"))))){

            Map<String, List<Specie>> specieMap = new HashMap<>();

            Scanner fileScanner = new Scanner(fileReader);

            while (fileScanner.hasNext()){
                String line = fileScanner.nextLine().replace('|',',');
                char[] chars = line.toCharArray();
                int commaCount =0;
                for (int i = 0; i < chars.length ; i++) {
                    if (chars[i]==',') commaCount++;
                }

                if (commaCount >= 26) {

                    Scanner lineScaner = new Scanner(line);
                    lineScaner.useDelimiter(",");

                    //Skipping over not needed values
                    for (int i = 0; i < 3 ; i++) {
                        lineScaner.next();
                    }

                    //Grabbing the genus name
                    String genus = lineScaner.next();

                    //Skipping another column
                    lineScaner.next();

                    //Grabbing the genus name
                    String species = lineScaner.next();

                    //Writing the cleaned file
                    if (!genus.isEmpty() && !species.isEmpty()){
                    out.println(genus+","+species);

                    Specie s = new Specie(species,genus);
                    if (!specieMap.containsKey(genus)){
                        ArrayList<Specie> specieList = new ArrayList<>();
                        specieList.add(s);

                        specieMap.put(genus, specieList);
                    }

                    }
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }










    }


}//CleanFile
