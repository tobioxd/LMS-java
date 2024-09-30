import java.util.Scanner;

/**
 *
 * @Student name: Nminh
 */
public class B34 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int den1 = sc.nextInt();
        Fraction a = new Fraction(num1, den1);

        int num2 = sc.nextInt();
        int den2 = sc.nextInt();
        Fraction b = new Fraction(num2, den2);

        Fraction result;

        // Addition
        result = a.add(b);
        System.out.println("\nAddition result: " + result);

        // Subtraction
        result = a.subtract(b);
        System.out.println("Subtraion result: " + result);

        // Multiplication
        result = a.multiply(b);
        System.out.println("Multiplication result: " + result);

        // Division
        result = a.divide(b);
        System.out.println("Division result: " + result);

        sc.close();
    }
}

class Fraction {

    private int numer;
    private int denom;

    // Constructor
    public Fraction(int num, int den) {
        if (den == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numer = num;
        this.denom = den;
        simplify();
    }

    // Simplify the fraction
    private void simplify() {
        int gcd = findGCD(numer, denom);
        numer /= gcd;
        denom /= gcd;
    }

    // Find the greatest common divisor (GCD)
    private int findGCD(int a, int b) {
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Getters
    public int getNumer() {
        return numer;
    }

    public int getDenom() {
        return denom;
    }

    // Addition
    public Fraction add(Fraction x) {
        int num = this.numer * x.denom + x.numer * this.denom;
        int den = this.denom * x.denom;
        return new Fraction(num, den);
    }

    // Subtraction
    public Fraction subtract(Fraction x) {
        int num = this.numer * x.denom - x.numer * this.denom;
        int den = this.denom * x.denom;
        return new Fraction(num, den);
    }

    // Multiplication
    public Fraction multiply(Fraction x) {
        int num = this.numer * x.numer;
        int den = this.denom * x.denom;
        return new Fraction(num, den);
    }

    // Division
    public Fraction divide(Fraction x) {
        if (x.numer == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        int num = this.numer * x.denom;
        int den = this.denom * x.numer;
        return new Fraction(num, den);
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction fraction = (Fraction) obj;
        return numer == fraction.numer && denom == fraction.denom;
    }

    // ToString method
    @Override
    public String toString() {
        return numer + "/" + denom;
    }
}