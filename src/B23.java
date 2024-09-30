import java.util.Random;
import java.util.Scanner;

public class B23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int m = sc.nextInt();

        Random random = new Random();

        System.out.println(random.nextInt((m - n) + 1) + n);
        
        sc.close();
    }
    
}