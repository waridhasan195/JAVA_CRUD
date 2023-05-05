package Setter_Getter;

public class School {
    public String SchoolName = "Al_Hera Academy";
    public String SchoolAddress = "Bera-Pabna";
    private String Hedmaster_Name;
    private int StaffAmount;

    public void Display(){
        Display_SchoolName();
        Display_SchoolAddress();
    }
    public void Display_SchoolName(){
        System.out.println("School Name: " + SchoolName);
    }
    public void Display_SchoolAddress(){
        System.out.println("School Address: " + SchoolAddress);
    }


}
