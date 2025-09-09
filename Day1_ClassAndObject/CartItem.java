public class CartItem
{
    String itemName;
    double price;
    int quantity;

    public CartItem(String itemName, double price, int quantity)
    {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    public double getTotalCost()
    {
        return price * quantity;
    }

    public void displayItem()
    {
        System.out.println(itemName + " - ₹" + price + " x " + quantity);
    }
    public static void main(String[] args)
    {
        CartItem cartItem=new CartItem("pen", 10.0, 2);
        cartItem.displayItem();
    }

}