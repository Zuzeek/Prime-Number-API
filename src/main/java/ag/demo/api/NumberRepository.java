package ag.demo.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRepository extends JpaRepository<Number, Long> {
	List<Number> findByNumberLessThanEqual(int num);
}
