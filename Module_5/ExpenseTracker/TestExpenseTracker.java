package Module_5.ExpenseTracker;

public class TestExpenseTracker {public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("  Welcome to the Expense Tracker");
            System.out.println();
            System.out.println("  MENU OPTIONS:");
            System.out.println("    1. View Transactions");
            System.out.println("    2. Add Transactions");
            System.out.println("    3. View Expense");
            System.out.println();

            int choice = ValidatorIO.getInt(sc, "  Please choose an option: ");

            switch (choice) {
                case 1:
                    try {
                        java.util.ArrayList<Transaction> transactions = TransactionIO.findAll();
                        System.out.println();
                        System.out.println("  MONTHLY EXPENSES");
                        System.out.println();
                        for (Transaction transaction : transactions) {
                            System.out.printf("  Date: %s\n  Description: %s\n  Amount: $%,.2f\n\n", transaction.getDate(), transaction.getDescription(), transaction.getAmount());
                        }
                    } catch (java.io.IOException e) {
                        System.out.println("  Error reading transactions: " + e.getMessage());
                    }
                    break;
                case 2:
                    boolean addMore = true;
                    java.util.ArrayList<Transaction> newTransactions = new java.util.ArrayList<>();

                    while (addMore) {
                        String description = ValidatorIO.getString(sc, "  Enter the description: ");
                        double amount = ValidatorIO.getDouble(sc, "  Enter the amount: ");

                        Transaction transaction = new Transaction(description, amount);
                        newTransactions.add(transaction);

                        addMore = ValidatorIO.getYesNo(sc, "  Add another transaction? (y/n): ");
                    }

                    try {
                        TransactionIO.bulkInsert(newTransactions);
                    } catch (java.io.IOException e) {
                        System.out.println("\n Exception: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        java.util.ArrayList<Transaction> transactions = TransactionIO.findAll();
                        double totalExpenses = 0.0;
                        for (Transaction transaction : transactions) {
                            totalExpenses += transaction.getAmount();
                        }
                        System.out.printf("  Your total monthly expense is $%,.2f\n", totalExpenses);
                    } catch (java.io.IOException e) {
                        System.out.println("  Error reading transactions: " + e.getMessage());
                    }
                    break;
                case 4:
                    continueProgram = false;
                    break;
                default:
                    System.out.println("  Invalid choice. Please try again.");
                    break;
            }

            continueProgram = ValidatorIO.getYesNo(sc, "  Continue? (y/n): ");
            System.out.println();
        }

        sc.close();
    }
}
