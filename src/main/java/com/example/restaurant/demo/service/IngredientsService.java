package com.example.restaurant.demo.service;

import com.example.restaurant.demo.exceptions.BookingException;
import com.example.restaurant.demo.json.*;

import java.util.List;

public interface IngredientsService {

    String createingrediente(IngredientsRest ingredientsRest) throws BookingException;

    public List<ListaIngredienteRest> getIngredientes() throws BookingException;

    public List<ListaPlatosRest> getListaPlatos() throws BookingException;
}
