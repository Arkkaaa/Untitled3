package entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "grade", nullable = false)
    private int grade; // Grades will be on a scale of 1-5

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "grade_saved_date", nullable = false)
    private LocalDateTime gradeSavedDate;


    public Exam() {}

    public Exam(Student student, int grade, LocalDateTime gradeSavedDate) {
        this.student = student;
        this.grade = grade;
        this.gradeSavedDate = gradeSavedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    // Getters and Setters
}