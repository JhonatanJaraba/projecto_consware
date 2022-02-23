package com.example.restaurant.demo.service.impl;

import com.example.restaurant.demo.entity.Restaurant;
import com.example.restaurant.demo.exceptions.BookingException;
import com.example.restaurant.demo.exceptions.NotFountException;
import com.example.restaurant.demo.json.RestaurantFoodDishesRest;
import com.example.restaurant.demo.json.RestaurantRest;
import com.example.restaurant.demo.repository.RestaurantRepository;
import com.example.restaurant.demo.service.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<RestaurantRest> getRestaurants() throws BookingException {
        final List<Restaurant> restaurantsEntity = restaurantRepository.findAll();
        return restaurantsEntity.stream().map(service -> modelMapper.map(service, RestaurantRest.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<RestaurantFoodDishesRest> getRestaurantsFoodDishes() throws BookingException {
        final List<Restaurant> restaurantsEntity = restaurantRepository.findAll();
        return restaurantsEntity.stream().map(service -> modelMapper.map(service, RestaurantFoodDishesRest.class))
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantFoodDishesRest getRestaurantById(Long restaurantId) throws BookingException {
        return modelMapper.map(getRestaurantByIds(restaurantId), RestaurantFoodDishesRest.class);
    }

    public Restaurant getRestaurantByIds(Long restaurantId) throws BookingException {
        return restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NotFountException("SNOT-404-1", "RESTAURANT_NOT_FOUND"));
    }







}
