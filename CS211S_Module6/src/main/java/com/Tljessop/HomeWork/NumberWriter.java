package com.Tljessop.HomeWork;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberWriter {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        boolean keepGoing = true;

        //The reason why I chose to use double is to allow for floating point numbers
        List<Double> numberList = new ArrayList<>();

        String inputString =null;

        System.out.print("Welcome to NumberWriter\n\tPlease give the the numbers you wish to write to a file:");

        while (keepGoing){
            try {
                    inputString = userInput.nextLine();
                    numberList.add(Double.parseDouble(inputString));
                } catch (NumberFormatException e){
                    if (inputString.equalsIgnoreCase("D")){
                    keepGoing = false;
                } else {
                        System.out.println("That was not a valid number please try again");
                    }
                }
            System.out.println("Please a whole number, or D for done with input");
        }

        System.out.print("Please give a name for the new file :");
        inputString = userInput.nextLine() + ".txt";

        try (PrintWriter outputWriter = new PrintWriter(
                new BufferedWriter(new FileWriter(new File(inputString))))){

            for (Double num: numberList
                 ) {
                outputWriter.println(num);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }//main

}//NumberWriter
