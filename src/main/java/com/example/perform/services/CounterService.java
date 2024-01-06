package com.example.perform.services;

import com.example.perform.models.Counter;
import com.example.perform.repositories.CounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CounterService {

    private final CounterRepository counterRepository;

    @Transactional
    public void addCounter() {
        Counter counter = counterRepository.findById(1).get();
        Integer currentNumber = counter.getCounter();
        counter.setCounter(currentNumber+1);
    }

    public Integer getCount () {
        return counterRepository.getById(1).getCounter();
    }
}
