package com.example.perform.controllers;

import com.example.perform.models.Person;
import com.example.perform.services.DataInitService;
import com.example.perform.services.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class PeopleController {

    private final PeopleService peopleService;
    private final DataInitService dataInitService;

    @RequestMapping("/all")
    public String getAll(Model model){
        List<Person> people = peopleService.findAll();
        model.addAttribute("people", people);
        return "/all";
    }

    @RequestMapping("/rest-all")
    @ResponseBody
    public List<Person> getAll(){
        return peopleService.findAll();
    }

    @RequestMapping("/init")
    public void initDb () {
        dataInitService.saveRandomPersons(10000);
    }

    @RequestMapping("/allByName")
    @ResponseBody
    public List<Person> allByName() {
        return peopleService.findAllByName("IvanIvan");
    }

    @RequestMapping("/allBySurname")
    @ResponseBody
    public List<Person> allBySurname() {
        return peopleService.findAllBySurName("BondBond");
    }

    @RequestMapping("/allByAge")
    @ResponseBody
    public List<Person> allByAge() {
        return peopleService.findAllByAge(125);
    }

    @RequestMapping("/addLikeBySurnameSerialWithoutLocks")
    @ResponseBody
    public void addLikeBySurnameSerialWithoutLocks() {
        peopleService.addLikeBySurnameSerialWithoutLocks("BondBond");
    }

    @RequestMapping("/addLikeBySurnameReadCommPessLock")
    @ResponseBody
    public void addLikeBySurnameReadCommPessLock() {
        peopleService.addLikeBySurnameReadCommPessLock("BondBond");
    }

    @RequestMapping("/countOfAttempts")
    @ResponseBody
    public String countOfAttempts() {
        return peopleService.getAttemptsCount();
    }


}
