package vladm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import vladm.model.Employee;
import vladm.model.Status;
import vladm.service.EmployeeService;
import vladm.service.StatusService;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService es;
    private StatusService ss;
    @Autowired
    public EmployeeController(EmployeeService es, StatusService ss) { this.es = es; this.ss = ss; }

    @GetMapping("/getEmployees")
    public List<Employee> findAll() {
        List<Employee> le = es.findAll();
        return le;
    }

    @GetMapping("/addEmployee/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public String addStatus(@PathVariable("name") String name) {
        Employee s = new Employee();
        s.setId(es.getMaxId() + 1);
        s.setName(name);
        es.save(s);
    }

    @GetMapping("/deleteEmployee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteStatus(@PathVariable("id") Integer id) {
        es.deleteById(id);
    }

    @GetMapping("/updateEmployee/{id}/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String updateStatus(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        Employee e = es.getById(id);
        e.setName(name);
        es.save(e);
    }

    @GetMapping("/addEmployeeStatus/{id}/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String addEmpStat(@PathVariable("id") Integer eid, @PathVariable("name") Integer sid) {
        Employee e = es.getById(eid);
        Status s = ss.getById(sid);
        es.addEmpStat(e, s);
    }

    @GetMapping("/removeEmployeeStatus/{id}/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String removeEmpStat(@PathVariable("id") Integer eid, @PathVariable("name") Integer sid) {
        Employee e = es.getById(eid);
        Status s = ss.getById(sid);
        es.removeEmpStat(e, s);
    }
}
