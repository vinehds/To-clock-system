package com.vinehds.ToClockSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vinehds.ToClockSystem.entities.enums.Clock;
import jakarta.persistence.*;

import java.io.Serializable;

import java.time.Instant;
@Entity
public class Record implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Clock tipo;
    private Instant moment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Record() {
    }

    public Record(Clock value, Instant moment) {

        if (moment == null){
            moment = Instant.now();
        }
        this.tipo = value;
        this.moment = moment;
    }

    public Clock getTipo() {
        return tipo;
    }

    public void setTipo(Clock tipo) {
        this.tipo = tipo;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
