package com.vinehds.ToClockSystem.config;

import com.vinehds.ToClockSystem.entities.Employee;
import com.vinehds.ToClockSystem.entities.Record;
import com.vinehds.ToClockSystem.entities.enums.Clock;
import com.vinehds.ToClockSystem.entities.enums.Gender;
import com.vinehds.ToClockSystem.repositories.EmployeeRepository;
import com.vinehds.ToClockSystem.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public void run(String... args) throws Exception {

        Employee emp1 = new Employee(null, "Vinicius Henrique", "vine@gmail.com", 19, Gender.MALE);
        Employee emp2 = new Employee(null, "Luzia Lucia", "luzia@gmail.com", 30, Gender.FEMALE);
        Employee emp3 = new Employee(null, "Matheus Silva", "mths@gmail.com", 25, Gender.MALE);

        employeeRepository.saveAll(Arrays.asList(emp1, emp2, emp3));

        Record rec1 = new Record(null, null);
        Record rec2 = new Record(null, null);
        Record rec3 = new Record(null, null);
        Record rec4 = new Record(null, null);

        recordRepository.saveAll(Arrays.asList(rec1, rec2, rec3, rec4));

        emp1.addRecord(rec1);
        emp1.addRecord(rec2);
        emp1.addRecord(rec3);
        emp1.addRecord(rec4);


        employeeRepository.save(emp1);
    }
}
