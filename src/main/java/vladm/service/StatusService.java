package vladm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vladm.model.Employee;
import vladm.model.Status;
import vladm.repository.StatusRepository;

import java.util.List;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository er) { statusRepository = er; }

    public List<Status> findAll() { return statusRepository.findAll(Sort.by(Sort.Direction.ASC, "id")); }

    public Integer getMaxId() {
        List<Status> ls = statusRepository.findAll();
        int max_id = 0;
        for (int i = 0; i < ls.size(); i++) {
            Status s = ls.get(i);
            if (s.getId() > ls.get(max_id).getId()) max_id = i;
        }
        return ls.get(max_id).getId();
    }
    public void save(Status s) {
        statusRepository.save(s);
    }
    public void deleteById(Integer id) {
        statusRepository.deleteById(id);
    }
    public void updateById(Integer id, String name) {
        statusRepository.update(id, name);
    }

    public Status getById(Integer sid) {
        return statusRepository.getOne(sid);
    }
}
