package com.vinehds.ToClockSystem.services;

import com.vinehds.ToClockSystem.entities.Employee;
import com.vinehds.ToClockSystem.entities.Record;
import com.vinehds.ToClockSystem.repositories.EmployeeRepository;
import com.vinehds.ToClockSystem.services.exceptions.DatabaseException;
import com.vinehds.ToClockSystem.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee findById(Long id) {
        Optional<Employee> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Employee insert(Employee obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Employee update(Long id, Employee obj) {
        try {
            Employee entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Employee entity, Employee obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setAge(obj.getAge());
        entity.setAge(obj.getAge());
        entity.setGender(obj.getGender());
    }


    //metodo para criar endpoint para adicionar registros
    public Employee addRecord(Long id, Record record) {
        try {
            Employee obj = repository.getReferenceById(id);
            obj.addRecord(record);
            return repository.save(obj);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    //metodo para obter as horas trabalhadas
    public long workedHours(Long id) throws Exception {
        try {
            Employee obj = repository.getReferenceById(id);
            return obj.workedHours();
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
