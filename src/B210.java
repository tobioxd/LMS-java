import java.util.Scanner;

public class B210 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();
        int day = sc.nextInt();
        
        // Days in each month of 2004 (leap year)
        int[] daysInMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // Calculate the total number of days from 2004/1/1 to the given date
        int totalDays = day;
        for (int i = 1; i < month; i++) {
            totalDays += daysInMonth[i];
        }
        
        // Jan 1, 2004 is Thursday, which is the 4th day of the week (0 = Sunday, 1 = Monday, ..., 6 = Saturday)
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String dayOfWeek = daysOfWeek[(totalDays + 3) % 7];
        
        System.out.println(dayOfWeek);
        
        sc.close();
    }
}