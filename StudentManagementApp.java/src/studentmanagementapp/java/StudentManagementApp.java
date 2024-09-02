/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagementapp.java;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Talha
 */
public class StudentManagementApp {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            displayMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    captureStudent(scanner, studentList);
                    break;
                case 2:
                    searchForStudent(scanner, studentList);
                    break;
                case 3:
                    deleteStudent(scanner, studentList);
                    break;
                case 4:
                    Student.studentReport(studentList);
                    break;
                case 5:
                    Student.exitStudentApplication();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 5);

        scanner.close();
    }

    // Method to display the menu
    private static void displayMenu() {
        System.out.println("1. Capture Student");
        System.out.println("2. Search Student");
        System.out.println("3. Delete Student");
        System.out.println("4. View Student Report");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to capture student details
    private static void captureStudent(Scanner scanner, ArrayList<Student> studentList) {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        int age = getValidAge(scanner);
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        Student student = new Student(id, name, age, email, course);
        Student.saveStudent(studentList, student);
    }

    // Method to validate and get a correct age
    private static int getValidAge(Scanner scanner) {
        int age;
        do {
            System.out.print("Enter Age: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid age. Please enter a number.");
                scanner.next(); // discard invalid input
            }
            age = scanner.nextInt();
            scanner.nextLine(); // consume newline
            if (age < 16) {
                System.out.println("Invalid age. Age must be 16 or older.");
            }
        } while (age < 16);
        return age;
    }

    // Method to search for a student
    private static void searchForStudent(Scanner scanner, ArrayList<Student> studentList) {
        System.out.print("Enter Student ID to search: ");
        String searchID = scanner.nextLine();
        Student foundStudent = Student.searchStudent(studentList, searchID);
        if (foundStudent != null) {
            System.out.println("Student Found: " + foundStudent.getName() + ", Age: " +
                               foundStudent.getAge() + ", Email: " + foundStudent.getEmail() +
                               ", Course: " + foundStudent.getCourse());
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to delete a student
    private static void deleteStudent(Scanner scanner, ArrayList<Student> studentList) {
        System.out.print("Enter Student ID to delete: ");
        String deleteID = scanner.nextLine();
        System.out.print("Are you sure you want to delete this student? (y/n): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("y")) {
            Student.deleteStudent(studentList, deleteID);
        }
    }
}