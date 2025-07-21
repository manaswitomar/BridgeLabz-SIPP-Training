import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
class User {
   int userId;
   String password;

   public User(int var1, String var2) {
      this.userId = var1;
      this.password = var2;
   }

   public String getPassword() {
      return this.password;
   }

   public int getuserId() {
      return this.userId;
   }
}
class Wallet {
   private double balance;
   private List<Transaction> transaction;
   private User user;

   public Wallet(User var1) {
      this.user = var1;
      this.balance = 0.0;
      this.transaction = new ArrayList<Transaction>();
   }

   double loadMoney(double var1) {
      if (var1 > 0.0) {
         this.balance += var1;
      }

      return this.balance;
   }
}
class PersonalWallet extends Wallet {
   static final double LIMIT = 1250.0;

   public PersonalWallet(User var1) {
      super(var1);
   }
}
class BusinessWallet extends Wallet {
   public BusinessWallet(User var1) {
      super(var1);
   }
}
interface transferable {
   String transferTo();
}
abstract class Transaction {
   private String type;
   private double amount;
   private LocalDateTime timestamp;

   public Transaction(String var1, double var2) {
      this.type = var1;
      this.amount = var2;
      this.timestamp = LocalDateTime.now();
   }

   public void transferTo(User var1, double var2) {
   }

   public void display(User var1) {
      String var10001 = this.type;
      System.out.println(var10001 + " of ₹" + this.amount + " on " + String.valueOf(this.timestamp));
      double var2 = this.amount;
      System.out.println("" + var2 + "transfer to" + String.valueOf(var1));
   }
}



