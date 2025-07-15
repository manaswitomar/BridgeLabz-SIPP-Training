
import java.util.*;

class User {
    int userId;
    String password;
    Wallet wallet;

    public User(int userId, String password, Wallet wallet) {
        this.userId = userId;
        this.password = password;
        this.wallet=wallet;
    }

    public String getPassword() {
        return password;
    }

    public int getuserId() {
        return userId;
    }
    public Wallet getWallet(){
        return wallet;
    }
}

abstract class Wallet implements transferable {
    private double balance;
    private List<Transaction> history = new ArrayList<>();

    public Wallet(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void loadMoney(double amount) {
        balance += amount;
        history.add(new Transaction("Loaded", amount));
    }
    public void viewHistory() {
        for (Transaction t : history) {
            System.out.println(t);
        }
    }

    protected void addTransaction(String type, double amount) {
        history.add(new Transaction(type, amount));
    }

    protected void deductBalance(double amount) {
        this.balance -= amount;
    }

    protected void addBalance(double amount) {
        this.balance += amount;
    }
    public abstract void transferTo(Wallet receiver, double amount);

}
class PersonalWallet extends Wallet{
     private final double DAILY_LIMIT = 5000;

    public PersonalWallet(double balance) {
        super(balance);
    }

    @Override
    public void transferTo(Wallet receiver, double amount) {
        if (amount <= DAILY_LIMIT && amount <= getBalance()) {
            deductBalance(amount);
            receiver.addBalance(amount);
            addTransaction("Transferred to another wallet", amount);
            System.out.println("Transfer successful from Personal Wallet.");
        } else {
            System.out.println("Transfer failed: Amount exceeds limit or insufficient funds.");
        }
    }
}

class BusinessWallet extends Wallet { 
    private final double DAILY_LIMIT = 20000;

    public BusinessWallet(double balance) {
        super(balance);
    }

    @Override
    public void transferTo(Wallet receiver, double amount) {
        if (amount <= DAILY_LIMIT && amount <= getBalance()) {
            deductBalance(amount);
            receiver.addBalance(amount);
            addTransaction("Business Transfer", amount);
            System.out.println("Transfer successful from Business Wallet.");
        } else {
            System.out.println("Transfer failed: Amount exceeds business limit or insufficient funds.");
        }
    }

}

interface transferable {
    void transferTo(Wallet receiver, double amount);
}
class Transaction {
    String type;
    double amount;
    Date timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = new Date();
    }

    @Override
    public String toString() {
        return timestamp + " - " + type + ": ₹" + amount;
    }
    public void transferTo(User user,double amount){
        


    }

    public void display(User user) {
        System.out.println(type + " of ₹" + amount + " on " + timestamp);
        System.out.println(amount+"transfer to"+user);
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user1 = new User(121, "A1B2c3", new PersonalWallet(1200.00));
        System.out.println("user registered successfully");
        User user2=new User(131,"MtKh546", new BusinessWallet(15000.00));
        System.out.println("user registered successfully");

        user1.getPassword();
        user1.getuserId();
        user1.getWallet().loadMoney(500.00);
        System.out.println("Money loaded successfully. Current balance: ₹" + user1.getWallet().getBalance());
        user1.getWallet().transferTo(user2.getWallet(), 300.00);
        System.out.println("Transfer successful. Current balance: ₹" + user1.getWallet().getBalance());
        user1.getWallet().viewHistory();
        user2.getWallet().viewHistory();
        user2.getWallet().transferTo(user1.getWallet(), 200.00);
        System.out.println("Transfer successful. Current balance: ₹" + user2.getWallet().getBalance());
        user2.getWallet().viewHistory();

    }
    
}
