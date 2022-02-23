package com.example.restaurant.demo.repository;

import com.example.restaurant.demo.entity.Ingredients;
import com.example.restaurant.demo.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {

    Optional<Ingredients> findById(Long id);

}
