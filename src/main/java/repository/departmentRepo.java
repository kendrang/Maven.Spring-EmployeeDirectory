package repository;

import Models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departmentRepo extends JpaRepository<Department, Long> {
}
