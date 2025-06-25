class Volume_Circle{
    public static void main(String[] args){
        int Radiusinkm=6378;
        double RadiusinMiles=Radiusinkm*0.621;
        double Volumeinkm=(4/3)*3.14*(Radiusinkm*Radiusinkm*Radiusinkm);
        double VolumeinMiles=(4/3)*3.14*(RadiusinMiles*RadiusinMiles*RadiusinMiles);
        System.out.print("The volume of earth in cubic kilometers is"+Volumeinkm+" and cubic miles is"+VolumeinMiles);
        
    }
}