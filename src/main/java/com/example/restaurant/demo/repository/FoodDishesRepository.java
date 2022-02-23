package com.example.restaurant.demo.repository;

import com.example.restaurant.demo.entity.FoodDishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface FoodDishesRepository extends JpaRepository<FoodDishes, Long> {

    Optional<FoodDishes> findById(Long id);

}
