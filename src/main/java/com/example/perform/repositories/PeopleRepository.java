package com.example.perform.repositories;

import com.example.perform.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

    List<Person> findAllByName (String name);

    List <Person> findAllBySurname (String surname);

    List <Person> findAllByAge (Integer age);

}
