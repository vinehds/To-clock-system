package com.vinehds.ToClockSystem.entities;

import com.vinehds.ToClockSystem.entities.enums.Clock;
import com.vinehds.ToClockSystem.entities.enums.Gender;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_employees")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private Integer gender;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Record> records = new ArrayList<>();

    public Employee() {
    }

    public Employee(Long id, String name, String email, Integer age, Gender gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        setGender(gender);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return Gender.valueOf(gender);
    }

    public void setGender(Gender gender) {
        if (gender != null) {
            this.gender = gender.getCode();
        }
    }

    public List<Record> getRecords() {
        return records;
    }


    public void addRecord(Record record){
        if(records.isEmpty()){
            record.setClock(Clock.IN);
        }
        else if(records.get(records.size()-1).getClock() == Clock.IN){
            record.setClock(Clock.OUT);
        }
        else{
            record.setClock((Clock.IN));
        }

        if(record.getMoment() == null){
            record.setMoment(Instant.now());
        }

        records.add(record);
        record.setEmployee(this);
    }


    public long workedHours() throws Exception {
        if (records.size() % 2 != 0) {
            throw new Exception("Usuário com registros ímpares, expediente em andamento");
        }

        long workedHours;
        Duration workedDuration = Duration.ZERO;
        Instant entrada, saida;

        for (int i = 0; i < records.size(); i = i + 2) {
            entrada = records.get(i).getMoment();
            saida = records.get(i + 1).getMoment();

            Duration duration = Duration.between(entrada, saida);
            workedDuration = workedDuration.plus(duration);
        }

        workedHours = workedDuration.toMinutes();
        workedHours = workedHours / 60;
        return workedHours;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
