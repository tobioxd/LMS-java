import java.util.Scanner;

/**
 *
 * @Student name: Nminh
 */
public class B41 {

    public static void main(String[] args) {
        System.out.print("Enter structure: ");
        String structure = Validation.checkInputString();

        System.out.print("Enter name: ");
        String name = Validation.checkInputString();

        System.out.print("Enter weight: ");
        float weight = Validation.checkInputFloat();

        Molecule molecule = new Molecule(structure, name, weight);
        molecule.display();
    }
}

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

    // Check user input float
    public static float checkInputFloat() {
        while (true) {
            try {
                float result = Float.parseFloat(in.nextLine().trim());
                if (result > 0 && result < 100) {
                    return result;
                } else {
                    System.err.println("Weight must be a positive value less than 100. Please enter again:");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a floating point value:");
            }
        }
    }
}

class Molecule {
    private String structure;
    private String name;
    private float weight;

    // Default constructor
    public Molecule() {
        this.structure = "";
        this.name = "";
        this.weight = 0.0f;
    }

    // Parameterized constructor
    public Molecule(String structure, String name, float weight) {
        this.structure = structure;
        this.name = name;
        this.weight = weight;
    }

    // Getter for structure
    public String getStructure() {
        return structure;
    }

    // Setter for structure
    public void setStructure(String structure) {
        this.structure = structure;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for weight
    public float getWeight() {
        return weight;
    }

    // Setter for weight
    public void setWeight(float weight) {
        this.weight = weight;
    }

    // Display method
    public void display() {
        System.out.printf("Structure: %s, Name: %s, Weight: %.5f\n", structure, name, weight);
    }
}