package SpiderApp;

import java.io.*;
import java.util.Scanner;

public class CleanFile {

    public static void main(String[] args){

        try (FileReader fileReader = new FileReader(new File("/home/thomas/Codelanding/java/CS211S/Arachnida/src/main/resources/521.csv"))
             ; PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("cleaned521.csv"))))){

            Scanner fileScanner = new Scanner(fileReader);

            int lineCount = 0;

            while (fileScanner.hasNext()){
                String line = fileScanner.nextLine().replace('|',',');
                char[] chars = line.toCharArray();
                int commaCount =0;
                for (int i = 0; i < chars.length ; i++) {
                    if (chars[i]==',') commaCount++;
                }

                if (commaCount>=26) {
                    Scanner lineScaner = new Scanner(line);
                    lineScaner.useDelimiter(",");
                    for (int i = 0; i < 3 ; i++) {
                        lineScaner.next();
                    }
                    String genious = lineScaner.next();
                    lineScaner.next();
                    String species = lineScaner.next();

                    System.out.println(genious + " "+ species + "  " + line );
                    lineCount++;
                }
            }

            System.out.println(lineCount);




        } catch (IOException e){
            e.printStackTrace();
        }










    }


}//CleanFile
