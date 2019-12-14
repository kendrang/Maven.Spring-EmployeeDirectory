package services;

import Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import repository.employeeRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServices {
    @Autowired
    employeeRepo eRepo;


    public Employee createEmployee(Employee employee){
        return eRepo.save(employee);

    }

    public Employee updateEmployee(Long id, Employee employee){
        eRepo.delete(id);
        return eRepo.save(employee);
    }

    public List<Employee> getEmployees(){
        return eRepo.findAll();
    }

    public Employee getEmployeeById(Long id){
        return eRepo.getOne(id);

    }

    public void deleteEmployeeById(Long id){
        eRepo.delete(id);
    }

    public void deleteListEmployees(List<Employee> fired){
        eRepo.delete(fired);
    }

    public void assignManager(Long employeeID, Long managerID){
        eRepo.findOne(employeeID).setManager(getEmployeeById(managerID));
    }

    public void deleteFromDepartment (Long departmentID){
        List<Employee> allEmployees =  getEmployees();
        for (Employee e : allEmployees){
            if (e.getDepartmentnum() == departmentID){
                deleteEmployeeById(e.getId());
            }
        }
    }
    public void deleteFromManager (Long managerid){
        List<Employee> allEmployees =  getEmployees();
        Employee newManager =  getEmployeeById(managerid).getManager();
        for (Employee e : allEmployees){
            if (e.getManager().getId() == managerid){
                e.setManager(newManager);
            }
        }
    }
}
