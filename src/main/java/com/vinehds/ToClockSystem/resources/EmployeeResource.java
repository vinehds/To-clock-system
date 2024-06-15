package com.vinehds.ToClockSystem.resources;

import com.vinehds.ToClockSystem.entities.Employee;
import com.vinehds.ToClockSystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id){
        Employee emp = service.findById(id);
        return ResponseEntity.ok().body(emp);
    }

    @PostMapping
    public ResponseEntity<Employee> insert (@RequestBody Employee emp){
        emp = service.insert(emp);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(emp.getId()).toUri();
        return ResponseEntity.created(uri).body(emp);
    }

    
}
