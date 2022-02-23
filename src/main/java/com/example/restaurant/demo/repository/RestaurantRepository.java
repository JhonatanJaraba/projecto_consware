package com.example.restaurant.demo.repository;

import com.example.restaurant.demo.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {


    Optional<Restaurant> findById(Long id);

    @Query("SELECT REST FROM Restaurant REST")
    public List<Restaurant> findRestaurants();



}
