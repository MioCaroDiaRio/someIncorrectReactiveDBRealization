package com.example.somereactivedatabasetheory.service;

import com.example.somereactivedatabasetheory.configuration.jpa.CatEntity;
import com.example.somereactivedatabasetheory.repository.jpa.CatJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Service
@Slf4j
public class CatBlockingCreationService {

    private final CatJpaRepository catRepository;
    public CatBlockingCreationService(CatJpaRepository catRepository) {
        this.catRepository = catRepository;
    }

    public void createCats() {
        long startTime = System.currentTimeMillis();
        IntStream.range(0, 10000).forEach(i -> {
            CatEntity cat = new CatEntity();
            cat.setName("Cat " + i);
            cat.setColor("Color " + i);
            catRepository.save(cat);
        });
        long endTime = System.currentTimeMillis();
        log.info("Блокирующее создание: " + (endTime - startTime) + " ms");
    }
    public void createCatsAsync() {
        long startTime = System.currentTimeMillis();
        List<CompletableFuture<Void>> futures = IntStream.range(0, 10000)
                .mapToObj(i -> CompletableFuture.runAsync(() -> {
                    CatEntity cat = new CatEntity();
                    cat.setName("Cat " + i);
                    cat.setColor("Color " + i);
                    catRepository.save(cat);
                }))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        long endTime = System.currentTimeMillis();
        log.info("Асинхронное создание: " + (endTime - startTime) + " ms");
    }
}
