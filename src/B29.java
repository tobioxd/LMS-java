import java.util.Scanner;

public class B29 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        double res = 0 ;

        for(int i = 1 ; i <= n ; i++){
            res += sc.nextInt();
        }

        System.out.printf("%.2f%n",res);
        
        sc.close();
    }
}