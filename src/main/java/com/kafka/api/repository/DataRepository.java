package com.kafka.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.api.model.Data;

public interface DataRepository extends JpaRepository<Data, Integer> {
 
}
