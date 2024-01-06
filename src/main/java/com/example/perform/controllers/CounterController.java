package com.example.perform.controllers;

import com.example.perform.services.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/counter")
@RequiredArgsConstructor
public class CounterController {

    private final CounterService counterService;

    @RequestMapping("/add")
    @ResponseBody
    public void add() {
        counterService.addCounter();
    }
}
