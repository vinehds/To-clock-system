package com.vinehds.ToClockSystem.services;

import com.vinehds.ToClockSystem.entities.Employee;
import com.vinehds.ToClockSystem.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> findAll(){
        return repository.findAll();
    }

    public Employee findById(Long id){
        Optional<Employee> obj = repository.findById(id);
        return obj.get();
    }
}
