package com.example.restaurant.demo.service;

import com.example.restaurant.demo.exceptions.BookingException;
import com.example.restaurant.demo.json.CreateFoodDishesRest;
import com.example.restaurant.demo.json.UpdateFoodDishesRest;

public interface FoodDishesService {

    public String deleteFoodDishes(Long id) throws BookingException;

    String createFoodDishes(UpdateFoodDishesRest createFoodDishesRest) throws BookingException;

    String createFoodDishess(CreateFoodDishesRest createFoodDishesRest) throws BookingException;
}
