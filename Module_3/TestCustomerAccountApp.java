/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
 */
package Module_3;

/*
Test the Customer and Account classes by creating a TestCustomerAccountApp class with a main
 */
public class TestCustomerAccountApp {
    
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Enter a customer ID:");
        System.out.print("  ex: 1007, 1008, 1009>: ");
        int customerId = scanner.nextInt();
        Customer customer = CustomerDB.getCustomer(customerId);
        Account account = new Account();

        String option;
        do {
            account.displayMenu();
            option = scanner.next();
            switch (option.toLowerCase()) {
                case "d":
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextInt();
                    account.deposit(depositAmount);
                    break;
                case "w":
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextInt();
                    account.withdraw(withdrawAmount);
                    break;
                case "b":
                    System.out.printf("Account balance: $%,6.2f\n", account.getBalance());
                    break;
                default:
                    System.out.println("Error: Invalid Option");
            }
            System.out.println();
            System.out.print("Continue? (y/n): ");
            option = scanner.next();
        } while (option.equalsIgnoreCase("Y"));

        System.out.println();
        System.out.println("--Customer Details--");
        System.out.println(customer.toString());
        System.out.printf("Balance as of %s: $%,6.2f\n", account.getTransactionDate(), account.getBalance());
        System.out.println();
        System.out.println("End of line...");
    }
}
