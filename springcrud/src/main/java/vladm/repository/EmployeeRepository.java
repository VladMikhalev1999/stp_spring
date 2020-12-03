package vladm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vladm.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
