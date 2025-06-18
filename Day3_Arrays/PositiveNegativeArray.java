import java.util.*;
public class Voting
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int[] n=new int[5];
        for(int i=0;i<n.length;i++){
            n[i]=sc.nextInt();
        }
        for (int num : numbers)
        {
            if(n[i]>0)
            {
                System.out.println("positive");
                if(n[i]%2==0){
                    System.out.println("even");
                }
                else{
                    System.out.println("odd");
                }
            }
            else if(n[i]<0){
                System.out.println("negative");
            }
            else if(n[i]==0){
                System.out.println("zero");
            }
            int first = numbers[0];
            int last = numbers[4];

            if (first == last) {
            System.out.println("The first and last elements are equal: " + first);
            } else if (first > last) {
            System.out.println("The first element " + first + " is greater than the last element " + last + );
            } else {
            System.out.println("The first element " + first + " is less than the last element " + last + );
            }
        }
    }
}