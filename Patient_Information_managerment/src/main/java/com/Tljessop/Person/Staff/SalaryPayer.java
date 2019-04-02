package com.Tljessop.Person.Staff;

public class SalaryPayer extends ProperPayer implements Payer {

    public SalaryPayer(double payRate) {
        super(payRate);
    }

    @Override
    public void pay(){
        System.out.println("Paying annual salary of $" + super.getPayRate());
    }
}//Class SalaryPayer
