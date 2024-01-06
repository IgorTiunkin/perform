package com.example.perform.repositories;

import com.example.perform.models.Counter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends JpaRepository <Counter, Integer> {

    @Modifying
    @Query (value = "update counters set counter = counter+1", nativeQuery = true)
    void add();
}
