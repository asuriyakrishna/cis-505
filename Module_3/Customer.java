package Module_3;

/*
Customer class with private instance variables for name, address, city, and zip.
Include a default constructor that initializes the instance variables with default values, and a parameterized constructor.
 */
public class Customer {
    private String name;
    private String address;
    private String city;
    private String zip;

    public Customer() {
        this.name = "Athira Krishna";
        this.address = "100 Default St";
        this.city = "Dallas";
        this.zip = "75001";
    }

    public Customer(String name, String address, String city, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    }

    // Accessor methods
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return 
                "Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "City: " + city + "\n" +
                "Zip: " + zip + "\n" ;
    }
}
