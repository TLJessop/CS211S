package com.Tljessop.Person.Staff;

public abstract class ProperPayer {
    private double payRate;

    public ProperPayer(double payRate) {
        setPayRate(payRate);
    }

    public double getPayRate() {
        return payRate;
    }

    public double setPayRate(double payRate) throws IllegalArgumentException {
        if (payRate > 0){
            this.payRate = payRate;
        } else {
            throw new IllegalArgumentException("Payrate must be a positive number");
        }
        return payRate;
    }

}//Class ProperPayer
