import java.util.Scanner;

public class Smallest_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(); 
        int n2 = sc.nextInt(); 
        int n3 = sc.nextInt(); 
        if(n1<n2 && n1<n3){
            System.out.println("Is the first number the smallest?yes");
        }
        else if(n2<n1 && n2<n3){
            System.out.println("Is the second number the smallest?yes");

        }else{
            System.out.println("Is the third number the smallest?yes");
        }
        sc.close();
    }
}