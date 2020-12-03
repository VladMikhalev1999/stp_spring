package vladm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vladm.model.Employee;
import vladm.service.EmployeeService;
import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService es;

    @Autowired
    public EmployeeController(EmployeeService es) { this.es = es; }

    @GetMapping("/getEmployees")
    public List<Employee> findAll() {
        List<Employee> le = es.findAll();
        return le;
    }
}
