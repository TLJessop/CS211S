package com.Tljessop.Products;

import java.util.Objects;

public class Computer extends Product {

    //Instance variables
    private String centralProcessingUnit ;
    private String centralProcessingUnitSpeed ;
    private String randomActcessMemoryType ;
    private String randomActcessMemoryVolume;
    private String hardDriveType;
    private String hardDiveVolume;
    //End instance variables


    //Constructor
    private Computer(ComputerBuilder builder) {

        super( builder.productName, builder.manufacturer,
                builder.productIdChar, builder.productCode);

        this.centralProcessingUnit = builder.centralProcessingUnit;
        this.centralProcessingUnitSpeed =builder.centralProcessingUnitSpeed;
        this.randomActcessMemoryType = builder.randomActcessMemoryType;
        this.randomActcessMemoryVolume = builder.randomActcessMemoryVolume;
        this.hardDiveVolume = builder.hardDiveVolume;
        this.hardDriveType = builder.hardDriveType;

    }

    //Builder
    public static class ComputerBuilder{
        private String centralProcessingUnit = "Intel Core i3";
        private String centralProcessingUnitSpeed = "";
        private String randomActcessMemoryType = "DDR3";
        private String randomActcessMemoryVolume = "8G";
        private String hardDriveType = "SSD";
        private String hardDiveVolume ="";
        private String productIdChar;
        private String productName;
        private String manufacturer;
        private String productCode;

        public ComputerBuilder(){
        }

        public ComputerBuilder productName(String productName){
            this.productName = productName;
            return this;
        }

        public ComputerBuilder manufacture(String manufacture){
            this.manufacturer = manufacture;
            return this;
        }

        public ComputerBuilder productIdChar(String productIdChar){
            this.productIdChar = productIdChar;
            return this;
        }

        public ComputerBuilder productCode(String productCode){
            this.productCode = productCode;
            return this;
        }

        public ComputerBuilder hardDiveVolume(String hardDiveVolume){
            this.hardDiveVolume = hardDiveVolume;
            return this;
        }

        public ComputerBuilder centralProcessingUnit(String centralProcessingUnit) {
            this.centralProcessingUnit = centralProcessingUnit;
            return this;
        }

        public ComputerBuilder centralProcessingUnitSpeed(String centralProcessingUnitSpeed) {
            this.centralProcessingUnitSpeed = centralProcessingUnitSpeed;
            return this;
        }

        public ComputerBuilder hardDriveType(String hardDriveType) {
            this.hardDriveType = hardDriveType;
            return this;
        }

        public ComputerBuilder randomActcessMemoryType(String randomActcessMemoryType) {
            this.randomActcessMemoryType = randomActcessMemoryType;
            return this;
        }

        public ComputerBuilder randomActcessMemoryVolume(String randomActcessMemoryVolume) {
            this.randomActcessMemoryVolume = randomActcessMemoryVolume;
            return this;
        }

        public Computer build(){
            Computer computer = new Computer(this);
            if(manufacturer == null || productName == null || productIdChar == null ||
            productCode == null || centralProcessingUnitSpeed == null || hardDiveVolume == null ){
                throw new IllegalStateException();
            }
            return new Computer(this);
        }

    } // ComputerBuilder

    //Getter and Setters
    public String getCentralProcessingUnit() {
        return centralProcessingUnit;
    }

    public String getCentralProcessingUnitSpeed() {
        return centralProcessingUnitSpeed;
    }

    public String getRandomActcessMemoryType() {
        return randomActcessMemoryType;
    }

    public String getRandomActcessMemoryVolume() {
        return randomActcessMemoryVolume;
    }

    public String getHardDriveType() {
        return hardDriveType;
    }

    public String getHardDiveVolume() {
        return hardDiveVolume;
    }

    public void setCentralProcessingUnit(String centralProcessingUnit) {
        this.centralProcessingUnit = centralProcessingUnit;
    }

    public void setCentralProcessingUnitSpeed(String centralProcessingUnitSpeed) {
        this.centralProcessingUnitSpeed = centralProcessingUnitSpeed;
    }

    public void setRandomActcessMemoryType(String randomActcessMemoryType) {
        this.randomActcessMemoryType = randomActcessMemoryType;
    }

    public void setRandomActcessMemoryVolume(String randomActcessMemoryVolume) {
        this.randomActcessMemoryVolume = randomActcessMemoryVolume;
    }

    public void setHardDriveType(String hardDriveType) {
        this.hardDriveType = hardDriveType;
    }

    public void setHardDiveVolume(String hardDiveVolume) {
        this.hardDiveVolume = hardDiveVolume;
    }

    //End of Getter and Setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Computer computer = (Computer) o;
        return Objects.equals(getCentralProcessingUnit(), computer.getCentralProcessingUnit()) &&
                getCentralProcessingUnitSpeed().equals(computer.getCentralProcessingUnitSpeed()) &&
                Objects.equals(getRandomActcessMemoryType(), computer.getRandomActcessMemoryType()) &&
                getRandomActcessMemoryVolume().equals(computer.getRandomActcessMemoryVolume()) &&
                Objects.equals(getHardDriveType(), computer.getHardDriveType()) &&
                getHardDiveVolume().equals(computer.getHardDiveVolume());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCentralProcessingUnit(), getCentralProcessingUnitSpeed(), getRandomActcessMemoryType(), getRandomActcessMemoryVolume(), getHardDriveType(), getHardDiveVolume());
    }

    @Override
    public String toString() {
        return "Computer{" +
                "centralProcessingUnit='" + centralProcessingUnit + '\n' +
                ", centralProcessingUnitSpeed='" + centralProcessingUnitSpeed + '\n' +
                ", randomActcessMemoryType='" + randomActcessMemoryType + '\n' +
                ", randomActcessMemoryVolume='" + randomActcessMemoryVolume + '\n' +
                ", hardDriveType='" + hardDriveType + '\n' +
                ", hardDiveVolume='" + hardDiveVolume + '\n' +
                '}';
    }

    public void bootComputer(){
        System.out.println("Powering Up");
    }
}// class Computer
