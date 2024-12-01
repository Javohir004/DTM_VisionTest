package uz.jvh.dtm_visiontest.domain.entity;


import jakarta.persistence.*;
import lombok.*;
import uz.jvh.dtm_visiontest.domain.enoms.Category;
import uz.jvh.dtm_visiontest.domain.enoms.QuestionType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Question extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @ElementCollection
    @CollectionTable(name = "question_images", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "image_path")
    private List<String> imagePaths = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "question_answers", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "answer_text")
    private List<String> answers;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
}

