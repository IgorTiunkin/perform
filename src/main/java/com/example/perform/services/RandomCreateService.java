package com.example.perform.services;

import com.example.perform.models.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class RandomCreateService {

    private final PeopleService peopleService;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public void saveRandomUsers(int number) {
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            String name = generateRandomString(5);
            String surname = generateRandomString(10);
            int age = random.nextInt(100);
            Person person = Person.builder()
                    .name(name)
                    .surname(surname)
                    .age(age)
                    .build();
            peopleService.save(person);
        }
    }

    public String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public void get() {
        peopleService.findAll();
    }
}
