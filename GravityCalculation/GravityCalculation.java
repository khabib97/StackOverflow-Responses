import java.util.Scanner;

public class GravityCalculation {
	
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      double G = 6.673e-11;
      double M = 5.98e24;
      double accelGravity;
      double distCenter = 6371000;

      System.out.print("Distance from center(default 6371000m): ");
      distCenter = scanner.nextDouble();

      // your code here
      accelGravity = (G * 5980000000000000000000000.00) / (distCenter * distCenter);

      System.out.println("Gravity: " + accelGravity);
   }
}
