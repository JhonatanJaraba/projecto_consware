package com.example.restaurant.demo.controllers;

import com.example.restaurant.demo.exceptions.BookingException;
import com.example.restaurant.demo.json.RestaurantFoodDishesRest;
import com.example.restaurant.demo.json.RestaurantRest;
import com.example.restaurant.demo.response.BookingResponse;
import com.example.restaurant.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "restaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<List<RestaurantRest>> getRestaurants() throws BookingException {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", restaurantService.getRestaurants());
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "restaurants_food_dishes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<List<RestaurantFoodDishesRest>> getRestaurantsFoodDishes() throws BookingException {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", restaurantService.getRestaurantsFoodDishes());
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "restaurant" + "/{" + "restaurantId"
            + "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<RestaurantFoodDishesRest> getRestaurantById(@PathVariable Long restaurantId) throws BookingException {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
                restaurantService.getRestaurantById(restaurantId));
    }


}
