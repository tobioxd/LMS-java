import java.util.Scanner;
import java.text.DecimalFormat;

/**
 *
 * @Student name: Nminh
 */
abstract class Person {
    protected String name;

    // Default constructor
    public Person() {
        this.name = "";
    }

    // Parameterized constructor
    public Person(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Abstract display method
    public abstract void display();

    // Abstract getSalary method
    public abstract double getSalary();
}

class Worker extends Person {
    private final static Scanner in = new Scanner(System.in);
    double bSalary;
    double rate;

    // Default constructor
    public Worker() {
        super();
        this.bSalary = 0.0;
        this.rate = 0.0;
    }

    // Parameterized constructor
    public Worker(String name, double bSalary, double rate) {
        super(name);
        this.bSalary = bSalary;
        this.rate = rate;
    }

    // Getter for bSalary
    public double getBSalary() {
        return bSalary;
    }

    // Setter for bSalary
    public void setBSalary(double bSalary) {
        this.bSalary = bSalary;
    }

    // Getter for rate
    public double getRate() {
        return rate;
    }

    // Setter for rate
    public void setRate(double rate) {
        this.rate = rate;
    }

    // Display method
    @Override
    public void display() {
        System.out.println("Name = " + name);
        DecimalFormat df = new DecimalFormat("#.000");
        System.out.println("Salary = " + df.format(getSalary()));
    }

    // Get salary method
    @Override
    public double getSalary() {
        return bSalary * rate;
    }

    // Input data method
    public Worker input() {
        String name;
        double salaryBasic, rate;

        name = in.next();

        salaryBasic = in.nextDouble();

        rate = in.nextDouble();
        return new Worker(name, salaryBasic, rate);
    }
}

public class B52 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Worker[] wkArray = new Worker[1000];
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++ ){
            Worker wktemp = new Worker();
            wkArray[i] = wktemp.input();
        }
        
        
        System.out.println("\nAdd worker's informaton sucessful!");
        System.out.println("---------------------");
        for (int i = 0; i < n; i++) {
            wkArray[i].display();
        }
    }
}