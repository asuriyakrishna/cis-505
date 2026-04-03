package Module_3;

public class Account {
    private double balance;
    
    public Account() {
        this.balance = 200.00;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        this.balance += amt;
    }

    public void withdraw(double amt) {
        if (this.balance >= amt) {
            this.balance -= amt;
        }
    }

    public void displayMenu() {
        System.out.println();
        System.out.println("Account Menu:");
        System.out.println("Enter <D/d> for deposit");
        System.out.println("Enter <W/w> for withdraw");
        System.out.println("Enter <B/b> for balance");
        System.out.print("  Enter option>: ");
    }

    public String getTransactionDate() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM-dd-yyyy");
        return sdf.format(new java.util.Date());
}
}
