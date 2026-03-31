public class Product {
    static double discount;
    String product_name;
    static int price;
    int quantity;
    final int product_id;


    Product(double discount, String product_name, int price, int quantity,int product_id){
        this.discount=discount;
        this.product_name=product_name;
        this.price=price;
        this.quantity=quantity;
        this.product_id=product_id;

    }

    private static void updateDiscount(){
        int discount_price=(int) (price-(price*(discount/100)));
        System.out.println(discount_price);
        }


    public static void main(String[] args) {
        Product product=new Product(25, "Shoes", 1000, 1,1331);
        product.updateDiscount();
    }
}
