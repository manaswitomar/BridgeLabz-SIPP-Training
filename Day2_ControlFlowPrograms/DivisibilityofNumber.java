import java.util.Scanner;

public class Divisibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); 
        if(num%5==0){
            System.out.println( "Is the number"+num+" divisible by 5?yes");;
        }else{
            System.out.println( "Is the number"+num+" divisible by 5?No");
    }
}