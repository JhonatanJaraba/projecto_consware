package com.example.restaurant.demo.service;

import com.example.restaurant.demo.exceptions.BookingException;
import com.example.restaurant.demo.json.*;

import java.util.List;

public interface FoodDishesService {

    public String deleteFoodDishes(Long id) throws BookingException;

    String updateFoodDishes(UpdateFoodDishesRest createFoodDishesRest) throws BookingException;

    String createFoodDishess(CreateFoodDishesRest createFoodDishesRest) throws BookingException;

    public List<RestFoodDishesRest> getListaPlatos() throws BookingException;

    public List<RestFoodDishesRest> getCountPlatos() throws BookingException;
}
