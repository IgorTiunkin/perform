package com.example.perform.service;

import com.example.perform.PerformApplication;
import com.example.perform.models.Person;
import com.example.perform.services.PeopleService;
import org.openjdk.jmh.annotations.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@State(Scope.Thread)
public class PeopleServiceBenchmark {

    private PeopleService peopleService;
    private ConfigurableApplicationContext applicationContext;

    @Setup
    public void setup() {
        applicationContext = new SpringApplication(PerformApplication.class).run();
        peopleService = applicationContext.getBean(PeopleService.class);
        System.out.println("Setup");
    }

    @TearDown
    public void tearDown() {
        applicationContext.close();
        System.out.println("Tear down");
    }

    @Benchmark
    public List<Person> findAll() {
        return peopleService.findAll();
    }

    @Benchmark
    public void save() {
        Person person = Person.builder()
                .name("Ivan")
                .surname("Ivanov")
                .age(20)
                .build();
        peopleService.save(person);
    }
}
