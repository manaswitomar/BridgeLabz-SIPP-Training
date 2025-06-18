 class Main{
    public static void main(String[] args){
        float n1;
        float n2;
        Scanner sc=new Scanner(System.in);
        float n1=sc.nextFloat();
        float n2=sc.nextFloat();
        float addition=n1+n2;
        float subtraction=n1-n2;
        float multiplication=n1*n2;
        float division= n1/n2;
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+n1+" and"+n2 " is" +addition+","+subtraction+","+multiplication+" and"+division);
    }
 }