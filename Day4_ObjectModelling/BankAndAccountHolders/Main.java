import java.util.ArrayList;
import java.util.List;
class Account {
    private int accountNumber;
    private double balance;
    private Bank bank;

    public Account(int accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Bank getBank() {
        return bank;
    }
}

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Account details for: " + name);
        for (Account account : accounts) {
            System.out.println("Bank: " + account.getBank().getBankName() +
                               " | Account No: " + account.getAccountNumber() +
                               " | Balance: ₹" + account.getBalance());
        }
    }

    public String getName() {
        return name;
    }
}

class Bank {
    private String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public Account openAccount(Customer customer, int accountNumber, double initialDeposit) {
        Account account = new Account(accountNumber, initialDeposit, this);
        customer.addAccount(account);
        System.out.println("Account opened for " + customer.getName() + " at " + bankName);
        return account;
    }

    public String getBankName() {
        return bankName;
    }
}

public class Main {
    public static void main(String[] args) {
        Bank sbi = new Bank("State Bank of India");
        Bank hdfc = new Bank("HDFC Bank");

        Customer john = new Customer("John Doe");

        sbi.openAccount(john, 1001, 5000);
        hdfc.openAccount(john, 2002, 10000);
        john.viewBalance();
    }
}
