import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double fee=sc.nextDouble();
        double dp=sc.nextDouble();
        double discount = dp*fee;
        double fee_paid = fee - discount;
        System.out.println("The discount amount is INR"+discount+" and final discounted fee is INR"+fee_paid);
        sc.close();


    }
}