package com.example.somereactivedatabasetheory.configuration.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table("cat")
public class CatEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String color;

}
