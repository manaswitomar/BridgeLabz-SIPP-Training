class Main{
    public static void main(String[] args){
        double height;
        Scanner sc=new Scanner(System.in);
        double height=sc.nextDouble();
        double height_inch=height/ 2.54 ;
        double height_feet=height/12;
        System.out.println("Your Height in cm is"+height+"while in feet is"+height_feet+" and inches is"+height_inch);

    }
}