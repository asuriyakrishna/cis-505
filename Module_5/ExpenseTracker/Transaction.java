package Module_5.ExpenseTracker;

public class Transaction {
    private String date;
    private String description;
    private double amount;

    public Transaction() {
        this.date = java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        this.description = "";
        this.amount = 0.0;
    }

    public Transaction(String description, double amount) {
        this.date = java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        this.description = description;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Date: " + date + "\nDescription: " + description + "\nAmount: $" + String.format("%.2f", amount);
    }
    
}
