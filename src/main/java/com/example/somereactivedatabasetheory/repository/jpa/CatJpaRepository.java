package com.example.somereactivedatabasetheory.repository.jpa;

import com.example.somereactivedatabasetheory.configuration.jpa.CatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatJpaRepository extends JpaRepository<CatEntity, Long> {

}