import java.util.*;

public class B9 {

    public static void main(String[] args) {
        GenericCar<Car> carList = new GenericCar<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter car name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter car price: ");
                    double price = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter car production: ");
                    String production = sc.nextLine();
                    System.out.print("Enter car year: ");
                    int year = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    Car car = new Car(name, price, production, year);
                    carList.add(car);
                    carList.display();
                    break;
                case 2:
                    carList.display();
                    break;
                case 3:
                    System.out.println("size of array list: " + carList.getSize());
                    break;
                case 4:
                    System.out.println("Is car list empty? " + carList.checkEmpty());
                    break;
                case 5:
                    System.out.print("Enter position to delete: ");
                    int pos = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    carList.delete(pos);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            break;
        }
    }
}

class Car {
    private String name;
    private double price;
    private String production;
    private int year;

    // Constructor
    public Car(String name, double price, String production, int year) {
        this.name = name;
        this.price = price;
        this.production = production;
        this.year = year;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Override toString method for display
    @Override
    public String toString() {
        return "Car{name=" + name + ", price=" + price + ", production=" + production + ", year=" + year + "}";
    }
}

class GenericCar<T> {
    private List<T> a;

    // Constructor
    public GenericCar() {
        this.a = new LinkedList<>();
    }

    // Add new item to the collection
    public void add(T item) {
        a.add(item);
    }

    // Display all items in the collection
    public void display() {
        System.out.println(a);
    }

    // Return the size of the collection
    public int getSize() {
        return a.size();
    }

    // Check if the collection is empty
    public boolean checkEmpty() {
        return a.isEmpty();
    }

    // Remove the item at the specified position
    public void delete(int pos) {
        if (pos >= 0 && pos < a.size()) {
            a.remove(pos);
        } else {
            System.out.println("Invalid position");
        }
    }
}