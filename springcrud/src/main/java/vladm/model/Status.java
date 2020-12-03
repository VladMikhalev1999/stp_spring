package vladm.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="status", schema = "stp_spring")
public class Status {
    @ManyToMany ( cascade = { CascadeType.ALL })
    @JoinTable(
            name = "employee_status",
            joinColumns = { @JoinColumn(name = "sid", referencedColumnName = "id")},
            inverseJoinColumns = { @JoinColumn(name="eid", referencedColumnName = "id")}
    )
    @JsonIgnore
    List<Employee> employees;

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> le) {
        employees = le;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
