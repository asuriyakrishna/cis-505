package Module_3;

public class CustomerDB {
    public static Customer getCustomer(Integer id) {
        if (id == 1007) {
            return new Customer("John Doe", "123 Main St", "Anytown", "12345");
        } else if (id == 1008) {
            return new Customer("Jane Smith", "456 Oak Ave", "Somewhere", "67890");
        } else if (id == 1009) {
            return new Customer("Bob Johnson", "789 Pine Rd", "Everytown", "54321");
        } else {
            return new Customer();
        }
    }
}
