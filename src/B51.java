import java.util.Scanner;

/**
 *
 * @Student name: Nminh
 */
class PhoneNumber {
    int area;
    String number;

    // Default constructor
    public PhoneNumber() {
        this.area = 0;
        this.number = "";
    }

    // Parameterized constructor
    public PhoneNumber(int area, String number) {
        this.area = area;
        this.number = number;
    }

    // Getter for area
    public int getArea() {
        return area;
    }

    // Setter for area
    public void setArea(int area) {
        this.area = area;
    }

    // Getter for number
    public String getNumber() {
        return number;
    }

    // Setter for number
    public void setNumber(String number) {
        this.number = number;
    }

    // Input data method
    public PhoneNumber inputData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter area code: ");
        this.area = Validation.checkInputInt();

        System.out.print("Enter number: ");
        this.number = Validation.checkInputString();

        return this;
    }

    // Display method
    public void display() {
        System.out.println(this.area + " - " + this.number);
    }
}

class IntPhoneNumber extends PhoneNumber {
    String countryCode;

    // Default constructor
    public IntPhoneNumber() {
        super();
        this.countryCode = "";
    }

    // Parameterized constructor
    public IntPhoneNumber(String countryCode, int area, String number) {
        super(area, number);
        this.countryCode = countryCode;
    }

    // Getter for countryCode
    public String getCountryCode() {
        return countryCode;
    }

    // Setter for countryCode
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    // Input data method
    @Override
    public IntPhoneNumber inputData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter country code: ");
        this.countryCode = Validation.checkInputString();

        super.inputData();

        return this;
    }

    // Display method
    @Override
    public void display() {
        System.out.println(this.countryCode + " - " + super.area + " - " + super.number);
    }
}

class Validation {
    public final static Scanner in = new Scanner(System.in);

    // Check user input string
    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            } else {
                System.err.println("Cannot be empty. Please enter again:");
            }
        }
    }

    // Check user input int
    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result >= 0) {
                    return result;
                } else {
                    System.err.println("Must be a positive value. Please enter again:");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter an integer value:");
            }
        }
    }
}

public class B51 {

    public static void main(String[] args) {
        PhoneNumber[] phonelist = new PhoneNumber[1000];
        int i = 0;

        while (true) {
            System.out.println("Type of phone number - 1. Local phone; - 2. Inter phone - 0. Exit");
            int typeOfPhone = Validation.checkInputInt();

            if (typeOfPhone == 1) {
                PhoneNumber phone = new PhoneNumber();
                phonelist[i] = phone.inputData();
                i++;
            } else if (typeOfPhone == 2) {
                IntPhoneNumber phone = new IntPhoneNumber();
                phonelist[i] = phone.inputData();
                i++;
            } else if (typeOfPhone == 0) {
                break;
            }
        }

        System.out.println("List of phone numbers:");
        for (int j = 0; j < i; j++) {
            phonelist[j].display();
        }
    }
}