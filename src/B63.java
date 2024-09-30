import java.util.Scanner;
import java.util.Arrays;

public class B63 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input strings
        String str1 = sc.nextLine();

        String str2 = sc.nextLine();

        // Check if the strings are anagrams
        boolean result = areAnagrams(str1, str2);

        // Print the result
        System.out.println(result);
    }

    public static boolean areAnagrams(String str1, String str2) {
        // Remove all whitespace and punctuation, and convert to lowercase
        String cleanedStr1 = str1.replaceAll("[\\W]", "").toLowerCase();
        String cleanedStr2 = str2.replaceAll("[\\W]", "").toLowerCase();

        // Convert strings to char arrays and sort them
        char[] charArray1 = cleanedStr1.toCharArray();
        char[] charArray2 = cleanedStr2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare sorted char arrays
        return Arrays.equals(charArray1, charArray2);
    }
}