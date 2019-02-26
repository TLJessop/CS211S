package com.Tljessop.VideoCodeAlong;

import java.io.*;

public class FileWriting {

    public static void main(String[] args) {

        Customer[] customers = new Customer[5];

        customers[0] = new Customer("Walley", "West", 25);
        customers[1] = new Customer("Alex ", "Stone", 22);
        customers[2] = new Customer("Oliver", "Queen", 25);
        customers[3] = new Customer("Scott", "Summers", 25);
        customers[4] = new Customer("Barrey", "Alen", 25);

            PrintWriter customerWriter = null;
        try{
            File file = new File("/home/thomas/Codelanding/java/CS211S/CS211S_Module6/src/main/resources/res/text/customers.txt");
             customerWriter = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(file)));

             for (Customer customer: customers){
                customerWriter.println(customer);
            }
        } catch (IOException e){
            e.printStackTrace();
            System.exit(0);
        } finally {

            customerWriter.close();
        }

    }
    private static class Customer {

        private String firstName, lastName;
        private int age;


        public Customer(String firstName, String lastName, int age){

            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;

        }

       public String toString(){
            return  firstName + "," + lastName
                    + "," + age;
       }
    }

}
