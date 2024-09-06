package com.example.somereactivedatabasetheory.controller;

import com.example.somereactivedatabasetheory.service.CatBlockingCreationService;
import com.example.somereactivedatabasetheory.service.CatCreationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cats")
public class CreationController {

    private final CatCreationService catCreationService;
    private final CatBlockingCreationService catBlockingCreationService;

    public CreationController(CatCreationService catCreationService, CatBlockingCreationService catBlockingCreationService) {
        this.catCreationService = catCreationService;
        this.catBlockingCreationService = catBlockingCreationService;
    }

    @PostMapping("/create")
    public Mono<Void> createCats() {
        return catCreationService.createCats();
    }

    @PostMapping("/createBlocking")
    public String createCatsBlocking() {
        catBlockingCreationService.createCats();
        return "Котейки созданы";
    }
    @PostMapping("/createAsync")
    public String createCatsAsync() {
        catBlockingCreationService.createCatsAsync();
        return "Котейки созданы";
    }

}