package com.Tljessop.Person.Staff;

public class HourlyPayer extends ProperPayer implements Payer {
    private double hoursWorked;


    public HourlyPayer(double hoursWorked, double payRate) {
        super(payRate);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void pay(){
            System.out.println("Paying $" + (hoursWorked * super.getPayRate()));
    }

    //Getters and setters
    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0 ){
            throw new IllegalStateException("Hours Worked can not be less than 0");
        } else {
            this.hoursWorked = hoursWorked;
        }

    }
    // End of Getters and setters
}//Class HourlyPayer
