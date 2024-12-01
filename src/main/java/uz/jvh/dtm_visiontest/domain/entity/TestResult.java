package uz.jvh.dtm_visiontest.domain.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "test_results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestResult extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;  // Qaysi test

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;  // Testni yechgan talaba

    @Column(nullable = false)
    private Integer score;  // Ball (savollarni to'g'ri javoblashga qarab)

    private LocalDateTime completedAt;  // Testni tugatgan vaqt
}
