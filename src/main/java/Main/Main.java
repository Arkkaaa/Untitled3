package Main;

import java.time.LocalDateTime;
import java.util.List;

import DAO.ExamDAO;
import DAO.StudentDAO;
import entity.Exam;
import entity.Student;

public class Main {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        ExamDAO examDAO = new ExamDAO();

        // Add sample students
        Student john = new Student("John Doe");
        Student jane = new Student("Jane Smith");

        studentDAO.saveStudent(john);
        studentDAO.saveStudent(jane);

        // Add exams for students
        examDAO.saveExam(new Exam(john, 4, LocalDateTime.now()));
        examDAO.saveExam(new Exam(john, 5, LocalDateTime.now()));
        examDAO.saveExam(new Exam(jane, 3, LocalDateTime.now()));

        // Retrieve and display all students and their exam grades
        List<Student> students = studentDAO.getAllStudents();
        for (Student student : students) {
            System.out.println("Student: " + student.getName());
            student.getExams().forEach(exam -> System.out.println(" - Exam Grade: " + exam.getGrade()));
        }
    }
}