package services;

import Models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.departmentRepo;

@Service
public class DepartmentServices {
    @Autowired
    departmentRepo dRepo;

    public Department createDepartment(Department department){
        return dRepo.save(department);

    }

    public Department getDepartment (Long id){
        return dRepo.findOne(id);
    }

}
