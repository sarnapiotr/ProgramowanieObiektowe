package lab5b;

public class Address {
    private String street;
    private String zipcode;
    private String city;

    public Address(String street, String zipcode, String city){
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
    }

    @Override
    public String toString() {
        return street + ", " + zipcode + " " + city ;
    }

    public String formatForMailing(){
        return street + "\n" + zipcode + " " + city;
    }
}