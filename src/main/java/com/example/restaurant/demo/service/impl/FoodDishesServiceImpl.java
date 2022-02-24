package com.example.restaurant.demo.service.impl;

import com.example.restaurant.demo.entity.CountPlatos;
import com.example.restaurant.demo.entity.FoodDishes;
import com.example.restaurant.demo.entity.Ingredients;
import com.example.restaurant.demo.entity.Restaurant;
import com.example.restaurant.demo.exceptions.BookingException;
import com.example.restaurant.demo.exceptions.InternalServerErrorException;
import com.example.restaurant.demo.exceptions.NotFountException;
import com.example.restaurant.demo.json.*;
import com.example.restaurant.demo.repository.CountPlatosRepository;
import com.example.restaurant.demo.repository.FoodDishesRepository;
import com.example.restaurant.demo.repository.IngredientsRepository;
import com.example.restaurant.demo.repository.RestaurantRepository;
import com.example.restaurant.demo.service.FoodDishesService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FoodDishesServiceImpl implements FoodDishesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodDishesServiceImpl.class);

    public static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private FoodDishesRepository foodDishesRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    IngredientsRepository ingredientsRepository;

    @Autowired
    CountPlatosRepository countPlatosRepository;

    /**
     * LOGICA DE NEGOCIO PARA ELIMINAR UN PLATILLO
     * @param id
     * @return
     * @throws BookingException
     */
    @Override
    public String deleteFoodDishes(Long id) throws BookingException {

        final FoodDishes foods = foodDishesRepository.findById(id)
                .orElseThrow(() -> new NotFountException("FoodDishes_NOT_FOUND", "FoodDishes_NOT_FOUND"));

        try {
            foodDishesRepository.deleteById(id);
        }catch (Exception e){
            LOGGER.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }

        return "FOOD_DISHEs_DELETED";
    }

    /**
     * LOGICA DE NEGOCIO PARA ACTUALIZAR UN PLATILLO
     * @param updateFoodDishesRest
     * @return
     * @throws BookingException
     */
    @Override
    public String updateFoodDishes(UpdateFoodDishesRest updateFoodDishesRest) throws BookingException {

        final FoodDishes foods = foodDishesRepository.findById(updateFoodDishesRest.getId())
                .orElseThrow(() -> new NotFountException("FoodDishes_NOT_FOUND", "FoodDishes_NOT_FOUND"));

        final Restaurant restaurants = restaurantRepository.findById(updateFoodDishesRest.getRestaurants())
                .orElseThrow(() -> new NotFountException("Restaurant_NOT_FOUND", "Restaurant_NOT_FOUND"));

        final FoodDishes foodDishes = new FoodDishes();

        foodDishes.setId(foods.getId());
        foodDishes.setName(updateFoodDishesRest.getName());
        foodDishes.setDuration_time(updateFoodDishesRest.getDuration_time());
        foodDishes.setCreation_date(updateFoodDishesRest.getCreation_date());
        foodDishes.setRestaurants(restaurants);

        final Set<Ingredients> ingredients = new HashSet<>();

        for (int i = 0; i < updateFoodDishesRest.getIngredients().size(); i++) {
            ingredients.add(ingredientsRepository.findByName(updateFoodDishesRest.getIngredients().get(i)).get());
            foodDishes.setIngredients(ingredients);
        }

        try {
            foodDishesRepository.save(foodDishes);
        }catch (final Exception e){
            LOGGER.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }

        return "SE ACTUALIZO SU FOOD_DISHES";
    }

    /**
     * LOGICA DE NEGOCIO PARA CREAR UN PLATILLO
     * @param createFoodDishesRest
     * @return
     * @throws BookingException
     */
    @Override
    public String createFoodDishess(CreateFoodDishesRest createFoodDishesRest) throws BookingException {

        final Restaurant restaurants = restaurantRepository.findById(createFoodDishesRest.getRestaurants())
                .orElseThrow(() -> new NotFountException("Restaurant_NOT_FOUND", "Restaurant_NOT_FOUND"));

        final FoodDishes foodDishes = new FoodDishes();

        foodDishes.setName(createFoodDishesRest.getName());
        foodDishes.setDuration_time(createFoodDishesRest.getDuration_time());
        foodDishes.setCreation_date(createFoodDishesRest.getCreation_date());
        foodDishes.setRestaurants(restaurants);

        final Set<Ingredients> ingredients = new HashSet<>();

        for (int i = 0; i < createFoodDishesRest.getIngredients().size(); i++) {
            ingredients.add(ingredientsRepository.findByName(createFoodDishesRest.getIngredients().get(i)).get());
            foodDishes.setIngredients(ingredients);
        }

        try {
            foodDishesRepository.save(foodDishes);
        }catch (final Exception e){
            LOGGER.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }

        return "SE AGREGO SU FOOD_DISHES";
    }

    /**
     * LOGICA DE NEGOCIO PARA LISTAR PLATILLOS
     * @return
     * @throws BookingException
     */
    @Override
    public List<RestFoodDishesRest> getListaPlatos() throws BookingException {
        final List<FoodDishes> restaurantsEntity = foodDishesRepository.findAll();
        return restaurantsEntity.stream().map(service -> modelMapper.map(service, RestFoodDishesRest.class))
                .collect(Collectors.toList());
    }

    /**
     * LOGICA DE NEGOCIO PARA LISTAR LOS PLATILLOS QUE TIENEN MAS DE 3 INGREDIENTES
     * @return
     * @throws BookingException
     */
    @Override
    public List<RestFoodDishesRest> getCountPlatos() throws BookingException {

        final List<CountPlatos> countplatosEntity = countPlatosRepository.getCountPlatos();
        List<Long> list4 = new ArrayList<>();
        List<FoodDishes> food = new ArrayList<>();

        for (int i = 0; i < countplatosEntity.size(); i++) {
            if(countplatosEntity.get(i).getNum_ingredientes() > 2){
                Long id = countplatosEntity.get(i).getId_platos();
                list4.add(id);
            }
        }
        for (int i = 0; i < list4.size(); i++) {
            final FoodDishes foods = foodDishesRepository.findById(list4.get(i))
                    .orElseThrow(() -> new NotFountException("FoodDishes_NOT_FOUND", "FoodDishes_NOT_FOUND"));
            food.add(foods);
        }
        return food.stream().map(service -> modelMapper.map(service, RestFoodDishesRest.class))
                .collect(Collectors.toList());
    }

}
