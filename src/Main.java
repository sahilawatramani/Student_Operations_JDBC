// Main.java
// Name: Tanniru Hari Sri Shanmukha Sai
// PRN: 23070126135
// Batch: AIML B3

import java.util.*;
import customexceptions.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StudentOperations operations = new StudentOperations();

        while (true) {
            System.out.println("-----------------------------------------------------");
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Edit Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scan.nextLine());
                System.out.println("-----------------------------------------------------\n");

                switch (choice) {
                    case 1:  // to add student
                        System.out.println("Enter Name: ");
                        String name = scan.nextLine();

                        System.out.println("Enter PRN: ");
                        long prn = Long.parseLong(scan.nextLine());

                        System.out.println("Enter AGE: ");
                        int age = Integer.parseInt(scan.nextLine());

                        System.out.println("Enter CGPA: ");
                        double cgpa = Double.parseDouble(scan.nextLine());

                        Student student = new Student(name, prn, age, cgpa);
                        operations.addStudent(student);
                        break;

                    case 2: // display student
                        operations.displayStudents();
                        break;

                    case 3: // search student
                        try {
                            operations.searchStudent();
                        } catch (InvalidPositionException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 4: //delete student
                        operations.deleteStudent();
                        break;

                    case 5: //edit student
                        operations.editStudent();
                        break;

                    case 6:
                        System.out.println("Exiting program...");
                        scan.close();
                        return;

                    default:
                        throw new InvalidMenuChoiceException("Invalid menu choice!");
                }
            } catch (InvalidMenuChoiceException | NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unhandled Exception: " + e);
            }
        }
    }
}