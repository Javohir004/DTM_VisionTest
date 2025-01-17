package uz.jvh.dtm_visiontest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.jvh.dtm_visiontest.domain.entity.TestResult;

@Repository
public interface TestResultRepo extends JpaRepository<TestResult, Long> {

}
