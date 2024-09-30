import java.util.Scanner;

/**
 *
 * @Student name: Nminh
 */

public class B33 {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.input();
        rectangle.display();
        System.out.println("Area of rectangle is: " + rectangle.calculateArea());
        System.out.println("Perimeter of rectangle is: " + rectangle.calculatePerimeter());
    }
}

class Rectangle {

    private float width;
    private float height;
    private static Scanner sc = new Scanner(System.in);

    public void input() {
        System.out.println("Enter width:");
        width = sc.nextFloat();
        System.out.println("Enter height:");
        height = sc.nextFloat();
    }

    public void display() {
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
    }

    public float calculateArea() {
        return width * height;
    }

    public float calculatePerimeter() {
        return 2 * (width + height);
    }
}