package com.kafka.api.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.api.model.Data;
import com.kafka.api.repository.DataRepository;

@Service
@Transactional
public class DataService {
 
    @Autowired
    private DataRepository repo;
     
    public List<Data> listAll() {
        return repo.findAll();
    }
     
    public void save(Data product) {
        repo.save(product);
    }
     
    public Data get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}