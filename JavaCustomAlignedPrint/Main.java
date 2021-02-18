import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main planet = new Main();
        Scanner in = new Scanner(System.in);
        
        System.out.print("What is the planet's circumference in miles?  ");
        double circ = in.nextDouble();
        
        ClassP cP = new ClassP(circ);
        cP.calculateData();
        cP.print();

    }

}

class ClassP{
    
    private double circ, radius, circleArea, diameter, surfArea, volume;

    public ClassP(double circ) {
        this.circ = circ;  
    }
    
    public void calculateData() {
        radius = circ / (Math.PI * 2);
        circleArea = Math.PI * Math.pow(radius, 2);
        diameter = circ / Math.PI;
        surfArea = 4 * Math.PI * Math.pow(radius, 2);
        volume = (4.0 / 3) * Math.PI * Math.pow(radius, 3);
        
    }
    
    public void print() {
        customAlignPrinter("The radius of the planet is:", radius);
        customAlignPrinter("The area of the planet is:", circleArea);
        customAlignPrinter("The diameter of the planet is:",diameter);
        customAlignPrinter("The surface area of the planet is:", surfArea);
        customAlignPrinter("The volume of the planet is:", volume);
    }
    
    public void customAlignPrinter(String msg,double val) {
        System.out.println(String.format("%40s %,20f", msg, val));
    }
    
}
