package vladm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vladm.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
