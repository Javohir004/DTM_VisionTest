package uz.jvh.dtm_visiontest.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question extends BaseEntity {

    @Column(nullable = false)
    private String questionText;  // Savol matni

    @Column(nullable = false)
    private String subject;  // Mavzu (Matematika, Ingliz tili, va boshqalar)

    @ElementCollection
    private List<String> options;  // Variantlar

    @Column(nullable = false)
    private String correctAnswer;  // To'g'ri javob

    private String explanation;  // Javobni tushuntirish (ixtiyoriy)
}
