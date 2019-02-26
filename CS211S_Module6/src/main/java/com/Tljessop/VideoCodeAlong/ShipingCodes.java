package com.Tljessop.VideoCodeAlong;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ShipingCodes {

    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        List<String> codes = new ArrayList<>();

        boolean keepGoing = true;

        System.out.println("Please give a shipping code");

        String inputString = null;

        int goodCodes = 0, badCodes =0;

        while (keepGoing){
            inputString = userInput.nextLine();

            if (inputString.equalsIgnoreCase("q")){
                keepGoing =false;
            } else{
                try {
                    if(Integer.parseInt(inputString.substring(0,4)) > 9000){
                        System.out.println("Out west");
                    }

                    String shippingSpeed = inputString.substring(5,6);

                    if (shippingSpeed.equalsIgnoreCase("e")){
                        System.out.println("Express shipping");
                    } else if (shippingSpeed.equalsIgnoreCase("r")){
                        System.out.println("Regular shipping");
                    } else {
                        throw new NotValidShippingException();
                    }

                    goodCodes++;
                    codes.add(inputString);
                } catch (NumberFormatException e){
                    System.out.println("Not a valid zipcode");
                    badCodes++;
                } catch (StringIndexOutOfBoundsException e){
                    System.out.println("Not enough characters in given input");
                    badCodes++;
                } catch (NotValidShippingException e){
                    System.out.println(e.getMessage());
                    badCodes++;
                }
                System.out.println("Enter anther code or q to leave the loop");
            }
        }

        System.out.println("Number of good codes: " + goodCodes +" Number of bad codes: " + badCodes);

        System.out.println("Please give a name for the output file");

        inputString = userInput.nextLine() + ".txt";

        try (PrintWriter output = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(
                                new File(inputString)))))
        {
            for(String code: codes){
                output.println(code);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }//main

}//ShipingCodes
