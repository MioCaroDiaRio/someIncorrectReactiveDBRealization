package com.example.somereactivedatabasetheory.service;

import com.example.somereactivedatabasetheory.entity.CatEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Slf4j
public class CatCreationService {

    private final CatR2bdcService catR2bdcService;

    public CatCreationService(CatR2bdcService catR2bdcService) {
        this.catR2bdcService = catR2bdcService;
    }

    public Mono<Void> createCats() {
        long startTime = System.currentTimeMillis();
        return Flux.range(0, 10000)
                .flatMap(i -> {
                    CatEntity cat = new CatEntity();
                    cat.setName("Cat " + i);
                    cat.setColor("Color " + i);
                    return catR2bdcService.createCat(cat);
                })
                .doOnComplete(() -> {
                    long endTime = System.currentTimeMillis();
                    log.info("R2DBC: " + (endTime - startTime) + " ms");
                })
                .then();
    }
}