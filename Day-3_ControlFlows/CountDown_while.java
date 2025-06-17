import java.util.Scanner;

public class CountDown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int i=num; 
        while(i>0){
             System.out.println(i);
             i--;

        }
            
    }
}