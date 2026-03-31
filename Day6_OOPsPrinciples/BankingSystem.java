import java.util.ArrayList;

public class BankingSystem {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();

        BankAccount sa = new SavingsAccount("SA1001", "Alice", 12000);
        BankAccount ca = new CurrentAccount("CA2001", "Bob", 25000);

        accounts.add(sa);
        accounts.add(ca);

        for (BankAccount acc : accounts) {
            System.out.println("Account Holder: " + acc.getHolderName());
            System.out.println("Account Number: " + acc.getAccountNumber());
            System.out.println("Balance: ₹" + acc.getBalance());

            System.out.println("Interest: ₹" + acc.calculateInterest());

            if (acc instanceof Loanable) {
                Loanable loanable = (Loanable) acc;
                loanable.applyForLoan(50000);
                System.out.println("Eligible for Loan: " + loanable.calculateLoanEligibility());
            }

            System.out.println("---------------------------");
        }

        // Example deposit and withdraw
        sa.deposit(3000);
        ca.withdraw(5000);
    }
}
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation - Getters
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    // Encapsulation - Setters
    public void setHolderName(String holderName) { this.holderName = holderName; }
    public void setBalance(double balance) { this.balance = balance; }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount + ". New Balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew ₹" + amount + ". New Balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Abstract method
    public abstract double calculateInterest();
}
// SavingsAccount
class SavingsAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.04; // 4%

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    public void applyForLoan(double amount) {
        System.out.println("Loan Application Submitted for Savings Account: ₹" + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000;
    }
}

// CurrentAccount
class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.02; // 2%

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    public void applyForLoan(double amount) {
        System.out.println("Loan Application Submitted for Current Account: ₹" + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 20000;
    }
}
