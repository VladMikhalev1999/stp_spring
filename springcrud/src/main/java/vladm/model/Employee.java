package vladm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

@Entity
@Table (name="employee", schema = "stp_spring")
public class Employee {
    @ManyToMany ( cascade = { CascadeType.ALL })
    @JoinTable(
            name = "employee_status",
            joinColumns = { @JoinColumn(name = "eid", referencedColumnName = "id")},
            inverseJoinColumns = { @JoinColumn(name="sid", referencedColumnName = "id")}
    )
    private List<Status> statuses;

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;


    public int getId() {
        return id;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> ls) {
        statuses = ls;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
