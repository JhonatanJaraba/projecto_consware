package com.example.restaurant.demo.controllers;

import com.example.restaurant.demo.exceptions.BookingException;
import com.example.restaurant.demo.json.UpdateFoodDishesRest;
import com.example.restaurant.demo.response.BookingResponse;
import com.example.restaurant.demo.service.FoodDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class FoodDishesController {

    @Autowired
    FoodDishesService foodDishesService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/deleteReservation", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<String> deleteReservation(@RequestParam Long id) throws BookingException {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
                foodDishesService.deleteFoodDishes(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "update_fooddishes", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<String> createReservation(@RequestBody @Valid UpdateFoodDishesRest updateFoodDishesRest)
            throws BookingException {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
                foodDishesService.createFoodDishes(updateFoodDishesRest));
    }

}
