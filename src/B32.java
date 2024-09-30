import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class B32 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();

        System.out.print("Enter student birth date (dd/MM/yyyy): ");
        String birthDateString = sc.nextLine();
        Date birthDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setTimeZone(TimeZone.getTimeZone("Europe/Lisbon")); // Set to WEST time zone
            birthDate = sdf.parse(birthDateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            sc.close();
            return;
        }

        System.out.print("Enter student address: ");
        String address = sc.nextLine();

        System.out.print("Enter student major: ");
        String major = sc.nextLine();

        System.out.print("Enter student GPA: ");
        double gpa = sc.nextDouble();

        Student student = new Student(studentName, studentId, birthDate, address, major, gpa);
        student.printAllAttributes();

        sc.close();
    }
}

class Student {
    private String name;
    private String studentId;
    private Date birthDate;
    private String address;
    private String major;
    private double gpa;

    public Student(String name, String studentId, Date birthDate, String address, String major, double gpa) {
        this.name = name;
        this.studentId = studentId;
        this.birthDate = birthDate;
        this.address = address;
        this.major = major;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void printAllAttributes() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("Europe/Lisbon")); // Set to WEST time zone
        System.out.println("Student name: " + name);
        System.out.println("Student ID: " + studentId);
        System.out.println("Student birthday: " + sdf.format(birthDate));
        System.out.println("Student address: " + address);
        System.out.println("Student major: " + major);
        System.out.println("Student gpa: " + gpa);
    }
}