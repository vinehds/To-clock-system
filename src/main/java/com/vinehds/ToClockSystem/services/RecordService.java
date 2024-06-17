package com.vinehds.ToClockSystem.services;


import com.vinehds.ToClockSystem.entities.Record;
import com.vinehds.ToClockSystem.repositories.RecordRepository;
import com.vinehds.ToClockSystem.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {

    @Autowired
    private RecordRepository repository;

    public List<Record> findAll(){
         return repository.findAll();
    }

    public Record findById(Long id){
        Optional<Record> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}