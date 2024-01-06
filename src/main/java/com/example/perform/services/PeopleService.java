package com.example.perform.services;

import com.example.perform.models.Person;
import com.example.perform.repositories.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PeopleService {

    private AtomicInteger countOfAttemptsWithoutLocks = new AtomicInteger();
    private AtomicInteger countOfAttemptsWithLocks = new AtomicInteger();

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

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Retryable(maxAttempts = 10)
    public void addLikeBySurnameSerialWithoutLocks(String surname) {
        countOfAttemptsWithoutLocks.incrementAndGet();
        List<Person> allBySurname = peopleRepository.findAllBySurname(surname);
        for (Person person : allBySurname) {
            Integer like = person.getLikes();
            if (like==null) {
                like=1;
            } else {
                like++;
            }
            person.setLikes(like);
        }
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Retryable(maxAttempts = 15)
    public void addLikeBySurnameReadCommPessLock(String surname) {
        countOfAttemptsWithLocks.incrementAndGet();
        List<Person> allBySurname = peopleRepository.findAllBySurname(surname);
        for (Person person : allBySurname) {
            Integer like = person.getLikes();
            if (like==null) {
                like=1;
            } else {
                like++;
            }
            person.setLikes(like);
        }

    }

    public String getAttemptsCount() {
        return "Число попыток без локов: " + countOfAttemptsWithoutLocks.get()
                + "\n Число попыток с локом:  " + countOfAttemptsWithLocks.get();
    }

}










