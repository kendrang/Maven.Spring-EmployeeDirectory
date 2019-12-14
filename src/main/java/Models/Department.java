package Models;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentID;
    private String departmentName;

    @OneToMany(cascade = CascadeType.ALL)
    private Employee departmentManager;

    public Department(String departmentName, Employee departmentManager) {
        this.departmentName = departmentName;
        this.departmentManager = departmentManager;
    }

    public Long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Long departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Employee getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(Employee departmentManager) {
        this.departmentManager = departmentManager;
    }
}
