class Main{
    public static void main(String[] args){
        int fee;
        double  discountPercent;
        Scanner sc=new Scanner(System.in);
        int fee=sc.nextInt();
        double discountPercent=sc.nextDouble();
        double discount=discountPercent*fee;
        int fee_paid=fee-discount;
        System.out.println("The discount amount is INR"+discount+" and final discounted fee is INR"+fee_paid);


    }
}