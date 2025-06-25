class DiscountedAmount{
    public static void main(String[] args){
        int fee=125000;
        double  discountPercent =0.10;
        double discount=discountPercent*fee;
        double fee_paid=fee-discount;
        System.out.println("The discount amount is INR"+discount+" and final discounted fee is INR"+fee_paid);


    }
}