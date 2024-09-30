import java.util.Scanner;

public class B13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int hours = n / 3600;

        n = n % 3600;

        int minutes = n / 60;

        n = n % 60;

        System.out.println(hours + " " + minutes + " " + n);
        
        sc.close();
    }
}