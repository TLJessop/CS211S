package com.Tljessop.VideoCodeAlong;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReading {

    private static Scanner useInput = new Scanner(System.in);

    public  static void main(String[] args) {

        System.out.println("Please give file name\n\tImportant the full path must be included!");

        String fileName = useInput.nextLine();


        try (FileReader fileReader = new FileReader(new File(fileName)) ){
            Scanner fileIntake = new Scanner(fileReader);
            while (fileIntake.hasNext()){
                Scanner lineScanner = new Scanner(fileIntake.nextLine());
                lineScanner.useDelimiter(",");
                while (lineScanner.hasNext()){
                    System.out.println(lineScanner.next());
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
