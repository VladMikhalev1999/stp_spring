package vladm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vladm.model.Status;
import vladm.repository.StatusRepository;

import java.util.List;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository er) { statusRepository = er; }

    public List<Status> findAll() { return statusRepository.findAll(Sort.by(Sort.Direction.ASC, "id")); }
}
