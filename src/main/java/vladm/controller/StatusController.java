package vladm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vladm.model.Employee;
import vladm.model.Status;
import vladm.service.StatusService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class StatusController {
    private StatusService es;

    @Autowired
    public StatusController(StatusService es) { this.es = es; }

    @GetMapping("/getStatuses")
    public List<Status> findAll() { return es.findAll(); }

    @GetMapping("/addStatus/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public String addStatus(@PathVariable("name") String name) {
        Status s = new Status();
        s.setId(es.getMaxId() + 1);
        s.setName(name);
        es.save(s);
        return "Success.<br><a href='/statuses'>Вернуться</a>";
    }

    @GetMapping("/deleteStatus/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteStatus(@PathVariable("id") Integer id) {
        es.deleteById(id);
        return "Success.<br><a href='/statuses'>Вернуться</a>";
    }

    @GetMapping("/updateStatus/{id}/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String updateStatus(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        Status s = es.getById(id);
        s.setName(name);
        es.save(s);
        return "Success.<br><a href='/statuses'>Вернуться</a>";
    }
}
