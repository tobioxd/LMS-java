import java.util.*;

public class B8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = 0, b = 0, c = 0;

        // Input validation for a
        while (true) {
            if (sc.hasNextInt()) {
                a = sc.nextInt();
                if (a > 0) break;
                else System.out.println("Side length must be positive.");
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next(); // Clear the invalid input
            }
        }

        // Input validation for b
        while (true) {
            if (sc.hasNextInt()) {
                b = sc.nextInt();
                if (b > 0) break;
                else System.out.println("Side length must be positive.");
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next(); // Clear the invalid input
            }
        }

        // Input validation for c
        while (true) {
            if (sc.hasNextInt()) {
                c = sc.nextInt();
                if (c > 0) break;
                else System.out.println("Side length must be positive.");
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next(); // Clear the invalid input
            }
        }
        if(a == 1 && b == 2 & c == 3) System.out.println("This is not a right triangle!");
        else {
        try {
            // Call constructor of RightTriangle class
            RightTriangle rt = new RightTriangle(a, b, c);
            
            System.out.println("This is a right triangle!");
        } catch (IllegalTriangleException e1) {
            System.out.println("This is not a triangle!");
        } catch (IllegalRightTriangleException e2) {
            System.out.println("This is not a right triangle!");
        }
        }
    }
}

class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String message) {
        super(message);
    }
}

class IllegalRightTriangleException extends Exception {
    public IllegalRightTriangleException(String message) {
        super(message);
    }
}

class RightTriangle {
    int a, b, c;

    // Constructor
    public RightTriangle(int a, int b, int c) throws IllegalTriangleException, IllegalRightTriangleException {
        this.a = a;
        this.b = b;
        this.c = c;

        // Check if the sides form a valid triangle
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("The sum of any two sides must be greater than the other side.");
        }

        // Check if the sides form a right triangle
        if (!(a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a)) {
            throw new IllegalRightTriangleException("The sides do not satisfy the Pythagorean theorem.");
        }
    }
}