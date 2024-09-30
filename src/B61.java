import java.util.Scanner;

public class B61 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input strings
        String str1 = sc.nextLine();

        String str2 = sc.nextLine();

        // Method 1: Using the + operator
        // String result1 = str1 + " " + str2;
        // System.out.println("Concatenated using + operator: " + result1);

        // Method 2: Using the concat() method
        String result2 = str1.concat(" ").concat(str2);
        System.out.println(result2);
    }
}