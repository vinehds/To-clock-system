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
    private Clock clock;
    private Instant moment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Record() {
    }

    public Record(Clock clock, Instant moment) {

        if (moment == null){
            moment = Instant.now();
        }
        this.clock = clock;
        this.moment = moment;
    }

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
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
