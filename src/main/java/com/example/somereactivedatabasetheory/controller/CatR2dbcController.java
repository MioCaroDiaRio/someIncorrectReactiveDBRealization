package com.example.somereactivedatabasetheory.controller;
import com.example.somereactivedatabasetheory.entity.CatEntity;
import com.example.somereactivedatabasetheory.service.CatR2bdcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/api/r2dbc/cats")
public class CatR2dbcController {

    private final CatR2bdcService catService;

    public CatR2dbcController(CatR2bdcService catService) {
        this.catService = catService;
    }

    @GetMapping
    public Flux<CatEntity> getAllCats() {
        log.info("Реактивный котик!");
        return catService.getAllCats();
    }

    @GetMapping("/getCatById")
    public Mono<CatEntity> getCatById(@RequestParam Long id) {
        return catService.getCatById(id);
    }

    @PostMapping
    public Mono<CatEntity> createCat(@RequestBody CatEntity cat) {
        return catService.createCat(cat);
    }

    @PutMapping("/put")
    public Mono<CatEntity> updateCat(@RequestParam Long id, @RequestBody CatEntity cat) {
        cat.setId(id);
        return catService.updateCat(cat);
    }

    @DeleteMapping("/delete")
    public Mono<Void> deleteCat(@RequestParam Long id) {
        return catService.deleteCat(id);
    }
}