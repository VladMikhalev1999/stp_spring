package vladm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vladm.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Status SET name = :name WHERE id = :id")
    void update(@Param("id") Integer id, @Param("name") String name);
}
