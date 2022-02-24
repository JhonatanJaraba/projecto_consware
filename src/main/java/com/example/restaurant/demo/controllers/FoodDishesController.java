package com.example.restaurant.demo.controllers;

import com.example.restaurant.demo.exceptions.BookingException;
import com.example.restaurant.demo.json.*;
import com.example.restaurant.demo.response.BookingResponse;
import com.example.restaurant.demo.service.FoodDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class FoodDishesController {

    @Autowired
    FoodDishesService foodDishesService;

    /**
     * METODO PARA ELIMINAR PLATILLO
     *
     * @param id
     * @return
     * @throws BookingException
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/deletefooddishes", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<String> deleteFooddishes(@RequestParam Long id) throws BookingException {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
                foodDishesService.deleteFoodDishes(id));
    }

    /**
     * METODO PARA ACTUALIZAR PLATILLO
     * @param updateFoodDishesRest
     * @return
     * @throws BookingException
     */

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "update_fooddishes", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<String> updateFooddishes(@RequestBody @Valid UpdateFoodDishesRest updateFoodDishesRest)
            throws BookingException {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
                foodDishesService.updateFoodDishes(updateFoodDishesRest));
    }

    /**
     * METODO PARA CREAR PLATILLO
     * @param createFoodDishesRest
     * @return
     * @throws BookingException
     */

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "crear_fooddishes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<String> crearFooddishes(@RequestBody @Valid CreateFoodDishesRest createFoodDishesRest)
            throws BookingException {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
                foodDishesService.createFoodDishess(createFoodDishesRest));
    }

    /**
     * METODO PARA SABER CUALES PLATILLOS TIENEN MAS DE 3 INGREDIENTES
     * @return
     * @throws BookingException
     */

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "countplatos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<List<RestFoodDishesRest>> getCountPlatosIngredientMayorA3() throws BookingException {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", foodDishesService.getCountPlatos());
    }

}
