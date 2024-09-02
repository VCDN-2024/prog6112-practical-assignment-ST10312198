/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementapp.java;
import java.util.ArrayList;
/**
 *
 * @author Talha
 */
public class Student {
    private String studentID;
    private String name;
    private int age;
    private String email;
    private String course;

    // Constructor
    public Student(String studentID, String name, int age, String email, String course) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    // Getters
    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    // Method to save a student to the list
    public static void saveStudent(ArrayList<Student> studentList, Student student) {
        studentList.add(student);
        System.out.println("Student details successfully saved.");
    }

    // Method to search for a student by ID
    public static Student searchStudent(ArrayList<Student> studentList, String studentID) {
        for (Student student : studentList) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    // Method to delete a student by ID
    public static void deleteStudent(ArrayList<Student> studentList, String studentID) {
        Student student = searchStudent(studentList, studentID);
        if (student != null) {
            studentList.remove(student);
            System.out.println("Student successfully deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to generate and display the student report in the specified format
    public static void studentReport(ArrayList<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("No students available to display.");
            return;
        }

        int count = 1;
        for (Student student : studentList) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("STUDENT " + count);
            System.out.println("-----------------------------------------------------------");
            System.out.println("STUDENT ID:    " + student.getStudentID());
            System.out.println("STUDENT NAME:  " + student.getName());
            System.out.println("STUDENT AGE:   " + student.getAge());
            System.out.println("STUDENT EMAIL: " + student.getEmail());
            System.out.println("STUDENT COURSE:" + student.getCourse());
            System.out.println("-----------------------------------------------------------\n");
            count++;
        }
    }

    // Method to exit the application
    public static void exitStudentApplication() {
        System.out.println("Exiting the application. Goodbye!");
    }
}

//-----Code Attribution-----//
//(JAVA PROJECT- Student Management System)//
//Available at: (https://youtu.be/GOGt7PACl10?si=Q1e4LgIy_0JtE7zl )//
//Accessed on: (27 August 2024)//

//-----Code Attribution-----//
//(Student registration system | Student Management System in java | Login Panel Part1)//
//Available at: (https://youtu.be/nDAjmLcyiIc?si=CPSkJStKu-10um0U )//
//Acessed on: (27 August 2024)//

//-----Code Attribution-----//
//(Home Page | Student Registration System in java)//
//Available at: (https://youtu.be/YYjAiTjkr84?si=hG9ZjlumL9awUEnK )//
//Accessed on: (27 August 2024)//

//-----Code Attribution-----//
//(Student Management System in Java | NetBeans | MySQL Database)//
//Available at: (https://youtu.be/zKzgvBYa6hQ?si=sRvKjT_LAxgovTj2 )//
//Accessed on: (27 August 2024)//

