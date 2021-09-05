package ag.demo.api;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<NumberModel, Long> {
	

}
