package vladm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vladm.model.Status;
import vladm.service.StatusService;

import java.util.List;

@RestController
public class StatusController {
    private StatusService es;

    @Autowired
    public StatusController(StatusService es) { this.es = es; }

    @GetMapping("/getStatuses")
    public List<Status> findAll() { return es.findAll(); }
}
