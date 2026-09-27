package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    // array to save all transactions
    Double[] transactions = new Double[1000];
    // number of transactions saved
    int count = 0;

    public BankAccount(String name, int startingBalance) {
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        // amount must be positive
        if (amount <= 0) {
            System.out.println("Invalid deposit: " + amount);
            return;
        }
        currentBalance += amount;
        transactions[count] = amount; // save deposit as positive
        count++;
    }

    public void withdraw(double amount){
        // amount must be positive and not more than balance
        if (amount <= 0 || amount > currentBalance) {
            System.out.println("Invalid withdraw: " + amount);
            return;
        }
        currentBalance -= amount;
        transactions[count] = -amount; // save withdraw as negative
        count++;
    }

    public void displayTransactions(){
        System.out.println("Transactions of " + name + ":");
        for (int i = 0; i < count; i++) {
            System.out.println(transactions[i]);
        }
    }

    public void displayBalance(){
        System.out.println(name + " balance: " + currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}