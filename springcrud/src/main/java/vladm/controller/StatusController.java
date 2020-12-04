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

    @GetMapping("/statuses/getStatuses")
    public List<Status> findAll() { return es.findAll(); }

    @GetMapping("/statuses/addStatus/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStatus(@PathVariable("name") String name) {
        Status s = new Status();
        s.setId(es.getMaxId() + 1);
        s.setName(name);
        es.save(s);
    }

    @GetMapping("/statuses/removeStatus/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStatus(@PathVariable("id") Integer id) {
        es.deleteById(id);
    }

    @GetMapping("/statuses/setStatus/{id}/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void updateStatus(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        Status s = es.getById(id);
        s.setName(name);
        es.save(s);
    }
}
