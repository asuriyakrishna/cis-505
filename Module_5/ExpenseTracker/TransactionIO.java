package Module_5.ExpenseTracker;

public class TransactionIO {
    private static final String FILE_NAME = "expenses.txt";

    public static void bulkInsert(java.util.ArrayList<Transaction> transactions) throws java.io.IOException {
        java.io.PrintWriter output = null;

        if (new java.io.File(FILE_NAME).exists()) {
            output = new java.io.PrintWriter(new java.io.FileOutputStream(FILE_NAME, true));
        } else {
            output = new java.io.PrintWriter(FILE_NAME);
        }

        for (Transaction transaction : transactions) {
            output.println(transaction.getDate());
            output.println(transaction.getDescription());
            output.println(transaction.getAmount());
        }

        output.close();
    }

    public static java.util.ArrayList<Transaction> findAll() throws java.io.IOException {
        java.util.ArrayList<Transaction> transactions = new java.util.ArrayList<>();
        java.util.Scanner input = new java.util.Scanner(new java.io.File(FILE_NAME));

        while (input.hasNext()) {
            String date = input.nextLine();
            String description = input.nextLine();
            double amount = Double.parseDouble(input.nextLine());

            Transaction transaction = new Transaction(description, amount);
            transaction.setDate(date);
            transactions.add(transaction);
        }

        input.close();
        return transactions;
    }
    
}
