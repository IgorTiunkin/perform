package com.example.perform.service;

import com.example.perform.PerformApplication;
import com.example.perform.models.Person;
import com.example.perform.services.PeopleService;
import org.openjdk.jmh.annotations.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@State(Scope.Thread)
public class PeopleServiceIndexBenchmark {
    private PeopleService peopleService;
    private ConfigurableApplicationContext applicationContext;

    @Setup
    public void setup() {
        applicationContext = new SpringApplication(PerformApplication.class).run();
        peopleService = applicationContext.getBean(PeopleService.class);
    }

    @TearDown
    public void tearDown() {
        applicationContext.close();
    }

    @Benchmark
    public List<Person> findAllByName() {
        return peopleService.findAllByName("IvanIvan");
    }

    @Benchmark
    public List<Person> findAllBySurname() {
        return peopleService.findAllBySurName("BondBond");
    }

}
