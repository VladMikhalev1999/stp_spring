package vladm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vladm.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Employee SET name = :name WHERE id = :id")
    void update(@Param("id") Integer id, @Param("name") String name);
}
