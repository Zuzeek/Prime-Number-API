package ag.demo.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ag.demo.api.model.NumberEntity;

@Repository
public interface NumberRepository extends JpaRepository<NumberEntity, Long> {
	List<NumberEntity> findByNumberLessThanEqual(int num);
}
