import java.util.Scanner;

public class B28 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        
        double discriminant = b * b - 4 * a * c;
        
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.printf("%.2f %.2f%n", root2, root1);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.printf("%.2f %.2f%n", root, root);
        } else {
            System.out.println("The equation has no real root.");
        }
        
        sc.close();
    }
}