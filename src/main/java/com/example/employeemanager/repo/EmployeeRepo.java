package com.example.employeemanager.repo;

import com.example.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Employee e " +
            "WHERE e.id = ?1")
    void deleteEmployeeById(Long id);

    //Optional because there is a chance that it might not have the employee
    Optional<Employee> findEmployeeById(Long id);
}
