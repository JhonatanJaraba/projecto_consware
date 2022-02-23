package com.example.restaurant.demo.service;

import com.example.restaurant.demo.entity.Restaurant;
import com.example.restaurant.demo.exceptions.BookingException;
import com.example.restaurant.demo.json.CreateFoodDishesRest;
import com.example.restaurant.demo.json.RestaurantFoodDishesRest;
import com.example.restaurant.demo.json.RestaurantRest;

import java.util.List;

public interface RestaurantService {

    public List<RestaurantRest> getRestaurants() throws BookingException;

    public List<RestaurantFoodDishesRest> getRestaurantsFoodDishes() throws BookingException;

    RestaurantFoodDishesRest getRestaurantById(Long restaurantId) throws BookingException;


}
