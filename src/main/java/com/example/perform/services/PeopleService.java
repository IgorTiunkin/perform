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

    @Transactional()
    public void save (Person person) {
        peopleRepository.save(person);
    }

    public List <Person> findAllByName(String name) {
        return peopleRepository.findAllByName(name);
    }

    public List <Person> findAllBySurName(String surname) {
        return peopleRepository.findAllBySurname(surname);
    }

    public List <Person> findAllByAge(Integer age) {
        return peopleRepository.findAllByAge(age);
    }

}
