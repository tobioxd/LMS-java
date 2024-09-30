import java.util.Scanner;

/**
 *
 * @Student name: Nminh
 */
class Validation {
    private static final Scanner in = new Scanner(System.in);

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

    // Check user input float
    public static float checkInputFloat() {
        while (true) {
            try {
                float result = Float.parseFloat(in.nextLine().trim());
                if (result > 0) {
                    return result;
                } else {
                    System.err.println("Must be a positive value. Please enter again:");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a floating point value:");
            }
        }
    }
}

class Atom {
    private int number;
    private String symbol;
    private String fullname;
    private float weight;

    // Default constructor
    public Atom() {
        this.number = 0;
        this.symbol = "";
        this.fullname = "";
        this.weight = 0.0f;
    }

    // Parameterized constructor
    public Atom(int number, String symbol, String fullname, float weight) {
        this.number = number;
        this.symbol = symbol;
        this.fullname = fullname;
        this.weight = weight;
    }

    // Getter for number
    public int getNumber() {
        return number;
    }

    // Setter for number
    public void setNumber(int number) {
        this.number = number;
    }

    // Getter for symbol
    public String getSymbol() {
        return symbol;
    }

    // Setter for symbol
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    // Getter for fullname
    public String getFullname() {
        return fullname;
    }

    // Setter for fullname
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    // Getter for weight
    public float getWeight() {
        return weight;
    }

    // Setter for weight
    public void setWeight(float weight) {
        this.weight = weight;
    }

    // Accept method to prompt for and accept input from the user
    public boolean accept() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter atomic number: ");
        this.number = Validation.checkInputInt();

        if (this.number == 0) {
            return false;
        }

        System.out.print("Enter symbol: ");
        this.symbol = Validation.checkInputString();

        System.out.print("Enter full name: ");
        this.fullname = Validation.checkInputString();

        System.out.print("Enter atomic weight: ");
        this.weight = Validation.checkInputFloat();

        return true;
    }

    // Display method to display the atomic information
    public void display() {
        System.out.printf("%-10d%-10s%-10s%-10.5f\n", number, symbol, fullname, weight);
    }
}

public class B42 {

    public static void main(String[] args) {
        Atom[] atomArray = new Atom[10];
        int count = 0;

        while (count < 10) {
            Atom atom = new Atom();
            if (!atom.accept()) {
                break;
            }
            atomArray[count] = atom;
            count++;
        }

        System.out.println("\nAtomic Information");
        System.out.println("==================");
        for (int i = 0; i < count; i++) {
            atomArray[i].display();
        }
    }
}