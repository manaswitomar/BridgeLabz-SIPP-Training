import java.util.Scanner;
public class PositiveNegativeArray
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int[] n=new int[5];
        for(int i=0;i<n.length;i++){
            n[i]=sc.nextInt();
        }
        for (int num : n)
        {
            if(n[num]>0)
            {
                System.out.println("positive");
                if(n[num]%2==0){
                    System.out.println("even");
                }
                else{
                    System.out.println("odd");
                }
            }
            else if(n[num]<0){
                System.out.println("negative");
            }
            else if(n[num]==0){
                System.out.println("zero");
            }
            int first = n[0];
            int last = n[4];

            if (first == last) {
            System.out.println("The first and last elements are equal: " + first);
            } else if (first > last) {
            System.out.println("The first element " + first + " is greater than the last element " + last  );
            } else {
            System.out.println("The first element " + first + " is less than the last element " + last );
            }
        }
        sc.close();
    }
}