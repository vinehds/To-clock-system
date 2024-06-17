package com.vinehds.ToClockSystem.repositories;

import com.vinehds.ToClockSystem.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

}
