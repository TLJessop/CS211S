package com.Tljessop.HomeWork;

public class IllegalCharacterException extends Exception {

    public IllegalCharacterException(int errorLine){
       super("An illegal character was found parsing customerId on line " + errorLine);
    }

}//IllegalCharacterException
