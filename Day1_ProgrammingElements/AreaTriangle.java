import java.util.Scanner;
class AreaTriangle{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double height=sc.nextDouble();
        double length=sc.nextDouble();
        double area=(1/2)*length*height;
        System.out.println(area);

        sc.close();
    }
}