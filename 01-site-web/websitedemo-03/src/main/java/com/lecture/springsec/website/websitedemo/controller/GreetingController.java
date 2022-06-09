package com.lecture.springsec.website.websitedemo.controller;

import java.util.ArrayList;
import java.util.List;

import com.lecture.springsec.website.websitedemo.model.Greeting;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    static List<Greeting> greetings = new ArrayList<>();

    @GetMapping("/greetings")
    public String showGreetings(Model model) {
        // On va afficher la liste dans la page
        model.addAttribute("greetings", greetings);
        // Il nous faut avoir un objet pour récupérer les données de formulaire
        model.addAttribute("newGreeting", new Greeting(1, "default content"));
        return "greetings";
    }

    @PostMapping("/greeting")
    public String addGreeting(@ModelAttribute Greeting newGreeting) {
        greetings.add(new Greeting(newGreeting.getId(), newGreeting.getContent()));
        return "redirect:greetings";
    }

    @GetMapping("/survie")
    public String showSurvie(Model model) {
        return "survie";
    }

    @GetMapping("/")
    public String showWelcome(Model model) {
        return "welcome";
    }
}
