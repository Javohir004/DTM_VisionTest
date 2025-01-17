package uz.jvh.dtm_visiontest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.jvh.dtm_visiontest.domain.entity.Exam;

@Repository
public interface ExamRepo extends JpaRepository<Exam, Long> {

}
