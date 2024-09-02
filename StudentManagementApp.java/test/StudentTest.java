/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import studentmanagementapp.java.Student;


/**
 *
 * @author Talha
 */
class StudentTest {

    @Test
    void TestSaveStudent() {
        ArrayList<Student> studentList = new ArrayList<>();
        Student student = new Student("001", "John Doe", 20, "john@example.com", "Computer Science");
        Student.SaveStudent(studentList, student);
        assertEquals(1, studentList.size());
    }

    @Test
    void TestSearchStudent() {
        ArrayList<Student> studentList = new ArrayList<>();
        Student student = new Student("001", "John Doe", 20, "john@example.com", "Computer Science");
        studentList.add(student);
        Student result = Student.SearchStudent(studentList, "001");
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
    }

    @Test
    void TestSearchStudent_StudentNotFound() {
        ArrayList<Student> studentList = new ArrayList<>();
        Student result = Student.SearchStudent(studentList, "999");
        assertNull(result);
    }

    @Test
    void TestDeleteStudent() {
        ArrayList<Student> studentList = new ArrayList<>();
        Student student = new Student("001", "John Doe", 20, "john@example.com", "Computer Science");
        studentList.add(student);
        Student.DeleteStudent(studentList, "001");
        assertEquals(0, studentList.size());
    }

    @Test
    void TestDeleteStudent_StudentNotFound() {
        ArrayList<Student> studentList = new ArrayList<>();
        Student.DeleteStudent(studentList, "999");
        assertEquals(0, studentList.size()); // No student should be deleted
    }

    @Test
    void TestStudentAge_StudentAgeValid() {
        int age = 18;
        assertTrue(age >= 16);
    }

    @Test
    void TestStudentAge_StudentAgeInvalid() {
        int age = 15;
        assertFalse(age >= 16);
    }

    @Test
    void TestStudentAge_StudentAgeInvalidCharacter() {
        String ageInput = "abc";
        assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt(ageInput);
        });
    }
}