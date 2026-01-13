package lab5b;

public class Person {
    protected String name;
    protected Address address;

    public Person(String name, String street, String zipcode, String city) {
        this.name = name;
        this.address = new Address(street, zipcode, city);
    }

    public Person(String name, Address address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " [" + address.toString() + "]";
    }

    public String formatForMailing(){
        return name + "\n" + address.toString();
    }
}