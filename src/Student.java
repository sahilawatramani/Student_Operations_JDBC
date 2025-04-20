// Student.java
import customexceptions.*;
import javax.naming.InvalidNameException;


public class Student {
    private String name;
    private long prn;
    private int age;
    private double cgpa;

    public Student(String name, long prn, int age, double cgpa) throws InvalidNameException, InvalidPRNException, InvalidAgeException, InvalidCGPAException, EmptyNameException, NegativeValueException {
        setName(name);
        setPrn(prn);
        setAge(age);
        setCgpa(cgpa);
    }

    public void setName(String name) throws InvalidNameException, EmptyNameException {
        if (name == null || name.trim().isEmpty())
            throw new EmptyNameException("Name cannot be empty");
        if (!name.matches("[a-zA-Z ]+"))
            throw new InvalidNameException("Name must contain only letters and spaces");
        this.name = name;
    }

    public void setPrn(long prn) throws InvalidPRNException, NegativeValueException {
        if (prn <= 0) throw new NegativeValueException("PRN cannot be negative or zero");
        if (String.valueOf(prn).length() != 11) throw new InvalidPRNException("PRN must be 10 digits");
        this.prn = prn;
    }

    public void setAge(int age) throws InvalidAgeException, NegativeValueException {
        if (age < 0) throw new NegativeValueException("Age cannot be negative");
        if (age < 16 || age > 100)
            throw new InvalidAgeException("Age must be between 16 and 100");
        this.age = age;
    }

    public void setCgpa(double cgpa) throws InvalidCGPAException, NegativeValueException {
        if (cgpa < 0) throw new NegativeValueException("CGPA cannot be negative");
        if (cgpa < 0 || cgpa > 10)
            throw new InvalidCGPAException("CGPA must be between 0 and 10");
        this.cgpa = cgpa;
    }

    public String getName() { return name; }
    public long getPrn() { return prn; }
    public int getAge() { return age; }
    public double getCgpa() { return cgpa; }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("PRN: " + prn);
        System.out.println("Age: " + age);
        System.out.println("CGPA: " + cgpa);
    }
}
