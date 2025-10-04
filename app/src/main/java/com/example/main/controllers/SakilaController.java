package com.example.main.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.repositories.SakilaRepository;

@RestController
@RequestMapping("/sakila")
public class SakilaController {
    
    private final SakilaRepository sakilaRepository;

    public SakilaController(SakilaRepository sakilaRepository){
        this.sakilaRepository = sakilaRepository;
    }

    @GetMapping("/getAllActors")
    public List<Map<String, Object>> getAll() {
        return sakilaRepository.findAll();
    }

    @GetMapping("/findActorById/{id}")
    public Map<String, Object> findById(@PathVariable int id) {
        return sakilaRepository.findById(id);
    }

}
