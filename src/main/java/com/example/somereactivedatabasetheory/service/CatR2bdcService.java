package com.example.somereactivedatabasetheory.service;

import com.example.somereactivedatabasetheory.entity.CatEntity;
import com.example.somereactivedatabasetheory.repository.r2dbc.CatR2dbcRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class CatR2bdcService {
    private final CatR2dbcRepository catRepository;


    public CatR2bdcService(CatR2dbcRepository catRepository) {
        this.catRepository = catRepository;
    }

    public Flux<CatEntity> getAllCats() {
        return catRepository.findAll();
    }



    public Mono<CatEntity> getCatById(Long id) {
        return Flux.range(0, 100)
                .flatMap(i -> catRepository.findById(id))
                .collectList().flatMap(i->catRepository.findById(id));
    }
    public Mono<CatEntity> getCatByIdTest(Long id) {
        return catRepository.findById(id);
    }

    public Mono<CatEntity> createCat(CatEntity cat) {
        return catRepository.save(cat);
    }

    public Mono<CatEntity> updateCat(CatEntity cat) {
        return catRepository.save(cat);
    }

    public Mono<Void> deleteCat(Long id) {
        return catRepository.deleteById(id);
    }
}