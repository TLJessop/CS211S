package Midterm;

import java.io.*;
import java.util.Scanner;

public class IOSkell {

    public static void main(String[] args){

        try (PrintWriter outPut = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(
                                new File("someFile.txt")
                        )
                )
        )){
            while (true){
                outPut.println();
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader(
                new File("file.txt"))){
            Scanner fileScan = new Scanner(fileReader);

            while (fileScan.hasNext()){
                System.out.println(fileScan.next());
            }

        } catch (FileNotFoundException e ){
            System.out.println();
        }catch (IOException e){
            e.printStackTrace();
        }


    }


}//IOSkell
