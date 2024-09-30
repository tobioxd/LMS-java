import java.util.Scanner;

public class B27 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        int res = 0;
        for(char c : s.toCharArray()) {
            char cLower = Character.toLowerCase(c);
            if(cLower == 'a' || cLower == 'e' || cLower == 'i' || cLower == 'o' || cLower == 'u') {
                res++;
            }
        }

        System.out.println(res);
        
        sc.close();
    }
}