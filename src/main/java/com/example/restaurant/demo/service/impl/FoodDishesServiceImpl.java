package com.example.restaurant.demo.service.impl;

import com.example.restaurant.demo.entity.FoodDishes;
import com.example.restaurant.demo.entity.Ingredients;
import com.example.restaurant.demo.entity.Restaurant;
import com.example.restaurant.demo.exceptions.BookingException;
import com.example.restaurant.demo.exceptions.InternalServerErrorException;
import com.example.restaurant.demo.exceptions.NotFountException;
import com.example.restaurant.demo.json.CreateFoodDishesRest;
import com.example.restaurant.demo.json.UpdateFoodDishesRest;
import com.example.restaurant.demo.repository.FoodDishesRepository;
import com.example.restaurant.demo.repository.IngredientsRepository;
import com.example.restaurant.demo.repository.RestaurantRepository;
import com.example.restaurant.demo.service.FoodDishesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FoodDishesServiceImpl implements FoodDishesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodDishesServiceImpl.class);

    @Autowired
    private FoodDishesRepository foodDishesRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    IngredientsRepository ingredientsRepository;

    @Override
    public String deleteFoodDishes(Long id) throws BookingException {


        try {
            foodDishesRepository.deleteById(id);
        }catch (Exception e){
            LOGGER.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }

        return "FOOD_DISHEs_DELETED";
    }

    @Override
    public String createFoodDishes(UpdateFoodDishesRest createFoodDishesRest) throws BookingException {

        final FoodDishes foods = foodDishesRepository.findById(createFoodDishesRest.getId())
                .orElseThrow(() -> new NotFountException("FoodDishes_NOT_FOUND", "FoodDishes_NOT_FOUND"));

        final Restaurant restaurants = restaurantRepository.findById(createFoodDishesRest.getRestaurants())
                .orElseThrow(() -> new NotFountException("Restaurant_NOT_FOUND", "Restaurant_NOT_FOUND"));

        //List<Long> roles = createFoodDishesRest.getIngredients().stream().map(service -> service.getId()).collect(Collectors.toList());
        //String roless = roles.toString();

        final FoodDishes foodDishes = new FoodDishes();

        foodDishes.setId(foods.getId());
        foodDishes.setName(createFoodDishesRest.getName());
        foodDishes.setDuration_time(createFoodDishesRest.getDuration_time());
        foodDishes.setCreation_date(createFoodDishesRest.getCreation_date());
        foodDishes.setRestaurants(restaurants);

       // Set<Ingredients> ingredients = new HashSet<>();

        try {
            foodDishesRepository.save(foodDishes);
        }catch (final Exception e){
            LOGGER.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }

        return "SE ACTUALIZO SU FOOD_DISHES";
    }

    @Override
    public String createFoodDishess(CreateFoodDishesRest createFoodDishesRest) throws BookingException {

        final Restaurant restaurants = restaurantRepository.findById(createFoodDishesRest.getRestaurants())
                .orElseThrow(() -> new NotFountException("Restaurant_NOT_FOUND", "Restaurant_NOT_FOUND"));

        final FoodDishes foodDishes = new FoodDishes();

        foodDishes.setName(createFoodDishesRest.getName());
        foodDishes.setDuration_time(createFoodDishesRest.getDuration_time());
        foodDishes.setCreation_date(createFoodDishesRest.getCreation_date());
        foodDishes.setRestaurants(restaurants);

        try {
            foodDishesRepository.save(foodDishes);
        }catch (final Exception e){
            LOGGER.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }

        return "SE AGREGO SU FOOD_DISHES";
    }


}
