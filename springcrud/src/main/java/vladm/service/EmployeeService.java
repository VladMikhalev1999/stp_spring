package vladm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vladm.model.Employee;
import vladm.repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository er) { employeeRepository = er; }

    public List<Employee> findAll() { return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "id")); }
}
