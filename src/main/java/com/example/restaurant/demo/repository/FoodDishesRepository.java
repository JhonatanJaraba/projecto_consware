package com.example.restaurant.demo.repository;

import com.example.restaurant.demo.entity.CountPlatos;
import com.example.restaurant.demo.entity.FoodDishes;
import com.example.restaurant.demo.entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodDishesRepository extends JpaRepository<FoodDishes, Long> {

    Optional<FoodDishes> findById(Long id);

    long countByIngredients(Ingredients ingredients);

    @Query("SELECT REST FROM FoodDishes REST")
    List<FoodDishes> getFood();
}
