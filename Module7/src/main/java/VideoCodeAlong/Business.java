package VideoCodeAlong;

import java.util.Comparator;
import java.util.Objects;

public class Business  implements  Comparable<Business>{

    //Instance date
    private  String id,ownerName, name, street, city, state,zip;

    //Class constants
    public static final Comparator<Business> OWNER_NAME_COMPARATOR = new ComparatorOwnerName();
    public static final  Comparator<Business> OWNER_ID_COMPARATOR = new OwnerNaneIdComparator();

    //Constructor
    public Business(String id, String ownerName, String name, String street, String city, String state, String zip) {
        this.id = id;
        this.ownerName = ownerName;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    //Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    //End of Getters and Setter

    public void process(){

    }

    private static class ComparatorOwnerName implements Comparator<Business>{
        public int compare(Business a, Business b){
            return a.ownerName.compareTo(b.ownerName);
        }
    }

    private static class OwnerNaneIdComparator implements Comparator<Business>{
        @Override
        public int compare(Business a, Business b){
            if (a.ownerName.compareTo(b.ownerName) != 0){
                return  a.ownerName.compareTo(b.ownerName);
            } else {
                return a.id.compareTo(b.id);
            }
        }
    }



    //Overridden methods

    @Override
    public String toString() {
        return "Business{" +
                "id='" + id + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Business business = (Business) o;
        return id.equals(business.id) &&
                ownerName.equals(business.ownerName) &&
                name.equals(business.name) &&
                street.equals(business.street) &&
                city.equals(business.city) &&
                state.equals(business.state) &&
                zip.equals(business.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerName, name, street, city, state, zip);
    }

    @Override
    public int compareTo(Business otherBusiness) {
        if (otherBusiness == this) return 0;

        if (this.id.compareTo(otherBusiness.id)!=0){
            return this.id.compareTo(otherBusiness.id);
        } else if (this.name.compareTo(otherBusiness.name) != 0){
            return this.name.compareTo(otherBusiness.name);
        } else if(this.ownerName.compareTo(otherBusiness.ownerName) != 0){
            return this.ownerName.compareTo(otherBusiness.ownerName);
        } else  if (this.city.compareTo(otherBusiness.city) != 0){
            return this.city.compareTo(otherBusiness.city);
        } else if (this.state.compareTo(otherBusiness.state) != 0){
            return this.state.compareTo(otherBusiness.state);
        } else if (this.street.compareTo(otherBusiness.street) != 0){
            return this.street.compareTo(otherBusiness.street);
        } else {
            return this.zip.compareTo(otherBusiness.zip);
        }
    }
}//Business
