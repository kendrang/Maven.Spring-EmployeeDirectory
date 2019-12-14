package Models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;


@Entity
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
   private  Long id;
   private  String firstName;
   private  String lastName;
   private String title;
   private String phoneNumber;
   private String email;
   private DateTimeFormatter hireDate;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "manager_id")
   private  Employee manager;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Long departmentnum;


    public Employee(){}


    public Employee(Long id, String firstName, String lastName, String title, String phoneNumber, String email, DateTimeFormatter hireDate, Employee manager, Department departmentnum) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.hireDate = hireDate;
        this.manager = manager;
        this.departmentnum = departmentnum;

    }

    public Employee(String firstName, String lastName, String title, String phoneNumber, String email, DateTimeFormatter hireDate, Employee manager) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.hireDate = hireDate;
        this.manager = manager;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DateTimeFormatter getHireDate() {
        return hireDate;
    }

    public void setHireDate(DateTimeFormatter hireDate) {
        this.hireDate = hireDate;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Long getDepartmentnum() {
        return departmentnum;
    }

    public void setDepartmentnum(Long departmentnum) {
        this.departmentnum = departmentnum;
    }

}
