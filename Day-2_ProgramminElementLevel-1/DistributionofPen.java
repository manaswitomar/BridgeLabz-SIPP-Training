class Main(){
    void main(){
        int NumberofPens=14;
        int students=3;
        int distributed=NumberofPens/students;
        int not_distributed=NumberofPens%students;
        System.out.println("The Pen Per Student is"+distributed+" and the remaining pen not distributed is"+not_distributed);
    }
}