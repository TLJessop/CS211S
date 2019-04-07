package HomeWork;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DaysAlive {
    public static void main(String[] args) {

        Scanner userInput =  new Scanner(System.in);
        int month = 0, day = 0, year = 0;
        boolean invalidDate;

        System.out.println("Welcome to DaysAlive this simple app with count the days of your life from birth to now");
        do {
            invalidDate = false;

            try{
                System.out.println("Please give your year of birth");
                year = Integer.parseInt(userInput.nextLine());
                System.out.println("Please give the month of birth\n\tIn two digit format");
                month = Integer.parseInt(userInput.nextLine());
                System.out.println("Please give the day of the month of your birth");
                day = Integer.parseInt(userInput.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Sorry, a non-whole number was give please try again");
                invalidDate = true;
            }
            if (year < 0){
                System.out.println("Not a valid year please try again");
                invalidDate = true;
            }

            if (month < 0 || month > 12 ){
                System.out.println("Not a valid month please try again");
                invalidDate = true;
            }

            if (day < 0 || day > 31 ){
                System.out.println("Not a valid month please try again");
                invalidDate = true;
            }
        } while (invalidDate);

        LocalDate dateOfBirth = LocalDate.of(year,month,day);
        int nextBirthdayYear = (dateOfBirth.getDayOfYear() > LocalDate.now().getDayOfYear()) ? LocalDate.now().getYear() : (LocalDate.now().getYear() + 1);
        LocalDate nextBirthday =  LocalDate.of(nextBirthdayYear, month, day);

       System.out.println("You , has been alive for " + ChronoUnit.DAYS.between(dateOfBirth, LocalDate.now()) + " days" + "\nAnd your next birthday is " + ChronoUnit.DAYS.between(LocalDate.now(),nextBirthday) + " days away");
    }// main
}//DaysAlive
