package com.example.somereactivedatabasetheory.service;

import com.example.somereactivedatabasetheory.configuration.jpa.CatEntity;
import com.example.somereactivedatabasetheory.repository.jpa.CatJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CatBlockingService {

    private final CatJpaRepository catRepository;

    public CatBlockingService(CatJpaRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<CatEntity> getAllCats() {
        return catRepository.findAll();
    }

    public CatEntity getCatById(Long id) {
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