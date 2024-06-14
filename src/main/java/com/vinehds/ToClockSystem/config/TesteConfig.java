package com.vinehds.ToClockSystem.config;

import com.vinehds.ToClockSystem.entities.Employee;
import com.vinehds.ToClockSystem.entities.enums.Gender;
import com.vinehds.ToClockSystem.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        Employee emp1 = new Employee(null, "Vinicius Henrique", "vine@gmail.com", 19, Gender.MALE);
        Employee emp2 = new Employee(null, "Luzia Lucia", "luzia@gmail.com", 30, Gender.MALE);
        Employee emp3 = new Employee(null, "Matheus Silva", "mths@gmail.com", 25, Gender.MALE);

        employeeRepository.saveAll(Arrays.asList(emp1, emp2, emp3));

    }
}
