package com.example.perform.services;

import com.example.perform.models.Person;
import com.example.perform.repositories.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    @Transactional(readOnly = false)
    public void save (Person person) {
        peopleRepository.save(person);
    }

}
