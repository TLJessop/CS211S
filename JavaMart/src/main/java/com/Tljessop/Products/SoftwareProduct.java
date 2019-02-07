package com.Tljessop.Products;

import java.util.Objects;

public class SoftwareProduct extends Product {

    private String sportedOS;
    private MediaType mediaType;

    public SoftwareProduct(String productName, String manufacturer, String productIdChar,
                           String productCode, String primarySuportedOS, MediaType primaryMediaType){
        super(productName, manufacturer, productIdChar,
         productCode);
        this.sportedOS = primarySuportedOS;
        this.mediaType = primaryMediaType;
    }

    public String getSportedOS() {
        return sportedOS;
    }

    public void setSportedOS(String sportedOS) {
        this.sportedOS = sportedOS;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SoftwareProduct that = (SoftwareProduct) o;
        return getSportedOS().equals(that.getSportedOS()) &&
                getMediaType() == that.getMediaType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSportedOS(), getMediaType());
    }

    @Override
    public String toString() {
        return super.toString() + "   {" +
                "sportedOS='" + sportedOS + '\'' +
                ", mediaType=" + mediaType +
                '}';
    }
}//Class SoftwareProduct
