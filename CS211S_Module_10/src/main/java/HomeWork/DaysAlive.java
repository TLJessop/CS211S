package HomeWork;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DaysAlive {
    public static void main(String[] args) {

        Scanner userInput =  new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        System.out.println("Welcome to DaysAlive this simple app with count the days of your life from birth to now");
        LocalDate dateOfBirth = null;
        boolean invalidDate;
        do {
            invalidDate = false;

            System.out.println("PLease give your birthday\n\tFormated as mm/dd/yyyy");
            try {
                dateOfBirth = LocalDate.parse(userInput.nextLine(), formatter);
            } catch (DateTimeParseException e){
                System.out.println("Sorry that was not a valid date please try again");
                invalidDate = true;
            }
        } while (invalidDate);
        int nextBirthdayYear = (dateOfBirth.getDayOfYear() > LocalDate.now().getDayOfYear()) ? LocalDate.now().getYear() : (LocalDate.now().getYear() + 1);
        LocalDate nextBirthday =  LocalDate.of(nextBirthdayYear, dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());

       System.out.println("You , has been alive for " + ChronoUnit.DAYS.between(dateOfBirth, LocalDate.now()) + " days" + "\nAnd your next birthday is "
               + ChronoUnit.DAYS.between(LocalDate.now(),nextBirthday) + " days away");
    }// main
}//DaysAlive
