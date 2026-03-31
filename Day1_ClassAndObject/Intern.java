public class Intern {
    int ITEM_CODE;
    String ITEM_NAME;
    int PRICE;
    public Intern(int ITEM_CODE,String ITEM_NAME, int PRICE){
        this.ITEM_CODE=ITEM_CODE;
        this.ITEM_NAME=ITEM_NAME;
        this.PRICE=PRICE;
    }
    public void displayDetails() {
        System.out.println("Intern details:");
        System.out.println("Name   : " + ITEM_NAME);
        System.out.println("ID     : " + ITEM_CODE);
        System.out.println("Price $: " + PRICE);
    }



    public static void main(String[] args)
    {
        Intern intern =new Intern(121,"John",200);
        intern.displayDetails();

    }
    

    
}
