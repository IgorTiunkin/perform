package com.example.perform.controllers;

import com.example.perform.models.Person;
import com.example.perform.services.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;


@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class BaseController {

    private final PeopleService peopleService;

    @RequestMapping("/all")
    public String getAll(Model model){
        List<Person> people = peopleService.findAll();
        model.addAttribute("people", people);
        return "/all";
    }


}
