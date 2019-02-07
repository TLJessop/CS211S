package com.Tljessop.Products;

import java.util.Objects;

public abstract class Product implements Comparable<Product> {

    //Instance variables
    private String productId;
    private String productName;
    private String manufacturer;
    private boolean recalled;
    private String productCode;
    // End of Instance variables

    //Constants
    private static final String DEFAULT_PRODUCT_ID_CHAR = "A";

    //Class variable
    private static int nextProductIdNum = 0;

    //Constructors
    public Product(String productName, String manufacturer, String productIdChar,
                   String productCode) {
        this.productId = productIdChar + Integer.toString(nextProductIdNum);
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.productCode = productCode;
        this.recalled = false;
        nextProductIdNum ++;
    }

    public Product(String productName, String manufacturer, String productCode){
        this(productName,manufacturer, DEFAULT_PRODUCT_ID_CHAR,productCode);
    }
    // End of Constructors

    //Getters and Setters
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isRecalled() {
        return recalled;
    }

    public void setRecalled(boolean recalled) {
        this.recalled = recalled;
    }

    // End of Getters and Setters


    @Override
    public String toString() {
        return "Product {" +
                "productId='" + productId + '\n' +
                "\t\t productName='" + productName + '\n' +
                "\t\t manufacturer='" + manufacturer + '\n' +
                "\t\t recalled=" + recalled +
                "\t\t productCode='" + productCode + '\n' +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return isRecalled() == product.isRecalled() &&
                getProductId().equals(product.getProductId()) &&
                getProductName().equals(product.getProductName()) &&
                getManufacturer().equals(product.getManufacturer()) &&
                getProductCode().equals(product.getProductCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getProductName(), getManufacturer(), isRecalled(), getProductCode());
    }

    @Override
    public int compareTo(Product otherProduct){
        if (otherProduct == this ) return 0;

        if (this.manufacturer.compareTo(otherProduct.manufacturer) != 0){
            return this.manufacturer.compareTo(otherProduct.manufacturer);
        } else {
            return this.productName.compareTo(otherProduct.productName);
        }
    }

}//Class Product
