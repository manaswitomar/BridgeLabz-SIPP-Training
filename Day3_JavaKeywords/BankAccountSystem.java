public class BankAccountSystem {
    
    static String bankName = "SBI Bank";

    private static int totalAccounts;
    private final int accountNumber;

    private String accountHolderName;
    private double balance;
    public BankAccountSystem(String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber; 
        this.balance = balance;
        totalAccounts++; 
    }

    
    public static void getTotalAccounts() {
        System.out.println("Total Bank Accounts: " + totalAccounts);
    }
    public void displayDetails() {
        if (this instanceof BankAccountSystem) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: ₹" + balance);
        }
    }

    
    public static void main(String[] args) {
        BankAccountSystem acc1 = new BankAccountSystem("Alice", 1001, 5000.0);
        BankAccountSystem acc2 = new BankAccountSystem("Bob", 1002, 7500.0);

        acc1.displayDetails();
        System.out.println();

        acc2.displayDetails();
        System.out.println();

        BankAccount.getTotalAccounts(); 
    }
}
