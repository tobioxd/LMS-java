import java.util.Scanner;

public class B62 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String[] arr = s.split(" ");

        String res = "";

        for(String str : arr) {
            res += Character.toUpperCase(str.charAt(0));
        }

        System.out.println("My initial is "+ res );
    }
}