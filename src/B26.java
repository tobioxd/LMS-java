import java.util.Scanner;

public class B26 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        int p = sc.nextInt();

        double avg = (m + n + p) / 3.0;

        System.out.printf("%.2f%n", avg);
        
        sc.close();
    }
}