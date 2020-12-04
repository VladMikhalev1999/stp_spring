package vladm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vladm.model.Employee;
import vladm.model.Status;
import vladm.repository.EmployeeRepository;
import vladm.repository.StatusRepository;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository er) { employeeRepository = er; }

    public List<Employee> findAll() { return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "id")); }
    public Integer getMaxId() {
        List<Employee> ls = employeeRepository.findAll();
        int max_id = 0;
        for (int i = 0; i < ls.size(); i++) {
            Employee s = ls.get(i);
            if (s.getId() > ls.get(max_id).getId()) max_id = i;
        }
        return ls.get(max_id).getId();
    }
    public void save(Employee s) {
        employeeRepository.save(s);
    }
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
    public void updateById(Integer id, String name) {
        employeeRepository.update(id, name);
    }
    public Employee getById(Integer id) {
        return employeeRepository.getOne(id);
    }

    public void addEmpStat(Employee e, Status s) {
        e.getStatuses().add(s);
        employeeRepository.save(e);
    }

    public void removeEmpStat(Employee e, Status s) {
        int ind = e.getStatuses().indexOf(s);
        e.getStatuses().remove(ind);
        employeeRepository.save(e);
    }
}
