import java.util.Scanner;

public class B22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String password = sc.nextLine();

        if (isValidPassword(password)) {
            System.out.println("valid password");
        } else {
            System.out.println("invalid password");
        }
        
        sc.close();
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 10) {
            return false;
        }
        
        int digitCount = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
            if (Character.isDigit(ch)) {
                digitCount++;
            }
        }
        
        return digitCount >= 2;
    }
}