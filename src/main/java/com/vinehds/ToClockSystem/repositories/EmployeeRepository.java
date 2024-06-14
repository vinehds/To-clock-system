package com.vinehds.ToClockSystem.repositories;

import com.vinehds.ToClockSystem.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> { }
