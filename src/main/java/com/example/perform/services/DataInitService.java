package com.example.perform.services;

import com.example.perform.models.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class DataInitService {

    private final PeopleService peopleService;

    private List <String> names = List.of("Ivan", "Petr", "Sidor", "James", "Jacob", "Bill", "Sally",
            "Mary", "Helen", "Anna");
    private List <String> surnames = List.of("Ivanov", "Petrov", "Sidorov", "Bond", "Sallyvan",
            "Sue", "Clint", "Smith", "Dow");
    private Random random = new Random();

    private Person generateRandomPerson() {
        String randomName1 = names.get(random.nextInt(names.size()));
        String randomName2 = names.get(random.nextInt(names.size()));
        String randomSurname1 = surnames.get(random.nextInt(surnames.size()));
        String randomSurname2 = surnames.get(random.nextInt(surnames.size()));
        Integer randomAge = random.nextInt(1000);
        LocalDateTime timestamp = LocalDateTime.now();
        return Person.builder()
                .name(randomName1+randomName2)
                .surname(randomSurname1+randomSurname2)
                .age(randomAge)
                .createdAt(timestamp)
                .build();
    }

    public void saveRandomPersons (Integer quantity) {
        for (int i = 0; i < quantity; i++) {
            Person person = generateRandomPerson();
            peopleService.save(person);
        }
    }

}
