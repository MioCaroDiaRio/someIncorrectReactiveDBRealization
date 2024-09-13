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
public class CatBlockingService {

    private final CatJpaRepository catRepository;


    public CatBlockingService(CatJpaRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<CatEntity> getAllCats() {
        return catRepository.findAll();
    }

//    public CatEntity getCatById(Long id) {
//    for(int i = 0; i<100; i++) {
//        catRepository.findById(id);
//    }
//        return catRepository.findById(id).orElseThrow();
//    }

    //public CatEntity getCatById(Long id) {
//        IntStream.range(0, 100)
//                .mapToObj(i -> CompletableFuture.runAsync(() -> {
//                    catRepository.findById(id);
//                })).toList();
//        return catRepository.findById(id).orElseThrow();
//    }

    public CatEntity getCatById(Long id) {
        List<CompletableFuture<Void>> futures = IntStream.range(0, 100)
                .mapToObj(i -> CompletableFuture.runAsync(() -> catRepository.findById(id))).toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        return catRepository.findById(id).orElseThrow();
    }

    public CatEntity getCatByIdTest(Long id) {
        return catRepository.findById(id).orElseThrow();
    }

    public CatEntity createCat(CatEntity cat) {
        return catRepository.save(cat);
    }

    public CatEntity updateCat(CatEntity cat) {
        return catRepository.save(cat);
    }

    public void deleteCat(Long id) {
        catRepository.deleteById(id);
    }
}