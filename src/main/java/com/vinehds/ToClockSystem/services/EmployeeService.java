package com.vinehds.ToClockSystem.services;

import com.vinehds.ToClockSystem.entities.Employee;
import com.vinehds.ToClockSystem.repositories.EmployeeRepository;
import jakarta.persistence.Entity;
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

    public Employee insert(Employee obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Employee update(Long id, Employee obj){
        Employee entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Employee entity, Employee obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setAge(obj.getAge());
        entity.setAge(obj.getAge());
        entity.setGender(obj.getGender());
    }
}
