package uz.jvh.dtm_visiontest.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "exams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exam extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;  // Testni yaratgan administrator

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @ManyToMany
    @JoinTable(
      name = "exam_questions", 
      joinColumns = @JoinColumn(name = "exam_id"), 
      inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<Question> questions;  // Testga kiruvchi savollar

    @ManyToMany
    @JoinTable(
      name = "exam_students", 
      joinColumns = @JoinColumn(name = "exam_id"), 
      inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<User> students;  // Testda ishtirok etgan talabalar

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;


}
