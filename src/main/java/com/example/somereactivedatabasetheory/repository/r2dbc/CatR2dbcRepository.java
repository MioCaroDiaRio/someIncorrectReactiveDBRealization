package com.example.somereactivedatabasetheory.repository.r2dbc;

import com.example.somereactivedatabasetheory.entity.CatEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatR2dbcRepository extends R2dbcRepository<CatEntity, Long> {
}
