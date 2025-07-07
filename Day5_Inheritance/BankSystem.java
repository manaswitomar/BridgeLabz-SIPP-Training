class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayBasicInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance       : ₹" + balance);
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.println("Account Type  : Savings Account");
        displayBasicInfo();
        System.out.println("Interest Rate : " + interestRate + "%");
    }
}
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public void displayAccountType() {
        System.out.println("Account Type     : Checking Account");
        displayBasicInfo();
        System.out.println("Withdrawal Limit : ₹" + withdrawalLimit);
    }
}
class FixedDepositAccount extends BankAccount {
    private int durationInMonths;

    public FixedDepositAccount(String accountNumber, double balance, int durationInMonths) {
        super(accountNumber, balance);
        this.durationInMonths = durationInMonths;
    }

    public void displayAccountType() {
        System.out.println("Account Type       : Fixed Deposit Account");
        displayBasicInfo();
        System.out.println("Duration (months)  : " + durationInMonths);
    }
}
public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA1001", 50000, 3.5);
        CheckingAccount checking = new CheckingAccount("CA2002", 25000, 10000);
        FixedDepositAccount fd = new FixedDepositAccount("FD3003", 100000, 12);

        System.out.println("=== Bank Account Details ===\n");

        savings.displayAccountType();

        checking.displayAccountType();
        
        fd.displayAccountType();
        
    }
}
