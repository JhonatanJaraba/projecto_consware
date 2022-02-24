package com.example.restaurant.demo.controllers;

import com.example.restaurant.demo.exceptions.BookingException;
import com.example.restaurant.demo.json.*;
import com.example.restaurant.demo.response.BookingResponse;
import com.example.restaurant.demo.service.FoodDishesService;
import com.example.restaurant.demo.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class IngredienteController {

    @Autowired
    private IngredientsService ingredientsService;

    @Autowired
    private FoodDishesService foodDishesService;

    /**
     * METODO PARA CREAR UN INGREDIENTE
     * @param ingredientsRest
     * @return
     * @throws BookingException
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "createingrediente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<String> createIngrediente(@RequestBody @Valid IngredientsRest ingredientsRest)
            throws BookingException {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
                ingredientsService.createingrediente(ingredientsRest));
    }

    /**
     * METODO PARA VER LA LISTA DE INGREDIENTES
     * @return
     * @throws BookingException
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "ingredientes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<List<ListaIngredienteRest>> getingredientes() throws BookingException {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", ingredientsService.getIngredientes());
    }

    /**
     * METODO PARA VER LA LISTA DE PLATOS
     * @return
     * @throws BookingException
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "listadeplatos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<List<RestFoodDishesRest>> getlistaplatos() throws BookingException {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", foodDishesService.getListaPlatos());
    }
    /*
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "listadeplatos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<List<ListaPlatosRest>> getlistaplatos() throws BookingException {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", ingredientsService.getListaPlatos());
    }
     */


}
