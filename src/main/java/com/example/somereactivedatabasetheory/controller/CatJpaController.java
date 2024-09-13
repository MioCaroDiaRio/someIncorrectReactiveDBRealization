package com.example.somereactivedatabasetheory.controller;


import com.example.somereactivedatabasetheory.configuration.jpa.CatEntity;
import com.example.somereactivedatabasetheory.service.CatBlockingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/jpa/cats")
public class CatJpaController {

    private final CatBlockingService catService;

    public CatJpaController(CatBlockingService catService) {
        this.catService = catService;
    }

    @GetMapping
    public List<CatEntity> getAllCats() {
        log.info("Обычный котик!");

        return catService.getAllCats();
    }

    @GetMapping("/getCatById")
    public CatEntity getCatById(@RequestParam Long id) {
        return catService.getCatById(id);
    }

    @GetMapping("/getCatByIdTest")
    public CatEntity getCatByIdTest(@RequestParam Long id) {
        return catService.getCatById(id);
    }

    @PostMapping
    public CatEntity createCat(@RequestBody CatEntity cat) {
        return catService.createCat(cat);
    }

    @PutMapping("/putCat")
    public CatEntity updateCat(@RequestParam Long id, @RequestBody CatEntity cat) {
        cat.setId(id);
        return catService.updateCat(cat);
    }

    @DeleteMapping("/deleteCat")
    public void deleteCat(@RequestParam Long id) {
        catService.deleteCat(id);
    }
}