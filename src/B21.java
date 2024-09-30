import java.util.Scanner;

public class B21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int pv = sc.nextInt();

        int i = sc.nextInt();

        int n = sc.nextInt();

        double fv = pv * Math.pow(1 + i, n);

        System.out.printf("%.2f%n", fv);
        
        sc.close();
    }
}