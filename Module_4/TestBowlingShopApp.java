package Module_4;

/*
TestBowlingShopApp tests the Product, Ball, Bag, Shoe, ProductDB, and GenericQueue classes.
 */
public class TestBowlingShopApp {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String userInput;
        System.out.println("  Welcome to the Bowling Shop");
        System.out.println();
        System.out.println();

        do {
            displayMenu();
            userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("x")) {
                System.out.println();
                System.out.println();
                System.out.println("  End of line...");
                break;
            }

            GenericQueue<Product> products = ProductDB.getProducts(userInput);

            if (products.size() == 0) {
                System.out.println("  No products found for the selected option.");
            } else {
                System.out.println();
                System.out.println("  --Product Listing--");
                while (products.size() > 0) {
                    Product product = products.dequeue();
                    System.out.println(product.toString());
                    System.out.println();
                }
            }
        } while (true);

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("  MENU OPTIONS");
        System.out.println("    1. <b> Bowling Balls");
        System.out.println("    2. <a> Bowling Bags");
        System.out.println("    3. <s> Bowling Shoes");
        System.out.println("    4. <x> To exit");
        System.out.println();
        System.out.print("  Please choose an option:");
    }
}
